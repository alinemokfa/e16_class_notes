# Arrays

### Objectives
1. Explain what arrays are
2. Create an array
3. Access an element from an array
 
### Duration
 
1/2 hour

## Arrays?

We've been dealing a lot with single objects - a person, a number. Just as with real life, we don't always have one of something - we could have a group of things. At home we don't just have one piece of food, we have many. We don't have one pair of shoes, we have many. So how do we represent this in our code?

This is where Arrays come in. An array is part of a subset of objects known as "collections". It is essentially a storage container like a big basket, or bag, or box. In real life we might be storing fruit, shoes or sweets but in our code we can store any object we like of any of the datatypes we have seen - integers, strings, even booleans.

The key thing about arrays is that they are 'indexed', that is, you can access the things inside it by their index. It's all very well having a shopping bag full of fruit, but how do we find an apple in there? We'd have to search through every other item until we found it.

It's kind of like our lockers. They are ordered top to bottom and if we put items in them, even though we can't see them anyone we know which locker they are in. As long as noone comes along and reorders our items without us knowing, we can always guarantee our items are in the same locker we left them.


## What are arrays for in programming

Given an array is a collection, we use them when we want to collect related items together to do useful things with them. Maybe we want to have a set of people's names or a list of lottery numbers. We can pass this around our program and do interesting things with it - most notably use loops to do repeated actions to every item in the set. We call this "enumerating".

## What are they not for

Arrays are pretty dumb, all they know is where something is in the list and no other information. It has no idea that the second item is a banana, or that bananas are yellow. It knows if it has an item at position 2 or not and that's about it.

So if we wanted to find Rick's locker and we didn't know which position it was in, we have no other information to help us. We'd need to go through each one until we found it.

## Declaring an Array

When we declare an array variable in C# we need to declare the type of things that go into the array, followed by square brackets then the name of the array variable e.g. 

```csharp
string [] fruit;
```

This means that strings and ONLY strings can be kept in this array.

## Initialising an Array

When we initialize an array we need to use the ```new``` keyword (just like when we create in instance of a class)
> perhaps mention that an array is a reference type. Talk about reference types if you haven't already done so.

We need to give the array a size and it can only be of this length. So let's say our array is going to contain 5 items, we would write:

```csharp
fruit = new string[5];
```

The array is not empty - it is already populated with 5 null entries. This will become important later.

We can also initialise an array with default values by including a comma-separated list inside a set of curly brackets e.g:

```csharp
string[] fruit = new string[5] { "apple", "pear", "orange", "banana", "pineapple"};
```

## Accessing arrays

All "keys" to an array are integers, we call this the "index". The first element in an array is at index zero, and the amount of elements can generally go up as high as your computer/programming language will allow. 

```ruby
string f1 = fruit[0];
string f2 = fruit[2];
string f3 = fruit[4]; # what would you expect this to return?
```

Arrays are characterized by the square brackets around the elements.

Array indexes in most programming languages start at 0 (the reason for this is a discussion for another day).