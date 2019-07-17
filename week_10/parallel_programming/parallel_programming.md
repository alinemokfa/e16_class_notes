# Multithreading

## Learning Objectives

- Know what threading is
- Understand how using threads can help us manage long running, expensive, operations
- Be able to use threads in Ruby, via the Thread class

## Introduction

Today we're going to talk about multithreading, also known as parallel computing. Before we can appreciate what multithreading is, let's think about how a simple program runs.

Let's consider the following simple program:

```ruby
# script.rb
question = 'Who should I say hello to?'
puts question
input = gets.chomp
while input != 'quit'
  puts 'Okay!'
  puts "Hello, #{input}"
  puts question
  input = gets.chomp
end
```

This code repeatedly asks for names to say hello to, until the user asks it to quit. It's not super complicated, nor particularly unusual. So why are we looking at it?

Let's imagine for a moment that instead of just `puts`ing the hello string we have to do a long-running operation. Maybe instead of saying hello we want to hit [FOAAS](https://www.foaas.com)?

So let's say we do that. Now what if we decide we want to quit the application before the content has downloaded from the server? Well, too bad. Our `'quit'` command is going to be ignored until the line that's downloading content is done.

Maybe you think that's not such a big problem. Now imagine that happening on a mobile app. The entire user interface freezing until the content has finished downloading. This is hardly ideal.

In general, this is what threading is used for. We break long running operations off into separate 'threads' where we can do the work without interrupting other important jobs.

