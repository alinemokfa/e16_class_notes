# Arrays?

### Learning Objectives
1. Explain what arrays are
2. Create an array
3. Access an element from an array
4. Add items to arrays
5. Call array methods


We've been dealing a lot with single objects - a person, a number. Just as with real life, we don't always have one of something - we could have a group of things. At home we don't just have one piece of food, we have many. We don't have one pair of shoes, we have many. So how do we represent this in our code?

This is where Arrays come in. An array is part of a subset of objects known as "collections". It is essentially a storage container like a big basket, or bag, or box. In real life we might be storing fruit, shoes or sweets but in our code we can store any object we like of any of the datatypes we have seen - integers, strings, even booleans.

The key thing about arrays is that they are 'indexed', that is, you can access the things inside it by their index. It's all very well having a shopping bag full of fruit, but how do we find an apple in there? We'd have to search through every other item until we found it.

It's kind of like our lockers. They are ordered top to bottom and if we put items in them, even though we can't see them anyone we know which locker they are in. As long as noone comes along and reorders our items without us knowing, we can always guarantee our items are in the same locker we left them.


## What are arrays for in programming

Given an array is a collection, we use them when we want to collect related items together to do useful things with them. Maybe we want to have a set of people's names or a list of lottery numbers. We can pass this around our program and do interesting things with it - most notably use loops to do repeated actions to every item in the set. We call this "enumerating".

This is such important, useful functionality that we'll cover it in a whole dedicated lesson.


## What are they not for

Arrays are pretty dumb, all they know is where something is in the list and no other information. It has no idea that the second item is a banana, or that bananas are yellow. It knows if it has an item at position 2 or not and that's about it.

So if we wanted to find Rick's locker and we didn't know which position it was in, we have no other information to help us. We'd need to go through each one until we found it. Later on you'll see why using a hash would be a more efficient way to do it.

## Accessing arrays

All "keys" to an array are integers, we call this the "index". The first element in an array is at index zero, and the amount of elements can generally go up as high as your computer/programming language will allow. Some languages require that you specify how big is each new array you use (to know how much space to allocate in memory), but Ruby is a bit more flexible, and will grow arrays automatically to fit as many items as you add to it.

So what does this look like?

```ruby
# irb
fruit = ['apple', 'banana', 'grape', 'orange']
```
Arrays are characterized by the square brackets around the elements.

Array indexes in most programming languages start at 0 (the reason for this is a discussion for another day).

```ruby
fruit[0]
fruit[2]
fruit[4] # what would you expect this to return?
```

Unlike many other languages, Ruby lets us access elements from the end of the array using a negative index too

```ruby
fruit[-1]
fruit[-2]
```

There are also some helpful utility "methods" (we will cover this later - just now let's accept that arrays come with some helpful magic) to allow us to do this.

```ruby
fruit.first
fruit.first(2)
fruit.last
fruit.last(2)
```

## Creating an empty array

There will be times where you want to initialize an empty array. We can do this in several ways, including

```ruby
my_array = []
my_array = Array.new
```

## Adding and Removing items

We will so often need to add and remove items from arrays, that there are numerous ways to do it.

We can do assignment by index like we were doing to access the array

```ruby
fruit[1] = 'mango' # notice that this overwrites whatever was already there -- any existing value is gone for ever (like re-assigning a variable)

fruit[100] = 'peach' # think about what the `fruit` variable might look like now... then see
```

We can add/remove to the end of the array.

```ruby
fruit.push('pear')
fruit.pop
fruit << 'pear' # referred to as the "shovel" operator
```

And to the start of the array.

```ruby
fruit.shift
fruit.unshift('apple')
```

And of course, by index.

## Array elements

Elements can be *any* type of object; literal values or variables. Unlike other languages, Ruby allows us to put a mixture of different kind of objects in an array.

```ruby
fruit_and_numbers = [ 'apple', 1, 'grape', 2 ]
```

We can even put arrays inside of arrays.

```ruby
fruit = [ 1, 2, 3, 4, [5, 6, 7] ]
```


https://ruby-doc.org/core-2.4.1/Array.html
