# Basic overview of ES6

## Learning objectives
- Understand what ES6 is 
- Understand how to use a transpiler to write ES6 _today!_
- Understand some of the basic features of ES6 that will let us write idiomatic React
  - let / const
  - string interpolation
  - Arrow functions
  - Classes, inheritance, constructors
  - Import / exporting

### What is ES6?
ES6 - ECMAScript 6 - is the newest version of the programming language that we know and love as JavaScript. You might also see it referred to as "ES2015" in some places - this is the version of ES6 that was ratified - in 2015. Future versions of the language will follow this naming convention.

ES6 contains many new features that will make our lives as front-end developers easier and more satisfying.

At the moment, support for these new features varies from browser to browser, so to make sure we can use ES6 properly, we're going to use something called a transpiler.

### A wat now?
A transpiler is just a piece of software that converts code from one programming language to another. In our case, we're going to be writing ES6, but using a transpiler behind the scenes to convert it to ES5 that our browser will understand. We're going to use something called [Babel](https://babeljs.io/) to convert our code. 

This sounds like it might be a... troublesome process, but it really isn't! Using the power of webpack, we can easily convert our code on the fly.

> Hand out the starter code, ask the students to do an ```npm install``` and give them a couple of minutes to read over the code and check it out in the browser. Ask them to check out the MakeupGetterES5 file in particular.

### Setup

We need to add a few packages to our project to get started with ES6:

```
npm install --save-dev babel-loader babel-core babel-preset-env
```

This adds the core Babel packages to our project.

Next, we need to tell webpack that we want to use Babel to transpile our code. In our webpack.config.js, let's add the following:

```
config = {
  entry: __dirname + "/src/app.js",
  output: {
    filename: "bundle.js",
    path: __dirname + "/build/js"
  },
  devtool: 'source-map',
  /* ADDED */
  module:{
    rules: [{
      test: /\.js?$/,
      exclude: /(node_modules)/,
      loader: 'babel-loader',
      query: {
        presets: ['env']
      }
    }]
  }
  /* ADDED */
};
```

That should be it! Let's write some ES6.

### Converting our code to ES6

Let's rewrite our MakeupGetter code to take advantage of ES6.

```
# Terminal
cd client/src
touch MakeupGetterES6.js
```

> Open up the new file in Sublime

First of all, let's create a new class in the ES6 style.

```
# MakeupGetterES6.js
class MakeupGetterES6 {
  constructor(brand){
    this.brand = brand;
    this.products = [];
  }
}
```

There's nothing too unusual here, but notice how we're calling a function called `constructor` when we instantiate the class now. We could also use inheritance in our class by using the `extends` keyword:

```
class MakeupGetterES6 extends SomeClass {
```

...But we don't really need to do that just now.

Let's add a method to our class. In ES6, we don't need to worry about Prototypes, or anything like that - we can put them directly on the class!

```
# MakeupGetterES6.js
class MakeupGetterES6 {
  ...
  fetchProducts(){

  }
}
```

Let's write our `fetchProducts` method.

```
# MakeupGetterES6.js
class MakeupGetterES6 {
  ...
  fetchProducts(){
    // ADDED
    const url = `http://makeup-api.herokuapp.com/api/v1/products.json?brand=${this.brand}`;
  }
}
```

Woah, two new things here! 

Firstly, we're using the `const` keyword instead of the `var` keyword to declare a variable. This just means that the variable can't ever change - it is a constant.

Secondly, we're using string interpolation rather than concatenation to build our URL. If you want to use interpolation to include variables in your strings, then you need to use backticks rather than quote marks, and you need to use the ${...} construct around your variable.

Let's keep going.

```
# MakeupGetterES6.js
class MakeupGetterES6 {
  ...
  fetchProducts(){
    const url = `http://makeup-api.herokuapp.com/api/v1/products.json?brand=${this.brand}`;
    // ADDED
    const xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    
    xhr.onload = () => {
      this.products = JSON.parse(xhr.responseText);
    };

    xhr.send();
  }
}
```

What on Earth is happening with our anonymous function?!

ES6 allows us to write functions using a brand new notation; sometimes called arrow functions, or fat arrow functions.

So this:
```
var foo = function(myVar){
  console.log(myVar);
};
```

Is equivalent to this:
```
var foo = (myVar) => {
  console.log(myVar);
};
```

Why would we use this notation? It's simple, really - the arrow function doesn't bind its own context. So we can say `this.products` and it refers to the MakeupGetterES6 object, not the XHR object. No `bind`, `call`, or `apply`, just using the current class instance as the context.

### Let's look at let

Finally, let's loop over our products and log them out.

```
# MakeupGetterES6.js
class MakeupGetterES6 {
  ...
  fetchProducts(){
    const url = `http://makeup-api.herokuapp.com/api/v1/products.json?brand=${this.brand}`;
    // ADDED
    const xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    
    xhr.onload = () => {
      this.products = JSON.parse(xhr.responseText);

      for (let product of this.products){
        console.log(product);
      }
    };

    xhr.send();
  }
}
```

Firstly, we're using for...of instead of a basic for loop. Yes, this construct is actually part of ES6. You've probably been using it without realising!

Secondly, you might notice that we're using a new keyword instead of `var` - we're using `let` instead.

When we use `let`, the variable that we declare is only set in the block, statement, or expression in which it is used. Try it yourself - what is the value of `product` outside of the for loop?

### Import export

In order to make this class visible to the outside world, we need to export and import it. This process is pretty similar to doing `module.exports = thing`, but there's a new ES6 way of doing it. In fact, there are a couple of ways.

We can do something like this at the bottom of the file:

```
export default MakeupGetterES6;
```

Or, we can add this information to the class signature:

```
# MakeupGetterES6.js
// CHANGED
export default class MakeupGetterES6 {
  ...
}
```

Now, we can do something like this when we want to use it:

```
# app.js
import MakeupGetterES6 from './MakeupGetterES6';

var mg = new MakeupGetterES6("maybelline");
```

### Further Reading
There are many, many new features of ES6 that we haven't touched on here - check out [es6-features.org/](http://es6-features.org/) for lots of examples.