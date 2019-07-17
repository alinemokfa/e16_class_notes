# Loops

## Learning Objectives
- Write a for loop to access elements for array
- Use a while loop
- Write a for of loop to access array
- Write a for in loop to access an object

We have some options for looping in JavaScript.

## Traditional For Loop

The traditional for loop uses a counter for it's exit condition.
This is seen in many programming languages

```js
var pets = ["dog","cat","pika"];

for (var i = 0; i < pets.length; i++) {
  console.log(pets[i]);
}
```

## For Of

We can also use the "for of" style loop for arrays.

```js
var pets = ["dog","cat","pika"];

for (var pet of pets) {
  console.log(pet);
}
```

We can also use ***for in*** to loop round an object. Use ***for in*** for looping round object key value pairs.

## For In

```js
var obj = {student1:3, student2:12, student4:30};

for (var key in obj) {
  console.log("obj." + key + " = " + obj[key]);
}
```

## While

We also use a good old while loop (watch out for infinite loops!).

```js
var x = 0;

while (x < 10) {
  console.log("loop" + x);
  x = x + 1;
}
```
What would happen if we didn't increment the counter?

We can use a special operator instead of x = x + 1

```js
x++;
```

## Enumeration forEach, map, filter
Enumeration is becoming more and more popular in JS, each, map, filter etc.
We'll see this later this week and the how we can achieve it.
