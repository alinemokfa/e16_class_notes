# JS Scope

## Learning Objectives
- Describe scope of local variables
- Describe scope of global variables
- Explain local variables come first in the function scope chain.
- State the importance of using var
- Describe the scope of closures
- Create a closure that uses a variable from an outer function.

## Duration

1h

## Function scope

Variables created in functions have function scope,  they can be seen anywhere inside the function but nowhere else.

We can't see them directly outside the function.

```js
var talk = function() {
  var name = "Rick";
  console.log('My name is' + name);
};

console.log( 'trying to access result' + name );
```

Or from another function

```js
var talk = function() {
  var name = "Rick";
  console.log('My name is' + name);
};

var walk = function() {
  console.log( name + 'is walking' );
};

walk();
```

## Global variables

Variables which are defined not inside a function have global scope. They can been seen anywhere.

Let's see how we access a global variable from within a function.

```js
var name = 'Jay';//global

var talk = function() {
  console.log('My name is ' + name);
}

talk();
```

If we define a local variable it will take priority in our function over the global variable - shadowing.

```js
var name = 'Jay';//global

var talk = function() {
  var name = 'Rick';//local
  console.log('My name is ' + name);
}

talk();
console.log('the global name', name);
```

If we forget to use var,  then instead of creating a new local variable the global variable will be reassigned.

```js
var name = 'Jay';//global

var talk = function() {
  name = 'Rick';//resassigning global
  console.log('My name is' + name);
}

talk();
console.log('the global name', name);
```

Horribly,  even if we don't have a global and we forget var, then  JS will not make a fuss and assign a new global.   Errrgghh.  

```js
var talk = function() {
  name = 'Rick';//assigning global
  console.log('My name is ' + name);
}

talk();
console.log('the global is ' + name);
```

## Task: 
> 15 mins

What do we think the output will be here?

```js
var globalVariable = 99;

var separateFunction = function() {
  var separateA = 2;
};

var outerFunction = function() {
  var outerA = 1;
  var innerFunction = function() {
    console.log('outerA ', outerA);
    console.log('globalVariable', globalVariable)
    console.log('separateA ', separateA);
  };

  innerFunction()
};

outerFunction();
```
