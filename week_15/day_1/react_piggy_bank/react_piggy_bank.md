# Piggy Bank Application

### Learning Objectives

- Create a single component application, using the JSX syntax
- Use props and state to control the app
- Install and be able to use React Dev Tools

## Introduction

React allows us to render to and update the DOM easily and efficiently. Using the React framework, we can quickly update the UI in response to a user's interaction by giving our components state. When that state is updated, React triggers a rerender, diplaying the most current state of the application.

### Creating the Piggy Bank Component

We want a simple piggy bank application to get to learn the syntax of React. We want to be able to put money in, take money out, and see the total.

It will contain a single piggy bank component that will display a savings total.  We will then add a 'deposit' button that will update the state of the component, updating the total.

A component's role is to display a section of our user interface.  Good React applications have many small components each doing one job, much like good OO programs.

## Create-React-App

Let's begin by using create-react-app to give us a start-point.

```bash
  create-react-app piggy_bank
  cd piggy_bank
  npm start
```

Great! If everything went as planned, we should see some default stuff in our web browser, at http://localhost:3000.

We're ready to start configuring it, and writing our app. Let's start by removing some of the unecessary boilerplate stuff.

```bash
rm src/logo.svg
```

```js
// src/App.js

import React, { Component } from 'react';
// REMOVE THIS LINE
import logo from './logo.svg';

import './App.css';

class App extends Component {
  render() {
    return (
      // REMOVE FROM HERE...
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
      // TO HERE
    );
  }
}

export default App;
```

We're removing a whole lot of what _looks_ like HTML here. But... clearly it isn't HTML, because it lives in a JavaScript file! What on earth is going on?

This syntax is called `JSX`.

## JSX

We saw earlier on that you can use `React.createElement()` to create a new element to insert into the DOM. That's one way of doing it.

We can also use an alternative syntax, called JSX.

JSX looks a lot like HTML, but there are some key differences. For example, we would have to use the `className="my_class"` attribute rather than `class="my_class"`.

***Question:***
<details>
<summary>
Why wouldn't we be able to use the word `class` here?
</summary>
Because it's a JavaScript file, so `class` a reserved word.
</details>

