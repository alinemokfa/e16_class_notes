# Setting up a React app

## Learning objectives
- Setup a React Application
- Render a 'Hello World' using React DOM

> Hand out react_start_point

First we need to install React so we can use it in our projects.

```
  npm install --save react react-dom
```

Let's create our bundle and get our app running.

```bash
  npm install
  npm start

  # new tab
  npm run build
```

## Our First React Application

Let's create an 'app' div and use React to render an element into it. This is where our app is going to live in the DOM. We don't want to make the entire BODY our app because we might want to add another React app to this page.

```
  //client/build/index.html
  <div id="app"></div>
```

And now let's use React to draw an `h1` in our app element.

We use the React.createElement function which takes 3 arguments: a type of element to create (can be an HTML element or one we define ourselves), any attributes to pass to it, and its children (which may be text or other elements).

The ReactDOM object handles rendering to the DOM. React itself is not coupled to the DOM. It can be used for server-side rendering and native mobile apps too. So the DOM part of React was separated out into its own library. We call ReactDOM.render() and pass it a React element to render, and a container to render it into. We can either render a React representation of an existing HTML element, or a component that we have made.

```js
//client/build/src/app.js

  import React from 'react';
  import ReactDOM from 'react-dom';

  window.onload = function(){

    const header = React.createElement('h1', null, 'Hello World!');
    const appDiv = document.getElementById('app');

    ReactDOM.render(
      header,
      appDiv
    );
  }
```

If we check out or browser now - our first Hello World React app!
