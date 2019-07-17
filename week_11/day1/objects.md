# JS Objects

## Prerequisites
- JS functions lesson

## Learning Objectives
- Understand what objects are & their uses
- Be able to create object properties/attributes
- Be able to access object properties/attributes
- Be able to add and call methods on objects
- Be able to use _this_ (to access attributes of an object within that object's methods)

## Duration
- 1hr

## Intro to Objects

Javascript objects are quite different from objects in traditional OOP.

An 'object' in Javscript is simply a key-value store, a dictionary, Hash, HashMap, whatever you might call them in other languages, in JS, they're just called 'objects'. Like in all OOP, they are a core part of the language, and can be used to store data such as numbers, strings, arrays, and other objects.

However, because functions are 'first class objects' in JS, and can be passed around to different places just as easily as numbers, strings or any other value, a simple key-value store can be incredibly powerful. By simply creating a key on our object with a function as its associated value, we have added a method to our object. We can make JS objects just as powerful as classical OOP objects.


```sh
touch object_play.js
```

```sh
subl .
```

Let's create an object.

```js
var myPerson = {
  name: 'Guybrush',
  age: 32,
  weapon: 'cutlass'
};

console.log('my person', myPerson);
```

> (If covered a class based language eg Ruby)
How does the way we are creating an object differ from what we were doing in Ruby.
(Discuss)

We are creating a single object. In a class based programming language, we never create an object directly,  we always create a class and then create instance of that class.  Here we have created a single object. You could say Javascript is even more object orientated than traditional class-based OOP languages!

Today we are going to create single objects.  Tomorrow we will see how we can create multiple objects of the same type,  much how we would use a class.

## Accessing Properties

Once we create an object that contains some data, and store it in a variable, we can get that data back by using a dot `.` and the name of the property that we want.

```js
console.log( myPerson.weapon )
```

If we want to change the value associated with a key, we simply access the property and then reassign it with the assignment operator `=`

```js
console.log( myPerson )
myPerson.name = 'Guybrush Threepwood'
myPerson.age += 1
console.log( myPerson )
```

We can also add brand new properties in this exact same way

```js
console.log( myPerson )
myPerson.occupation = 'Mighty Pirate'
console.log( myPerson )
```

## Methods

Okay cool, we can create objects that have these data attributes for state. But what about giving it methods for behaviour.

Functions in JS are just objects, we can assign them to variables.

```js
var add = function(a,b) {
  return a + b;
}
console.log( 'the return value is ' + add(1,2) );
```

Just like we can assign function to a variable, we can assign it as a value in our object.

```js
var myPerson = {
  name: 'Guybrush',
  age: 32,
  weapon: 'cutlass',
  talk: function() {
    console.log('shiver me timbers Im alive');
  }
};
```

By assigning the function to the object we have given our object a method that we can call by accessing the property with the `.` syntax and adding invocation brackets `()`

```js
myPerson.talk()
```

## _this_

If we wanted our person object to be able to say their name? It needs to be able to access it's attributes or other methods.

We can do this using the `this` keyword.

The `this` keyword allows us to access the other attributes of the object.

```js
talk: function() {
  console.log( 'shiver me timbers Im alive, my name is ' + this.name  );
}
```

## Alternative syntaxes

### Creating Objects

Most commonly we'll create objects using the 'object literal' `{}` syntax

However there are some other ways we can do the same thing.

```js
var object = {};
var anotherObject = Object.create(null);
var yetAnotherObject = new Object();

console.log(object, anotherObject, yetAnotherObject);
```

When we `console.log` these out, we can see they are all the same, just standard, empty JS objects.

`Object.create` can do some cool stuff, but we'll look at that later, and we'll see why we have to pass it `null` as well.

### Accessing Properties

As well as the dot syntax `.key`, we can also access properties on objects with square brackets `['key']`

```js
console.log( myPerson['name'] )
```

All keys on JS objects are strings, this is why we don't have to use quotes when using the dot syntax, JS knows it's always a string.

We do have to use quotes when using the square bracket syntax. This might seem like it's just uglier and more difficult to type. However, it can actually be really useful, because it allows us to access a property by a key string that's stored in a variable.

```js
var keyToAccess = 'age'
console.log( myPerson[keyToAccess] )
```

This allows us to, for example, loop through an array of keys and access them each in turn, without having to know exactly what those keys are when we write our program.

```js
var keys = Object.keys(myPerson)


for (key of keys) {
  console.log('key:', key, 'value:', myPerson[key])
}
```

The `Object.keys` method we're using here takes an object and returns us an array of strings which are all of that object's keys.

```js
console.log(keys)
```

## Exercise

Create a bear object that has a type, a name, a belly and an eat method. The eat method should add something to the bear's belly.

SOLUTION:

```js
var bear = {
  name: "Baloo",
  type: "Grizzly",
  belly: [],
  eat: function(fish) {
    this.belly.push(fish);
  }
};

bear.eat("A fish!");
console.log(bear.belly);
```
