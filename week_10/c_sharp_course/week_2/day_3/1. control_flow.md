# JS Control Flow

## Learning Objectives
- Demonstrate using:
  - if statement
  - else
  - else if
  - switch
  - ternary

# Control Flow

Sometimes we need to make decision in our code, there are language constructs allowing us to do this.
Let's start to write our code in a file instead of in the terminal since it gets a bit unweildy.

```
subl app.js

```

## IF statements

```js
# app.js
var myName = "Matthew";

if (myName === "Matthew") {
  console.log( "yo " + myName );
}

```
To run it, we type "node" followed by the file name.


We can add an else condition

```js
var counter = 1;

if (counter > 0) {
  console.log("The counter is greater than 0");
} else {
  console.log("The counter is less than or equal to 0");
}
```
Then there is the dreaded else if.

```js
var counter = 1;

if (counter > 0) {
  console.log("The counter is greater than 0")
} else if(counter < 0) {
  console.log("The counter is less than 0")
} else {
  console.log("The counter is 0")
}
```

This quickly gets unwieldy and leads us nicely onto switch statements.

## Switch Statement

Switch statements can be used when we have multiple decisions to make in our code.

```js
var pet = "cat";

switch (pet) {
  case "cat":
    console.log("Soft kitty, warm kitty, little ball of fur.");
    break;
  case "dog":
    console.log("Who let the dogs out.");
    break;
  default:
    console.log("No pet, sad.");
}
```

## Ternary Operator

These are exactly the same as in Ruby.

```js
1 + 1 === 2 ? "yay, maths!" : "noes, maths is broken.";
```
