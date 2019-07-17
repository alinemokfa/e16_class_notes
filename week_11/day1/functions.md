# JS Functions
[i]: Roughly 1 hour:  30 min code along, 30 min exercise

## Learning Objectives
- Create a basic function
- State that functions are objects
- Assign a function to a variable
- Call a function
- Anonymous functions
- Demonstrate use of arguments/paramaters
- Relaxed argument/parameters
- Explicit returning.

What is a function?

A function is a piece of code that we can reuse to do a task. Let's see how we can write a function in JS.

### Anatomy of a function

> DRAW ON BOARD

![function anatomy](function_anatomy.png)


### Creating a function

Let's make our first function.

```
# terminal
touch function_play.js
subl function_play.js
```

We're going to make a little function that prints "hello everyone" to the terminal window.

```js
// function_play.js
function hello() {
  console.log("hello everyone");
}

hello();
```

In JS we ***need*** to use the brackets to call the function.

## Returning

Just like Ruby and Java, Terminal output is not testable in JS. Let's modify our function so that it returns a value instead.

```js
function hello() {
  return "hello everyone";
}

console.log('the return value is', hello());
```

## Arguments and Parameters

Since we often need information passed into our function from the outside world, we need to be able to define parameters and pass arguments to our functions.

Let's create a function that prints our name and mood to the terminal.

```js
function mood(name, mood){
  console.log(name + " you are: " + mood);
}

mood("valerie", "sad");
```
What happens if we don't provide this argument?

```js
mood("valerie")
```

Notice that no error was thrown. JavaScript is being chilled again. It's quite happy if we don't pass arguments for all the parameters that are defined in the function.  It will just set the missed out parameters as undefined.


[Task]:
Make a third argument that passes the current weather conditions, and can say "valerie, it is sunny and you are sad"

```js
function mood(name, mood, weather){
  console.log(name + " you are: " + mood + " and it is " + weather);
}

mood("valerie","sad", "sunny");
```

### Unspecified arguments

What do you think will happen if we do this?

```js
function add(a,b) {
  return a + b;
}

console.log( 'the return value is ' + add(1,2,3) );
```

If the number of arguments passed into a function is greater than the number of parameters stated,  it will just ignore the extras.

### Variable number of arguments

We can use the keyword 'arguments' to get all the parameters that were passed to a function. This allows us to write functions that can have a variable number of parameters.

```js
function sum() {
 var i, total = 0;
 for (i = 0; i < arguments.length; i += 1) {
   total += arguments[i];
 }
 return total;
};

console.log(sum(1,2,3,4))

```

## Functions and variables

So far, we have seen that you can name a function, and then invoke this function by using it's name and brackets after it. This is pretty standard in many programming languages.  

In JS, we have another option. We can assign a function **definition** to a variable. Not the result of the function - the actual function **itself**.

> Not assigning to a variable,  is called a function declaration,  assigning is called a function expression.

```js
//function_play.js
var hello = function() {
  console.log('Hello!');
}
```
Here, we have stored the function in a variable called hello. How do you think we invoke it?

```js
hello();
```

What on earth is going on here? It is important to understand the distinction between declaring a function and invoking a function. In the declaration, the stuff in the variable, we are saying what this function should do and what it needs but we are not actually invoking it. This happens later, when we append the () to it. The function declaration is itself an object!

Try rewriting our mood function so that it gets assigned to a variable.

```js
var mood = function(name, mood, weather){
  console.log(name + " you are: " + mood + " and it is " + weather);
}

mood("valerie","sad", "sunny");

```

### Anonymous Functions

When the function is assigned to a variable, it doesn't have a normal method signature. We are not giving it an explicit name. The only name we use is that of the variable.

We call this an "anonymous function" since it doesn't have it's own name in the method signature.

Let's have a think about this for a second.

```js
function() { console.log("hi"); }
```
How would we invoke this function? We can't. It has no name and it's not being stored in a variable to invoke later.

This is why we either need to give it a name, assign it to a variable or pass it as a function argument(more on this later). Otherwise it is useless.

We can also pass a function as an argument to other functions!

```js
var add = function(a,b) {
  return a + b;
};

var wow = function(functionToInvoke) {
  console.log(functionToInvoke(2,1));
};

wow(add);
```

Pretty mindblowing right?

## Exercise
> 20 mins for exercise 10 min review.

- Create a function that takes in the first name and surname, and speaks eg "Howdy, I am Rick Henry"
- Create a multiply function, returning the result.
- Create a function that takes in an array and returns the first element.
- Create a function that takes in a list of names of any length, and prints them all to screen.
- Create an array of animal names and a function that adds the animals to a farm array and prints the names to the console.
