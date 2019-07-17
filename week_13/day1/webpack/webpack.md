# Webpack intro

## Learning objectives
- Understand what webpack does
- Understand how to structure a webpacked app
- Understand how to unit test a webpacked app

## Duration
2.5 hours

# Intro

So far we've been writing scripts and including them in the browser as script tags. This is fine, but:

- Using script tags makes it hard to know what depends on what
- It's hard to structure and model our app versus what we did with node in week 1
- We've got no tests
- We've lost the ability to use NPM packages
- We are serving up unminified files

We're going to have a look at an app written this way, then have a look at what the same app looks like using webpack.

> give out unbundled starter code and task

# Webpack to the rescue

Now we're happy with the app and what it's doing, let's have a look at how we can solve our problems. Webpack desribes itself as a "module bundler" which means it can take modules of JS code (like we made in Node in week 1) and bundle it up into something the browser can understand. It's _extremely_ powerful and can let us do all sorts of things - including letting us write ES6 early using the Babel transpiler, as well as writing React components. We'll see this in the Web Frameworks module.

Before we go any further, we should make a bit of a modification to our project to change the folder structure into something that's more webpack (and our brains!) friendly. I've been very kind and already made a little starter folder for you so we don't get bogged down in a typo nightmare.

> give out bundle start code

Write down the differences you can see between this code and the previous.

- The public folder has changed to client/src/models
- the UI.js has gone to a client/src/views
- server.js now has no references to "public" but rather the client/build folder
- index.html has gone to the build folder
- The domain models now have "require" and "export" on them
- index.html now references a bundle.js script

# New Folder Structure Explained

## client

This is where our front end javascript is going to live i.e. nothing to do with express or apis etc. However, we're going to writing our app files in the style of Node.js, with require statements and npm packages just like we did in week 1 of the JS course. Which means we can easily have tests again! More on this later.

### src/models

This is the raw source files for our application, our domain models.
app.js is the _entry point_ for our app (more on this later). This can be called anything (it's not a convention), but app.js is a decent name.

### src/views

We can even put stuff in here that talks to the DOM, but still write it as if it's a node app. How crazy is that! We just need to be careful - we can't test or run these view files with node, since Node will spit having no idea what "document" or "window" is. But we can still write them in Node and have our dependencies all required in nicely.

### build

This is where the magic happens!

Our Node-friendly JS files are going to be bundled up, minified and delivered to this folder. They will then be references as a _single file_ in index.html. This file will have no idea about node or npm when it's finished - it's just a plain old js script that the browser can understand.

Ideally, we would _not_ have index.html in here. Anything needed for the build shold be copied in from elsewhere so that this folder can be deleted and regenerated at any time. However, to achieve this adds another layer of complexity to our apps so we're not going to do that just now.

# What's the point?

We can solve all of our problems:

- It's super easy to see what depends on what
- We can model our apps and structure them nicely
- We can test stuff again! (it's just the same thing we were doing in week 1)
- We can use NPM packages
- We can minify our files

# So how does this magic work?

Webpack is the magic that makes all this happen. It takes all of our Node files and translates them into bog standard js files that the browser can understand. Not only that, it takes all the files and turns them into _one file_. This means we only have to put one script tag in our HTML file and webpack will ensure that file has all the code we need in it.

Let's have a look at this in action.

First, let's npm install to get Express for our server.

```zsh
# terminal
npm install
npm start
```

# Installing Webpack

Webpack is just an npm package, which we can use again. Hurrah! It's a development dependency that helps us generate our production code, so we want to use --save-dev.

```zsh
# terminal
npm install --save-dev webpack
```

To use webpack, it looks for a special config file it can understand. This will live in the client folder, since this is where the _front end_ code lives i.e. models and events for the browser, not the server code. This is the only part of our code that webpack's interested in. We're using webpack to package up our code for the users browser, the client-side of our webapp.

```zsh
# terminal
touch client/webpack.config.js
```

We need to follow a specific pattern to make this work, which you can learn about on the webpack documentation. It's a similar idea to package.json.

Firstly we need to define a little config object which is also exported like our other variables

```js
// client/webpack.config.js
config = { //NEW

}
module.exports = config; //NEW
```

This expects some properties to be set for webpack to work. At a minimum it needs to know _an entry point_ of the app - the main start point that webpack will start to look for dependencies and an _output location_ for the generated bundle file.

```js
// client/webpack.config.js
config = {
  entry: __dirname + "/src/app.js", // NEW
  output: { // NEW
    filename: "bundle.js",
    path: __dirname + "/build"
  },
}

module.exports = config;
```

Optionally, we can specify that we would like a source map generated. This is really useful, because if we serve up one big file to the browser we can't debug it easily, the file it generates is not intended to be read by humans. Adding this flag gives us access to the original files in the dev tools pane which is super awesome for debugging!

```js
// webpack.config.js
config = {
  entry: __dirname + "/src/app.js",
  output: {
    filename: "bundle.js",
    path: __dirname + "/build"
  }, // UPDATED
  devtool: 'source-map' //NEW
}

module.exports = config;
```

Now we have webpack installed and configured for our app.

Because webpack is a dev dependency in our package.json, we can tell our package.json how to run it in a script, just like `npm start` or `npm test`.

We're going to tell our package.json to run `webpack -w`. The `-w` flag tells it to _watch_ our files for whenever we save a change, and re-bundle our code again.

```json
// package.json
"scripts": {
  "start": "node server.js", // UPDATED
  "webpack": "cd client && webpack -w" // NEW
},
```

Because this script has a custom name, not simply `start` or `test`, we have to run it using the command 'npm *run* webpack' - This tells npm we want to run a script from our package.json.

```zsh
# terminal
npm run webpack
```

You'll notice something cool has happened. Webpack now sits and watches for changes to our js files that are referenced beginning from app.js. It takes them, squishes them together and throws them into our build folder. We'll generally always have a tab open with webpack running.

If you ever wonder why your code isn't working, isn't changing, isn't acting as it should it's most likely because webpack hasn't regenerated your code... because you don't have it running.

[TASK]: Stop webpack, delete the bundle.js, regenerate webpack

## One last piece of the puzzle

Okay great, our nice little node models are being bundled up by webpack and translated into something the browser can understand. But what about tests? Can you remember how we did them in week 1? Let's say we want to test our film model.

If you remember we like to keep our tests in a "specs" folder. With our new folder structure, we can pop this inside the models folder.

```zsh
# terminal
mkdir client/src/models/specs
touch client/src/models/specs/film_spec.js
```

> Give this out in Slack to be pasted into film_spec:

```js
//film_spec.js

var Film = require('../film');
var assert = require('assert');

describe('Film', function () {
  var film;

  beforeEach(function () {
    film = new Film({
      title: "Titanic",
      actors: ["Leonardo DiCaprio"]
    });
  });

  it('should have title titanic', function () {
    assert.equal(film.title, "Titanic");
  });

})
```

We just have one little thing to consider, and that's how we run this test.

We're going to set up an npm script to run mocha for us. We can do this to allow our tests to run from anywhere in the project.

First, let's install mocha:

```zsh
# terminal
npm install --save-dev mocha
```

While that's installing we can get our test script set up.

```json
// package.json
"scripts": {
  "test": "mocha client/src/models/specs", // UPDATED
  "start": "node server.js",
  "webpack": "cd client && webpack -w"
},
```

We can use this by typing:

```zsh
# terminal
npm test
```
