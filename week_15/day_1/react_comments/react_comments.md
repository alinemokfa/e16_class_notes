# React Comments

## Learning Objectives
- Create a multiple component React application
- Understand the difference between state and props
- Learn how to pass data between components


## Comments Application
We want to create a comments feature which displays a list of comments and has a form that allow us to add a comment.

We do this in React by describing how the whole page should be drawn.

There will be nothing more added to our HTML, the whole application will be drawn by Javascript using React. We do this by describing components for our UI in a component ***hierarchy***.

Let's first build a static application that will render based on a hard coded array of comments. This is often a good place to start with a React application.

## Application Skeleton
We are now going to create a skeleton hierarchy for our application.

> Talk this through with class...   

* CommentBox { state = comments }
* CommentList { props = comments }
* Comment { props = comment }

Components can have child components.  The child components of our CommentBox are CommentList, and CommentForm. CommentList will have multiple Comment components nested inside it.

### First Component

Let's use `create-react-app` to bootstrap our application.

```bash
create-react-app comments
cd comments
npm start
```

OK! Through the magic of `create-react-app`, we've pulled down all the bits and pieces we need to start off. We do need to tidy up a little bit, though.

```bash
# cmd-t, new tab
cd src
rm logo.svg App.css
```

At this point, the app has broken, because we've removed stuff that we're importing into our app. Let's fix that. And while we're at it, let's remove some default JSX.

```js
import React, { Component } from 'react';

// DELETE THE NEXT TWO LINES
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      // DELETE EVERYTHING FROM HERE...
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
      // ... TO HERE
    );
  }
}

export default App;

```

Let's build our first component. It'll be the parent component for all our others.

React components must implement a render method that returns what we want it to display. It is automatically called by React so we have to call it 'render' so that React can find it. This is part of the component lifecycle...  
[React Component Specs](https://facebook.github.io/react/docs/component-specs.html)

```bash
mkdir src/components
touch src/components/CommentBox.jsx
```
First let's create and render a simple component out to our page to check that everything is hooked up and working correctly.

```js
// src/CommentBox.jsx
import React from 'react'

class CommentBox extends React.Component {

  render() {
  	 return (
      <div className="comment-box">
        Hello, world! I am a CommentBox.
      </div>
    )
  }

}

export default CommentBox;
```


```js
// src/app.js
import React from 'react'
import ReactDOM from 'react-dom'
import CommentBox from './components/CommentBox.jsx'

window.onload = () => {
  ReactDOM.render(
    <CommentBox/>,
    document.getElementById('app')
  )
}

```

Similarly we will make the empty component for our CommentList.

```bash
touch src/components/CommentList.jsx
```

```js
// src/compoments/CommentList.jsx
import React from 'react'

class CommentList extends React.Component {
  render() {
    return (
      <div className="comment-list">
        Hello, world! I am a CommentList.
      </div>
    )
  }
}

export default CommentList;
```

We now want our box to use this component. Let's add it to the hierarchy.

```js
// src/compoments/CommentBox.jsx
import React from 'react'
import CommentList from './CommentList' //UPDATED

class CommentBox extends React.Compnent {
  render() {
    return (
      <div className="commentBox">
        <CommentList /> //UPDATED
      </div>
    )
  }
}

export default CommentBox
```

## Comment Component

### Properties
Let's create the Comment component, which will depend on data passed in from its parent. Data passed in from a parent component is available as a 'property' on the child component. These 'properties' are accessed through this.props. A special property is this.props.children, which refers to any text or elements written between the JSX opening and closing tags.

Properties are immutable,  components can not change their properties,  they are just given them. Using props, we will be able to read the data passed to the Comment from the CommentList, and render some markup:

```bash
touch Comment.jsx
```

```js
// src/components/CommentList.jsx

import React from 'react'
import Comment from './Comment.jsx' //UPDATED

class CommentList extends React.Component {

  render() {
    return (
      <div className="comment-list">
        <Comment author="Rick Henry">Cool</Comment> // UPDATE
        <Comment author="Valerie Gibson">Nice</Comment> // UPDATE
      </div>
    )
  }
}

export default CommentList;
```

```js
// src/components/Comment.jsx
import React from 'react'

class Comment extends React.Component {

  render() {
    return (
      <div className="comment">
        <h4 className="commentAuthor">
         	{ this.props.author }
        </h4>
        { this.props.children }
      </div>
    )
  }
}

export default Comment

```

## Data Model
We have hard coded the data in a list of comments.

We now want to create a simple array of comments which will be drawn by the view.

We are going to set up our CommentBox to be in control of the data.

It will handle the comment data, and later on updating it.

## State
Our CommentBox is going to be the master of the state of our application, the array of comments.

For now we'll just make some mock data.  If we were creating a proper app we could get this from our server.

```js
// src/components/CommentBox.jsx
class CommentBox extends React.Component {

  constructor(props) {
    super(props)
    this.state = {
    	data: [{ id:1, author:'Beth', text:'I love cats!' }] //UPDATED   
    }
  }

  render() {
    return (
      <div className="commentBox">
        <h2>Comment List</h2> //UPDATED
        <CommentList data={this.state.data} /> //UPDATED
      </div>
    )
  }
}
```

Our comment box controls state and creates a dumb list.

This list has no state (things it can change), it just has the comments it has been given and uses as properties.  We'll create an array of comment components and give them the properties of the author and the text.

Any string put inside our tags can be accessed as children properties.  React wants a key element on array items to uniquely identify them.

```js
// src/components/CommentList.js
class CommentList extends React.Component {

  render() {

    var commentNodes = this.props.data.map(function(comment) {
      return (
        <Comment author={comment.author} key={comment.id}>
          {comment.text}
        </Comment>
      );
    });

    return (
      <div className="commentList">
        {commentNodes}
      </div>
    )

  }
}
```

Great we have created a static application that renders a list of comments. Now let's look at how we can alter the state of our application with adding new Comments.

**Exercise**:

  - We haven't protected the properties of the components or checked their type. Add this.
