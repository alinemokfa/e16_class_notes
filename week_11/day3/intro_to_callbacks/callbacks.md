# Callbacks and Higher Order Functions

### Learning Objectives
- Understand callbacks
- Understand higher order functions
- Understand functions as first class objects
- Passing functions as arguments

## Higher Order Functions

Higher-order functions either take a function as an argument or return a function as output. A callback is a function as an argument.

Because functions are *first class objects* in JavaScript, they can be referenced by variables and passed around just like variables.

Let's create a directory. 

```
mkdir higher_order_functions
cd higher_order_functions
touch higher_order_functions.js
```

Here's an example of taking a function as an argument.

```
setTimeout(function() {
  console.log("I waited for 1 second");
}, 1000);
```

So here the first argument is the callback and the second is a value in milliseconds. setTimeout is a built in JavaScript function and we're using it here to illustrate how callbacks behave. 

In the example above, the callback is an *anonymous* function. It has no name and is passed in at the same time that it is defined.

There are 2 ways to pass a function to another function:
1. An anonymous function
2. A named function

## Calling Functions Within Functions

Let's pass some functions into another function and call them.

Let's say we had two simple functions that simply log something out to the console.

```
var logRed = function() {
  console.log("It's red!");
}

var logNotRed = function() {
  console.log("It's NOT red!");
}
```

We could then use these functions in another function. How?

In this case we will be using these *named* functions rather than passing *anonymous* functions.

Let's create a function that determines if a string is "red" or not.


```
var redChecker = function(colour, isRed, isNotRed){
  if(colour === "red"){
    isRed();
  }
  else{
    isNotRed();
  }
}
```
At the moment, we have simply declared a function. It's parameters have no value yet and the body of the function hasn't been executed.

NOTE: We are not calling (invoking) the functions when they are passed in. We call them inside the function.

So if we wanted to use this function we could call it (invoke it) like this.

```
redChecker("red", logRed, logNotRed);
```

What will this function do? What if we called it with a different argument?

```
redChecker("blue", logRed, logNotRed);
```

## Passing Arguments to Callbacks

OK, so what if we want to pass an argument to a callback? Say we wanted to pass in the message that prints out in logRed?

Let's alter our logRed function.

```
var logRed = function(message) {
  console.log(message);
}
```

Now, we can add a 'message' parameter to redChecker.

```
var redChecker = function(message, colour, isRed, isNotRed){
  if(colour === "red"){
    isRed(message);
  }
  else{
    isNotRed();
  }
}
```
And invoke it with a message string.

```
redChecker("Print out this new message please!", "red", logRed, logNotRed);
```

## Callback Exercises

1. Write a function, *functionCaller*, that takes a function (myCallback) and a number as parameters. The *functionCaller* returns myCallback called with the number (as an argument).

2. **Maths Fun:** Write two functions *increment* and *square*. *increment* should take in a number and return the number plus 1. *square* should take in a number and return it multiplied by itself.

  Write another function called *doSomeMathsForMe* that takes in a number (*n*) and a function (a callback) and executes the callback, passing in *n* as an argument.

  Invoke *doSomeMathsForMe* by passing it a number and the *increment* and/or *square* function.