There are some [other gotchas](https://shripadk.github.io/react/docs/jsx-gotchas.html), but you shouldn't run into them too often.

JSX allows us to construct our user interfaces in a much quicker and more natural fashion, declaring our JSX rather than using JavaScript to manually create our HTML.

You should be aware that React and JSX are two independent technologies, but JSX was built with React in mind. We are only able to use it in our JavaScript because we're using create-react-app, which uses Babel under the hood.

If we weren't using create-react-app, we'd need to manually install and configure Babel, which is a hassle we can live without.

Let's make sure that Atom displays JSX correctly by install the `language-babel` extension.

```bash
apm install language-babel
```

### Render Piggy Bank

Let's write a little bit of JSX to get ourselves started.

```bash
touch src/PiggyBank.js
```

To create our components we use ES6 classes which inherit from `React.Component`. We can then define methods inside our classes.

The method every React component must implement is `render()`. This (usually) returns a single element to be rendered to the page. You may nest multiple elements in the render but they must always be wrapped inside a single containing element.

It's also possible to return a plain JavaScript array of JSX elements from a `render()` method, and these will be rendered in the app.

```js
// src/PiggyBank.js
import React from 'react';

class PiggyBank extends React.Component {
  render() {
    return (
      <div className="bank-box">
        Hello, world! I am a Piggy Bank.
      </div>
    );
  }
}

export default PiggyBank;

```

Remember to `export default` so we can `import` it elsewhere!

Next, we need to import and use our PiggyBank into our App.js file.

```js
// src/App.js
import React, { Component } from 'react';
import PiggyBank from './PiggyBank';

class App extends Component {
  render() {
    return (
      <PiggyBank />
    );
  }
}

export default App;
```

Components have attributes that they can display.  There are two types of attributes.

## Properties

Properties are attributes that are given to a component that can not change. They are immutable.  They just render it.  Let's give the piggy bank a title component that it can display.

We pass in properties to JSX like we set attributes on an HTML component. These can be in quotes to pass in a string, or in curly braces `{}` to pass in other JavaScript data types or objects.

> Instructor note: You can show this transpiled by Babel to show what's happening.

Note: all JSX tags must be closed, either with a separate closing tag or self-closed.

```js
// src/App.js
import React, { Component } from 'react';
import PiggyBank from './PiggyBank';

class App extends Component {
  render() {
    return (
      <PiggyBank title="Beth's Savings Pig" />
    );
  }
}

export default App;
```

Our component has use of its properties through its props attribute, this.props.
Let's use it to show our title.

```js
// src/PiggyBank.js

class PiggyBank extends React.Component {
	render() {
		return (
			<div className="bank-box">
				<h1>{this.props.title}</h1>
			</div>
		);
	}
}

```

## State: Displaying a total

Now we want our bank to display a total. Props are something that are given to us by a parent that we can't change. We need something that belongs to the component that it can change.

State is something that the component is in control of. It generally isn't passed down from a parent, it is something the component sets up itself.

Let's set up our initial state. We want a total property that starts at zero. We can then display this. Our initial state is defined in the constructor of our component class.

```js
// src/PiggyBank.js

class PiggyBank extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      total: 0
    }
  }

  render() {
      <div className="bank-box">
        <h1>{this.props.title}</h1>
        <p>Hello, world! I am a Piggy Bank.</p>
        <p>I contain £{this.state.total}</p>
      </div>
  }
}

```

## Updating State

Now we want to add a button that will increase the total when we deposit money into the piggy bank.

Clicking on the button will update the state of our application. We will use the `this.setState()` method to update the state.

When updating the state of a component, if its value changes, React will re-render the application!

Seems a bit inefficient but remember the virtual DOM? React will only update the DOM elements that have changed, keeping it quick.

```js
// src/PiggyBank.js

class PiggyBank extends React.Component {

  constructor(props) {
    ...
  }

  deposit() {
    this.setState(prevState => {
      return {total: prevState.total + 1};
    });
  }

  render() {
    return (
      <div>
      ...
      <button onClick={ this.deposit }>Add</button>
      </div>
    );
  }
}
```

Unfortunately, we've run into a problem with `this`. Inside `deposit()`, `this` has global scope. Which is bad. Fortunately, there are a couple of solutions to this problem.

Option 1 is to use our old friend `bind`:

```js
  // src/PiggyBank.js
  constructor(props) {
    ...
    this.deposit = this.deposit.bind(this);
  }
```

Option 2 is to do something this in the `onClick`:

```js
  // src/PiggyBank.js
  <button onClick={ this.deposit.bind(this) }>Add</button>
```

Option 3 is to wrap the call to `deposit` in an anonymous ES6 arrow function, which does not bind its own `this`:

```js
  // src/PiggyBank.js
  <button onClick={ () => { this.deposit() } }>Add</button>
```

Of the three solutions, binding in the constructor is the preferred option (and the one recommended in the React documentation) is because the bind only has to happen once, when the class is initially set up. If we put it in our `render()` method, it would happen each time the JSX re-renders. (Which could be quite frequently!)

## Using `setState()`

We saw that when we changed the state above, we passed in an callback function that gave us access to the previous state object. *This is the only way to do it if you need reliable access to the previous state.*

When we use a callback function in `setState` like this, React queues up all the requests to change the state. (And bear in mind that in a big app, there could be lots of things looking to change the state.) So if you need to get access to the previous state object, it ensures that you'll get the most accurate, up-to-date object back, with all the queued changes.

If you just want to set the state to a specific value, and you don't care about what the value was before, you can just pass in an object to `setState`, like this:

```js
  this.setState({ total: 5 });
```

# Chrome Dev Tools
An other advantage of React is that there are powerful development tools in chrome.
[Link to React-Dev-Tools] (https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi?hl=en)

We can see the state and properties of all of our components at any point in time.

We have a dynamically updating single component react application.
We have seen properties and state on a component and how setting the state forces the application to re-render.
Next we will see an application with multiple components that will increase our understanding of the one-way flow.

### Tasks: (15 minutes)
- Add an owner property to the piggy bank.
- Add a 'withdraw' button which decreases the total.
- Add a depositAmount property - pass in a value which depositing or withdrawing will change the total by.

### Solution:

*Add an owner property to the piggy bank:*

```js
// src/App.js
<PiggyBank
    title="Beth's Money Pig"
    owner="Beth" />

// src/PiggyBank.js
<p>Hello, world! I am a Piggy Bank. My owner is {this.props.owner}.</p>
```

*Add a 'withdraw' button which decreases the total:*

```js
// src/PiggyBank.js

constructor(props) {
  // ...
  this.withdraw = this.withdraw.bind(this)
}


withdraw(){
  this.setState((prevState) => {
    let newTotal = prevState.total < 1 ? 0:prevState.total - 1;
    return {total: newTotal};
  });
}

render(){
    // ...
    <button onClick={ this.withdraw }>Withdraw</button>
    // ...
}
```

*Add a depositAmount property - pass in a value which depositing or withdrawing will change the total by.*

```js
  // src/App.js
  render() {
    return (
      <PiggyBank
        title="Beth's Savings Pig"
        owner="Beth"
        depositAmount={5}
        />
    );
  }

  // src/PiggyBank.js
  deposit(){
    this.setState((prevState) => {
      return {total: prevState.total + this.props.depositAmount};
    });
  }

  withdraw(){
    this.setState((prevState) => {
      let newAmount = prevState.total - this.props.depositAmount;
      if(newAmount < 0){
        newAmount = 0;
      }
      return {total: newAmount};
    });
  }
```

## Recap

<details>
<summary>
What method does every React component have to implement?
</summary>
`render()`
</details>

<details>
<summary>
Name two differences between props and state?
</summary>
1. Props are passed down from parent to child component, whereas state is initialised within a component.
2. Props are not changed throughout the lifetime of the component, whereas state can be updated to reflect the current state of the application.
</details>

<details>
<summary>
How do we trigger a rerendering in React?
</summary>
`setState()`
</details>


# Conclusion

React allows us to render our UI as components, providing structure to our front end. It’s use of the virtual DOM and rerendering triggered by the `set.State()` method makes updating the DOM really efficient.

We can now create single component applications, using JSX syntax to render information to the screen. We have seen how to trigger a rerender of the UI by updating a component's state on user interaction. We have also seen how to pass props down from a parent component.

Lastly, React Dev Tools offers a way of inspecting components' props and state during development.
