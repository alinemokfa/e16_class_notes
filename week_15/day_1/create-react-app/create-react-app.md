# create-react-app

Duration: 30 mins

## Learning Objectives

At the end of this lesson, you should be able to:

- Install create-react-app globally
- Create a new React app using create-react-app
- Navigate around the directory structure that create-react-app makes for us
- Remove default content and start to make your own app

### Introduction

So far, today, we've had to do quite a lot of manual setup to get things working the way would like - Webpack, Babel, Babel Presets, React, ReactDOM...

It's a bit painful to set this up each and every time we want to create a new React app. This is such a common pain-point that Facebook have created a batteries-included startpoint for us to use! It's called create-react-app.

We are we describing it as "batteries-included"? It's not just a start point for our apps - it includes a lot of other stuff that will help us while we're developing our apps:

- React, JSX, ES6, and even some JavaScript features that go beyond ES6
- [Flow](https://flow.org/) - a optional type checker that can help us to eliminate bugs
- [Jest](https://facebook.github.io/jest/) - a testing framework that lets us test our app in various ways
- A built-in web server that checks for errors - no need to set up Express
- The ability to `import` CSS and images
- "Hot reloading" - we don't need to refresh our web browser when we make changes
- A build script that includes a pre-configured version of Webpack
- Easily deployable to many hosting providers, for example Github Pages
- [Progressive web apps](https://developers.google.com/web/fundamentals/getting-started/codelabs/your-first-pwapp/) as standard.

So as you can see, using create-react-app brings many benefits.

### Installation

We need to install create-react-app globally so that we can use it anywhere.

```bash
# Terminal
npm install -g create-react-app
```

That's it! We only need to do this once.

### Using create-react-app

Let's say that we want to create a new React app in our current directory.

```bash
create-react-app my_app
```

This installs everything we need! Let's jump into the directory:

```bash
cd my_app
```

...And let's kick everything off:

```bash
npm start
```

That's it! We've got a working React app. Notice that when you run `npm start`, it opens a new window in your web browser for you.

### Configuration

Let's take a look at the directory structure that create-react-app gives us.

#### node_modules

As usual, our dependencies will be stored here. We shouldn't really ever need to touch this.

#### public

This contains our "favicon" - the icon that appears in our web browser's tab, our index.html file, and a manifest.json file, which helps us to build a progressive web app. (Later on!)

#### src

This is where our own application code will live. It includes the stuff needed for the default page you'll see when you do `npm start`, so let's remove that stuff.

```JavaScript
import React, { Component } from 'react';
import logo from './logo.svg'; // <- Remove this
import './App.css';

class App extends Component {
  render() {
    return (
      // Remove everything below
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
      // ...until here
    );
  }
}

export default App;
```

Now, we can just remove the logo in the terminal. We don't need it any more.

```bash
rm src/logo.svg
```

At this point, we can start to build up our app, importing our components into `App.js` as needed, and filling it out with JSX.

### Recap

In this lesson, we've seen how to:

- Install create-react-app globally
- Create a new React app using create-react-app
- Navigate around the directory structure that create-react-app makes for us
- Remove default content and start to make your own app
