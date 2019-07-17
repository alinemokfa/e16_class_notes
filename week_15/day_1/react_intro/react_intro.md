# React

## Learning Objectives
- Describe what React is
- Explain how React differs from our previous applications
- Explain some of the key features of React

## Frameworks

As we discovered in our JS projects, diving for the finish line results in spaghetti code. Mamma Mia! 

Obviously we're not the first developers to experience this. So developers over the years have created libraries and frameworks that make it easier to organise our code for. We don't want to have to reinvent the wheel all the time.

## What is a framework? 

- A framework is an organisational library. "A supporting structure around which something can be built"
- A library (e.g lodash or jQuery) is a set of methods and objects that we can use to do programming tasks (e.g. accessing the DOM, mapping arrays) to save us time. 

> Explain - only if we're doing Rails week after React
In this module we're going to be looking at a frontend framework (React) and a backend framework (Rails).

## Javascript Front-end Frameworks

We've been writing web applications nicely seperating the business logic from our view logic.   A bundler like Webpack allows us to write this in nice individual files stating dependencies.

> Draw diagram of models/view divided and the being bundled into browser.

Our view however has often ended up being a bit of mess.

React is a framework designed to handle the view logic of our application.

Go to the website, to see the three main characteristics of React.

https://facebook.github.io/react/

- One Way Data Flow
- Virtual DOM
- Component based UI - 'HTML' in JS with JSX

This week we are going to be using React to tidy up our view logic of our web applications.

## Why React

React takes a different approach to handling user interfaces than what we have been currently doing and indeed other frameworks.  Let's first think about the current approach we have been taking.

### Current approach - traditional data binding.

Let's consider a simple application which displays comments and lets the user add comments.

Using our current approach we would first get the information for the current comments, and render them to the screen in an 'initial display step'.

We would need to listen to when a new comment has been added. This would then append the new comment to our list of current comments.  This is the data binding step. 

As applications get large the logic for listening to changes can get very complex and difficult to know what is going on. Even in our simple applications we saw this getting a bit out of control.

(E.g. think about every time you have to reset innerHTML to "" and then re-create a new set of elements and all their contents.)

Frameworks like Backbone, Knockout and Angular simplify doing this data binding but still follow the same pattern, and often end up with the same results.

### One way flow

React takes a one-way flow approach. All of the data your app uses - its state - is kept in one place and then passed down through a hierarchy/tree of components for them to use as needed.

Using React we only describe the initial display step.  So how do we deal with changes?

When a change happens, we alter the total state of our app and then just do the whole initial display again.  We don't need to worry about how each little change alters our UI, we just render the whole thing again, passing down the new data.

You might be thinking this incredibly inefficient.  And it would be if it wasn't for the middle item on that list, the virtual DOM.

### Virtual DOM

Updating the DOM using JS is an expensive operation, it tasks a huge amount of time compared to us multiplying numbers, or searching a resonably sized array.  If after every little change our React application re-rendered the whole DOM, our app would be very inefficient and very slow. 

React applications are known for being fast so how does it achieve this.  React keeps a virtual version of the DOM in memory.  When we do a change it updates this and compares it to the real DOM (a diff).  It only updates the real DOM where necessary.

It is this step which allow us to write fast efficient applications by only having to describe a simple render.

### Component based UI

React encourages us to break down our user interface into smaller parts called components. (By doing this we can make sure each part is only looking after one thing... which software principle does this relate to? Single Responsibility principle!) These can be reusable and are really helpful in separating the functionality of your app into independent parts.

These components may (but don't have to) use a React-specific syntax called JSX. JSX allows us to write a HTML-like syntax when describing new elements, whether HTML elements or React components, which saves us time and can make our React code more readable. Some frameworks use a templating language for a similar purpose, writing HTML which can pull in information from a separate JavaScript file, but React allows us to do all of this in one place. (Some people prefer to have those things separate, it depends on the nature of your app as to what's most appropriate.)

### React Popularity

Making applications that are fast and easier to develop has made React a very popular choice in the web community.

https://github.com/facebook/react/wiki/Sites-Using-React

There is also a react implementation for native mobile applications.

https://facebook.github.io/react-native/

Okay now we know how it works and why we would use it let's build our first React application.

