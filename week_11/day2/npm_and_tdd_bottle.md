# JS Object TDD Lab
## Learning Objectives
Know what npm is.  
Know how to install libraries using npm.  
Test drive JS constructors using Mocha.

## Duration
1hr 15m.  
45min code along, 30min lab.

## npm

We want to make some objects and test them in Javascript. So where can we get a testing framework from? Node has a handy package manager called [npm](https://www.npmjs.com/)! npm allows us to download libraries (code that other people have written) for use in our projects or share our code with other people.  

First off, let's check our npm version to make sure that we all have it installed...

```
// Terminal
npm -v
```

Now let's set up a working directory and start using npm...

```
// Terminal
mkdir water_bottle
cd water_bottle
```

If we want to use npm to install dependencies the first thing that we need to do is `npm init`.

```
// Terminal
npm init
```

We won't be hosting this project on npm for other people to use so we don't need to worry about filling out any of these fields. Just press enter until you're able to issue commands to Terminal again.  
If we type `ls` in our Terminal window we should now see that a `package.json` file has been created for us, defining all of the fields that we just skipped past as well as a few others like `dependencies`, `devDependencies` and `scripts`.  

As well as allowing us to download libraries, npm also allows us to describe the dependencies of our project so our colleagues or anyone else that might be trying to run our code can easily make sure that they have everything that they need.

Let's install a testing framework and see this in action...

```
npm install --save-dev mocha
```

We're using the `-dev` flag because Mocha is a dev dependency. It's just used for testing therefore it won't be required in the build that the end user sees.

If we take a look at our `package.json` now, we should see that mocha (along with its default version number) has been added to our list of dependencies.

## Semantic Versioning

Semantic versioning is a standard that a lot of projects use to communicate what kinds of changes are in this release.

When releasing libraries a convention is used to describe what changes have been made.

Three numbers are used, when the library is updated the publisher can use these numbers to describe the changes.

`"mocha": "^2.4.5"`  
MajorRelease.MinorRelase.MinorChanges

After this, changes should be handled as follows:

Bug fixes and other minor changes: Patch release, increment the last number, e.g. 1.0.1 New features which don't break existing features: Minor release, increment the middle number, e.g. 1.1.0 Changes which break backwards compatibility: Major release, increment the first number, e.g. 2.0.0

We can use these number to "~1.0.0" === "1.0.x" Latest MinorChange, won't increase release "^1.0.0" === "1.x.x" Later MinorRelase, won't update Major release. * or x will update to the latest release, dangerous!

## node_modules

npm has also created a `node_modules` folder that any downloaded libraries will live in. If we were to delete our `node_modules` folder...

```
// Terminal
rm -r node_modules
```

We could use the `npm install` command to check the dependencies listed in our `package.json` and install them all.

```
// Terminal
npm install
```

The `node_modules` folder is typically added to our `.gitignore` file to reduce the size of our projects.

Enough about npm, let's look at Mocha!

## Setting up Mocha with npm

Let's create a sub-directory for our tests to live in and a test file for our WaterBottle.

```
// Terminal
mkdir specs

touch specs/water_bottle_spec.js
touch water_bottle.js
```

We can simply tell Node to use Mocha to run all the files in our specs directory, but we have to point at mocha within our `node_modules` folder and it's a bit ugly.

```
// Terminal
node node_modules/.bin/mocha specs
```

Luckily we can alias this in the `scripts` in our `package.json` to make things a bit more convenient.

```
// package.json
"scripts": {
  "test": "mocha specs"
}
```

Now we can simply tell npm to run the command that we aliased under `test`.

```
// Terminal
npm test
```


## TDD Recap
We are going to create a JS object to represent a water bottle. We are going to take a TDD approach - writing our test, triggering the error,  then writing the code to make it pass (at which point we would Git commit). To do this we are going to introduce a test framework.

A test framework allows us to define what we expect our program/objects to be able to do. The framework will then tell us how the object differs from what we expect. We could write this ourselves, but the test framework gives us this out the box.

The TDD approach is to define what we expect it to be doing first, and seeing the test fail.  Then writing the behaviour to make the test pass.  It allows us to focus on writing our programs in small iterative cycles.



## Testing with Mocha

First, let's require our water bottle and Mocha's assert module in our test file.

```js
// water_bottle_spec.js
var assert = require('assert');
var WaterBottle = require('../water_bottle.js');
```

Next let's use Mocha's `describe()` function to specify what we're testing. In this case we'll be testing our Water Bottle...

We'll also pass a function as the second argument to the `describe()` function. This is a common thing to do in JavaScript. We'll see this in more detail later in the week...

```js
// water_bottle_spec.js
describe('Water Bottle', function () {

});
```

Now let's write the test to check that the water bottle starts off empty.
Mocha's `assert` object has an `equal()` method on it, which allows us to check if two items are equal. We use this via the `it()` function, which works similarly to the `describe()` function, in that we pass it two arguments; the first being a string that describes our test and the second being a function that we want to be called within our test.

```js
// water_bottle_spec.js
it('should be empty at start', function () {
	var bottle = new WaterBottle();
	assert.strictEqual(bottle.volume, 0);
});
```

Let's run our test and see it fail.

```
// Terminal
npm test
```

Now let's make it green.

```js
// water_bottle.js
var WaterBottle = function () {
	this.volume = 0;
}

module.exports = WaterBottle;
```


So what did we do here? We created a constructor for WaterBottle objects and gave it a volume attribute with an intial value of 0. We then explicitly expose the water bottle using module.exports so that it can be required in other files.

In pairs try and give the bottle the extra functionality.

# Water Bottle Lab
Write and pass the following tests:  

1. water bottle should be empty(X)
2. should go to 100 when filled
3. should go down by 10 when drank
4. should go to 0 when emptied
5. should not be able to go below 0


## Water Bottle Lab Extension
Create and test a constructor for athlete objects.

1. Athlete should have a hydration attribute that starts at 100.
2. Athlete should have a distance covered attribute starts at 0.
3. Athlete should be able to run:  increasing distance, decreasing hydration.
4. Athlete should not move when running dehydrated: hydration at 0;
5. Athlete should be able to increase hydration by drinking from water bottle
6. Use Mocha's `beforeEach()` to create a new instance of WaterBottle and Athlete before each test.
