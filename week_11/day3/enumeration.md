# Enumeration

## Intro

```bash
touch enumeration.js
subl .
```

Looping through arrays is something we find ourselves needing to do quite a lot.

We can do it like this:

```js
var numbers = [1, 2, 3, 4, 5];
for (var number of numbers) {
  console.log('the number is:', number);
}
```

In ruby, we had methods on the `Array` class like `.each` and `.map`. They're
methods which handle looping through the array for us.

```ruby
# irb
numbers = [1, 2, 3, 4, 5]
numbers.each { |number| puts number }
```

We pass these methods a 'block' `{ |number| puts number }`, and the `.each` 
method passes each array element in to our 'block', so we can do whatever we 
need to with them in our block.

Javascript also allows us to do this using methods that take callback functions.
It's works similarly to how the enumerable / block methods work in Ruby, but in 
JS we pass a function instead of a 'block'.

```js
var numbers = [1, 2, 3, 4, 5];
numbers.forEach(function (number) {
    console.log('the number is:', number);
  });
```

`forEach` is a method defined on Arrays in JS. It lives on `Array.prototype`

It takes the function that we pass it, and calls it for each element in the 
array. It handles looping through the array for us, and passes our callback the 
current item in the array as an argument.

`forEach` is considered a 'higher order function' because it take a function as 
an argument.

We can pull out the function to a variable and pass that in as an argument to 
`forEach` if we want to

```js
var numbers = [1, 2, 3, 4, 5];
var printNumber = function (number) {
  console.log('the number is:', number);
}
numbers.forEach(printNumber);
```

This is doing the exact same thing as the previous example in the exact same 
way. You will often see an anonymous function being defined and passed straight 
in to a higher order function's arguments. If extracting it to a variable before 
passing it in makes it more clear what's going on, it's totally fine as well.

## Writing our own forEach
> Let class do as exercise if going well.

To really understand what a forEach is doing, we can write our own. Ours will 
work a little differently because it won't be a method on `Array`.

Let's make our version take an array as it's first argument and the callback 
function to invoke for each element as the second argument.

```js
var ourForEach = function (array, callbackForItem) {
  for (var item of array) {
    callbackForItem(item);
  }
};

var numbers = [1, 2, 3, 4, 5];

ourForEach(numbers, function (number) {
  console.log('the number is:', number);
});
```


## **_this_** in callback functions
Let's write a wee Bank constructor, with a method to add up the values of all 
accounts and store it on the bank.

```bash
touch bank.js
```

```js
var Bank = function () {
  this.accounts = [250, 250, 500, 500, 500];
  this.total = 0;
}

Bank.prototype = {
  calculateTotal: function () {
    this.total = 0;
    this.accounts.forEach(function (account) {
      this.total += account;
    });
  }
}

var bank = new Bank();
console.log('total before:', bank.total)

bank.calculateTotal();

console.log('total after:', bank.total)
```

The total's still 0, what's happened here?

Inside our callback function, **_this_** is not what we expected. We want it to 
be a reference to our Bank object, so that we can add each account value to the 
bank's `total` property.

In JS functions, the value of **_this_** is determined by the function's **execution
context**.

Our callback function is not actually executed in the context of our 
bank object. We pass the anonymous function to the Array method `forEach`, and 
it's the `forEach` method that executes our function.

This causes us to lose track of the bank object. (which is our function's 
**definition context**, but not it's **execution
context**)

We can always check what **_this_** is by printing it out in the console:

```js
setTotal: function() {
  this.total = 0;
  this.accounts.forEach(function(account) {
    this.total += account;
    console.log(this);
  });
}
```

This is an internal object in node, we don't need to worry about what it is. 
But it's certainly no use to us, we wanted a bank, not this mess. We just need 
to be aware that **_this_** is not what we might expect.

So how can get around this issue?

## `.bind()`

We're going to use a method called `.bind`, which let's us decide what the 
value of **_this_** is inside our function.

We're going to call this method *on* our anonymous function, which looks really
weird, just trust it for now.

```js
setTotal: function() {
  this.total = 0;
  this.accounts.forEach(function(account) {
    this.total += account;
    console.log(this);
  }.bind(this)); // UPDATED
}
```

If we run our file again, we can see that the total is being added up correctly.

Let's take a closer look at what's going on with this weird `.bind` thing.

> If this becomes too much detail, just skip the rest.

Functions in JS are like any other object, this is why we can store them in 
variables and pass them in to other functions as arguments.

This also means that functions can have methods and properties, just like any 
other JS object. `.bind` is a method that lives on the `Function.prototype` 
object.

`.bind` takes the function that it's called on, and makes a copy of it, and 
returns that clone of the original function, but with the value of **_this_** 
set to whatever object that we pass as the argument to `.bind()`.

This is why we pass in **_this_** as the argument to `.bind`. We want the 
**_this_** value used **inside** the callback function to be the same as it is 
**outside** the callback (in our bank's `setTotal` method). After the closing 
curly bracket `}` of the callback, the function definition is over, so we're 
back in the context of the setTotal method, out here, **_this_** is definitely 
going to be the bank object, as we expect. So if we pass _that_ **_this_** into 
`.bind`, then the value of _that_ **_this_** (the bank) will be the **_this_** 
value inside the callback function that forEach executes

> End of complex explanation

This is really hard to get your head around. Don't worry, all you really need 
to know is that when using callbacks inside our object's methods, we need to 
add `.bind(this)` to the end of the function definition so that **_this_** 
works.


## Enumerable methods

Using enumerable methods rather than looping is becoming more and more popular 
in the Javascript community.

You can read about the different enumerable methods that are available on the 
[Array documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array)

You might want to take a look at these methods in particular:

`.forEach`
`.map`
`.filter`
`.find`
`.some`
`.every`
`.reduce`

We're going to practice using these methods to solve problems by adding more 
functionality to our Bank.

## Enumerable Bank Mini-Lab

Make the tests for the Bank pass using enumeration methods.
> Hand out start point for lab

Bank should be able to:

- Find the total value of all accounts.
- Add 10% interest to the value of all accounts.
- Find the account with the largest value.
- Find the average value of all account.
