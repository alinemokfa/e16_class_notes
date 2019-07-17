# JS Variables Types

## Learning Objectives
- Declare/assign/re-assign a variable
- Describe the different types in Javascript
- Demonstrate using typeof
- Show JS is dynamically and weakly typed.
- Describe the Truthy/Falseness of primitives/object

## Duration

1hr - 1.5hr

# Variable Assignment

Programming in Javascript follows the same pattern as programming in most other programming languages.   Creating things/objects and assigning a variable to them so we can reference.

Let's play around with talking Javascript using our nice friend the node interpreter

To represent text we use single or double quotes.  This creates a string for us.

```js
"something we want to hold on to";
```

## Let's create a play file

```
touch js_types.js
```

How can we retrive our string?  We can't! This object is essentially lost to us.

Variables allow us to keep a reference to our objects.

When we create variables in JavaScript we use the keyword "var" and then the name for what we want to call the variable.

```js
var myString = "something we want to hold on to";
```

We can then use this reference to get our string.

```js
console.log(myString);
```

Javascript often tries to be helpful.  If we forget to use var it won't complain.  It will make it a global. This is a design flaw and a nuisance. We'll explain why later.  Always use var!


# Types

Unlike Ruby, not everything in JavaScript is an object.

The latest JavaScript standard has 6 primitive types:

- `number`
- `string`
- `boolean`
- `null`
- `undefined`
- `symbol` (not covered here)

These primitives behave as if they were objects however, and you can call methods on them, e.g.:

```js
(5).toString()
```

This is because the primitives have corresponding object types, e.g.:

- `Number`
- `String`
- `Boolean`

## `typeof`

The `typeof` operator gives us the type of a variable, as a string.

```js
typeof 1 === 'number'
typeof 'some text' === 'string'
typeof undefined === 'undefined'
typeof null === 'object'
```

## Dynamically Typed

What does this mean? We can change the type of a variable on the fly just like we do in Ruby. We don't need to do any special "casting" it just magically does it. This is incredibly powerful but also can lead to all sorts of errors if you are not careful.

```js
var number = 1;
number = "not a number lol";
number;
number = 4;
number;
```
Our number variable has magically changed from a number to a string back to a number again.

## Weakly Typed

Javascript will try and be our friend and convert the type to allow an operation to succeed

```js
3 + "hello"
```

What happens here?

```js
"route" + 6 + 6; //"route66"
6 + 6 + "route"; //"12route"
```
We can use brackets to group evaluations together.

```js
"route" + (6 + 6); //route12
```

## Number

Number represents any numerical value, either an integer or a float etc. This includes negative and positive values.  

```js
var wholeNumber = 1;
var negativeNumber = -2;
var float = 2.5;
var scientificNotation = 6.02e23;
```

There are also the following special values:

* `NaN` - (Not a Number) represents a failure of maths and number functions, e.g., `parseInt('blabla')` or `Math.sqrt(-1)`
  
  Note that for some reason, comparing anything to `NaN`, even `NaN` itself, will evaluate to `false` (i.e., `NaN !== NaN`).  You should use the `isNaN`

* `Infinity` 

We have access to mathematical operators.  

```js
2 + 3;   // 5
7.5 - 1; // 6.5
2 * 3;   // 6
```

JavaScript will give a decimal answer even if we are operating on two integers.
They are all just numbers.

```js
5 / 2 === 2.5  // (would be 2 in ruby)
```

If you want to truncate the fractional part, use `Math.floor`

## String

A string is used to represent text, and has a [bunch of really useful methods](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String) defined on it.

As mentioned we can create strings with double (`"`) or single (`'`) quotes &mdash; conventionally, the single quote is much more common.  In modern environments, we can also use the backtick to support template strings.

```js
var myString = 'a nice string we have created';
myString.length;
myString.toUpperCase();

var name = 'Fred';
var greeting = `Hi there, ${name}.`;
```


## Null

The `null` value is used when a value is deliberately missing &mdash; for example, a database might return `null` if you are trying to fetch a record that doesn't exist.


## Undefined

If you declare a variable without assigning it a value, both its value and type will be `undefined`.

```js
var b;
b === undefined
typeof b === 'undefined'
```

The default value for non-existent hash keys is also `undefined`.

```js
var hash = {};
hash.a === undefined
typeof hash.a === 'undefined'
```

Generally, `null` is used for variables which are deliberately value-less, and `undefined` is merely the default initial value of a variable.  Deliberately setting something to `undefined` is usually a bad design choice.


## Boolean


A boolean has two values, either `true` or `false`.


We can also evaluate statements to return a boolean.

```js
1 > 2;     // false
2 == 2;    // true
2 == "2";  // true
3 != 4;    // true
3 !== 4;   // true
2 === "2"; // false - what is going on here?
```

The double equals (`==`) checks if two values are equal, but allows JavaScript to do its weakly-typed magic we saw before.  Therefore `4 == '4'` is `true`.

This can cause bugs to creep in, so unless you have a good reason, it is good practice to use the triple equals (`===`), which only evaluates to `true` if *both* the value and the type match.

The equivalent 'not equal' operators are `!=` and `!==` respectively.

You might see the single equals version being used to check if a variable has a value:

```js
if (myvar != null) {
  // do something with myvar
}

null == null // true
undefined == null // true
```

Like in other languages the key role of the Boolean value is for control flow. 

### Boolean Operators

We can use the boolean operators "and" (`&&`) and "or" (`||`) to make logic expressions.

```js
(1+1 === 2) && (1+1 === 4); // false
(1+1 === 2) || (1+1 === 4); // true
```

JavaScript has *short-circuiting*:

 * if the first argument to an "and" statement is `false`, JavaScript does not bother evaluating the 2nd argument, because the answer will be `false` regardless
 * similarly, if the first argument to an "or" statement is `true`, JavaScript does not bother evaluating the 2nd argument, because the answer will be `true` regardless

We can also use `!` for "not".

```js
!true; // false
```

### Truthiness and Falsiness

Remember how JavaScript has dynamic typing, and converts variable types for you on the fly?

There are rules for which kinds of values get converted to `true` (these values are called *truthy*) and which get converted to `false` (called *falsey*).

#### Falsey values

We can convert from any value to a boolean with the `Boolean` function.

In node / browser console:

```js
> Boolean(5)
true
```

Get the students to guess the answers below:

```js
Boolean(0)
Boolean(2)
Boolean('')
Boolean('cat')
Boolean(NaN)
Boolean(null)
Boolean(undefined)
```

The following values get converted to `false`:

* `0`
* `''` (an empty string)
* `NaN`
* `null`
* `undefined`

Everything else is `true`.

### Example

`parseInt` is a method Javascript provides to us to turn a string into an integer

```js
parseInt('2');
parseInt('cat');
```

```js
isNaN(1); // false
isNaN(parseInt('cat')); // true
isNaN(parseInt('1')); // false
```