Some examples of when we might use threading are:
- UI programming (as we've already seen)
- intensive computations
- network requests
- handling push notifications while another app is on screen

## Example

Let's look at another simple Ruby app.

```ruby
# app.rb
def puts_later(string, seconds_to_wait)
  sleep(seconds_to_wait)
  puts string
end

puts "Hi"
puts_later "bye", 4
puts "What's up?"
```

This defines a method, `puts_later` which will `puts` out a string after waiting for some specified time. Running the code, we get:

```bash
# terminal
Hi
bye
What\'s up?
```

> Ask if this makes sense?

Really this isn't quite what we want. We asked "bye" to `puts_later` but we just asked "What's up?" to `puts`. Why does this happen?

When we `sleep` in the `puts_later` method we stop the entire program for 4 seconds.

So how do we get what we want? That is, how do we get it so that we delay the `puts` by the right amount of time, without blocking the entire app from running?

We use `Thread`s, of course!

We create a `Thread` class in Ruby the same way we create any other class. By calling `.new` on it. In `Thread`'s case, `.new` takes one argument: a block which tells the thread what to do. (Remember Ruby blocks? Good times.)

```ruby
def puts_later(string, seconds_to_wait)
  Thread.new do
    sleep(seconds_to_wait)
    puts string
  end
end

puts 'Hi'
puts_later 'bye', 4
puts "What's up?"
```

Running this code we get:

```bash
# terminal
Hi
What\'s up?
```

Err, that's not entirely right, is it? What's going on? We kick the thread off and tell it to `sleep` for four seconds, and then print the output, but then the script finishes running, and so we never see anything get printed.

Is there a solution to this? Of course! We just tell the main thread of the program to wait for the other thread before it finishes.

To do this, we need to grab a reference to the new `Thread` we create, and then call the method `.join` on it. We call this on the main thread, which then tells it to wait until the other thread is finished before continuing. Let's look at how that works...

```ruby
def puts_later(string, seconds_to_wait)
  Thread.new do
    sleep(seconds_to_wait)
    puts string
  end
end

puts "Hi"
thread = puts_later "bye", 4
puts "What's up?"

thread.join
```

And running that:

```bash
# terminal
Hi
What\'s up?
bye
```

It works!

We can `puts_later` as many times as we want, but we need to remember to `join` the thread again at the end of the script, otherwise it could finish without running everything.

> Note that this is note always the case. For example, in a Sinatra app or other long-running Ruby process, we can often assume that the app will still be running when the `Thread` is done.

```ruby
puts 'Hi'
bye_thread = puts_later 'bye', 4
puts "What\'s up?"
late_thread = puts_later 'Am I late?', 3

bye_thread.join
late_thread.join
```

> Note how odd the order of execution is here. `late_thread` is started later than `bye_thread` but sleeps for less time, so it gets printed out first.

## Exercise

Take the following Ruby code, and make it possible to quit the app while waiting for a calculation to finish.

[Hint]: Run the code to see what it does
[Double hint]: Numbers over 40 should take a decent amount of time to compute
[Triple hint]: Use Threads...

```ruby
def fib(n)
  return 1 if n < 3
  return fib(n - 1) + fib(n - 2)
end

question = 'Which Fibonacci number would you like to know?'
puts question
input = gets.chomp

while (input != 'quit')
  puts 'Thinking...'
  num_to_calc = input.to_i
  result = fib(num_to_calc)
  puts result
  puts question
  input = gets.chomp
end
```

## Solution

```ruby
def fib(n)
  return 1 if n < 3
  return fib(n - 1) + fib(n - 2)
end

question = 'Which Fibonacci number would you like to know?'
puts question
input = gets.chomp

while (input != 'quit')
  puts 'Thinking...'
  num_to_calc = input.to_i
  
  Thread.new do
    result = fib(num_to_calc)
    puts "Fibonacci number #{num_to_calc} is #{result}"
  end
  
  puts question
  input = gets.chomp
end
```

## Example: Mobile Apps

Threading used to be mainly reserved for high-performance applications. It wasn't really a worry for simple apps.

In fact, years ago, most folk thought processors would keep getting faster and faster and we'd never have to care about using threads to run code separately. But then processors stopped getting faster, and multi-core processors became the cool new thing.

With multi-core processors, a programmers' ability to write threaded code became more important. By splitting work out onto threads they could take advantage of multiple processor cores at the same time, and therefore write faster applications.

> This isn't really true of Ruby's threads. Though it's not a distinction that we really need to make right now.

Nowhere is the importance of utilising multiple cores more notable than on mobile devices.

### Why?

On iOS and Android devices, all UI operations are carried out on the main thread. When a user taps a button, a method gets called on the main thread. When we want to update some text on screen, that needs to happen on the main thread. If this doesn't happen (i.e. if we try to update UI from a 'background' thread) we can get some really weird errors and possibly even crashes.

So what happens if we need to perform a really long-running operation when a user clicks a button? Let's see...

> Open and/or hand-out iOS Fibonacci project.

This app calculates Fibonacci numbers for a given input. The user types in the number, then presses "Go" and the app does some work.

If we look at the code, we can see that the work happens in the `fib` function, which is called on the main thread. Looks good, right? Let's test it out.

Question: What's the time complexity of the `fib` function?

Answer: `O(2^n)`

Run app. It works for smaller numbers (<30 mostly fine). Now try 40, or 50.

What happened? The entire UI of the app froze. We can't click the text field, we can't re-click the button. It's just broken.

This is because our long-running calculation is happening *on the main thread*. The calculation takes a while to finish, but when it eventually does the app will return to normal. The reason we can't interact with the app is because the entire main thread is taken up by the running Fibonacci code.

> This is an awful Fibonacci algorithm. Better algorithms are available.

This is a real issue in mobile apps. Any serious work done on the main thread is going to absolutely kill performance. So you absolutely *need* to use threads to handle things like network requests, parsing complicated JSON, doing large computations etc.

> You end up doing a sort of 'threading dance' when doing expensive work on mobile. That is, you jump off the main thread, run the code, then jump back onto the main thread so you can safely display the results to the user.

## A Warning: Race Conditions

> For this code to work properly we'll need to use JRuby. This is because MRI Ruby `Thread`s don't get run in parallel. This normally isn't important for teaching them, but in this one case it's necessary.

```bash
# terminal
rbenv install jruby-9.0.0.0
mkdir ruby_test && cd ruby_test
rbenv local jruby-9.0.0.0
```

There's one thing to be very careful with when using threads, though. Race conditions!

The easiest way to explain race conditions is just to show an example. Let's look at the following code:

```ruby
def increment(n)
  n + 1
end

sum = 0

threads = (1..10).map do
  Thread.new do
    100_000.times { sum = increment(sum) }
  end
end

threads.each(&:join)
puts sum
```

So this code just counts up the numbers from 0 to 1 million. It splits the work across ten threads, each adding 100,000 to the sum.

Let's run it!

> Run it. The output won't be 1 million.
> Run it again. The output won't be 1 million, or the same as the previous output.

Whaaaat?

This right here is a race condition. Here's what happens:

* We create `sum` on the main thread, and set it to `0`.
* We create a new thread. It gets the value of `sum` and adds `1` to it.
* While that's happening, yet another new thread has been created. It gets the value of `sum`. When it does this, two things can happen: either the first thread has finished setting the new value, or it's still in the process.
* If the first thread is done, then we're good.
* If it's not done, the second thread still thinks `sum` is `0` and so sets it to `1`.
* This whole thing happens over and over again, and the problem just compounds over time.
