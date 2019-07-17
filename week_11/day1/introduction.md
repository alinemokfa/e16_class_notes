# JavaScript Introduction

### Learning Objectives

- History of Javascript
- Describe the uses of Javascript
- Describe change in client server responsibilities
- Setup npm and node
- Run first Javascript program


### Duration
1hr

# What is JavaScript

Javascript is a programming language.  Let's recap what this means.

The role of a programmer is to break down real world problems, models, games and explain them to a computer.

Computers speak in a binary machine code language. Communicating constantly in this would not be efficient.

Fortunately, nice people have created interpreters,  which translate higher level languages into this machine code.

JavaScript is one of these high level languages.  Learning to speak in it allows us to communicate to the computer via an interpreter.

There are various implementations of interpreters for JavaScript, mostly developed as part of browser projects.  The JavaScript engine in the Google Chrome browser is called V8, and this is the same engine that the Node.JS project is based on.

## What's so cool about JavaScript?

All the browser vendors have been competing with each other for the last few years to make faster and better JavaScript engines.  There has also been quite a fast evolution of JavaScript into a more general purpose language.  One of the language's greatest assets is the [NPM package repository](https://www.npmjs.com/), with almost half a million packages of code which you can include in your project to save you time.  In fact, it's the biggest such package repository ever.

It is currently the only language that browsers run, meaning you're going to encounter it if you have anything to do with the web.  Given the general trend towards browser-based software (think Google Docs and Office 365 versus Word and Excel), it's quite likely you'll have something to do with web.

There are also databases for which the query language is JavaScript, and you can write the back end of your website in JavaScript with a platform called Node.JS.

A lot of phone apps these days are basically just HTML and JavaScript, written kind of like web applications but using special frameworks that makes them appear more like a native app.  A lot of desktop apps are written this way too: Atom, VS Code, and GitHub for Windows to name a few.

There even exists [a microcontroller](https://www.espruino.com/) (like Arduino) that you can program in JavaScript.

So learning JavaScript opens up the possibility to develop for a lot of platforms.


## Browser recap

Go over what the browser does.


> There's a keynote presentation in history\_of_javascript folder if you want to do that

## History of JavaScript

JavaScript was written for the Netscape Navigator browser in 1995 by a guy called Brendan Eich - it took him 10 days to produce the first version!

JavaScript was originally called Mocha.  Since Java was hip and trendy at the time, the decision was made to make the syntax somewhat similar, and the marketing department eventually renamed it to "JavaScript" to piggy-back on this.

**However, Java is a *completely* different language - don't get the two confused!**

JavaScript has changed *a lot* in the past 3 years especially.  A brief history can be found [here](https://auth0.com/blog/a-brief-history-of-javascript/).

## ECMAScript

It needed to be standardised but for some reason the W3C (the World Wide Web Consortium who dictate web standards - Google it if you are interested) refused to do this.

It ended up at ECMA (European Computer Manufacturers Association). They are now in charge of every release of JavaScript and the direction it takes.

ECMAScript and JavaScript are the same thing, but ECMAScript is the "official" name. The language is also called by the abbreviations "JS" and "ES" (the latter usually to refer to a specific version, like "ES6").


## Web pages to web applications

Historically browser-based web applications were linked text pages - hence the name web page.

> Show old school web page - Wikipedia

Most pages used no JavaScript,  or a sprinkling to enhance the page.

For many uses this is completely valid and so far this is how we have been creating web apps using Sinatra and rails.

As JavaScript performance in the browser and on mobile phones has improved, the scope of application that can be built in the browser has grown.

> Show web app - Spotify, Google Docs...

Modern browser based applications are a world away from the web pages of the past.
For these applications the browser is no longer a lowly text display,  but a JavaScript run time environment.

Applications have moved so that a lot more "business logic" in the front end, leaving the back end to behave simply as an api.


# Using JavaScript

## Let's make some stuff

The most famous JavaScript environment is the browser.  The browser has many additional capabilites for web applications &mdash; to allow us to focus on the JavaScript language itself we will use Node.JS, which is the JavaScript engine from Chrome without the browser-specific stuff.

Next week we're going to move on to using the browser with all its extra tools.

## Variable declaration

In JavaScript we have to use a special word before the variable name.
Conventionally, variable names are camel case.

```js
var myBear;
```

Notice also the semi-colon. In JavaScript we finish each line or declaration with a semi-colon. Although your code will probably run without it, it's good practice. The exception is after a closing curly bracket (`}`) (usually).


## Creating our first program

We can make a wee function that takes in a name and prints it out to the screen.

```js
//app.js

function hello(name) {
  console.log(name + " you are awesome!");
}

hello("Keith");
```

Just like we did with Ruby, we can type `node`, the name of the Node.js interpreter, into the terminal to get our robot to run our app.

```
node app.js
```

## This course

3 Weeks and a project.

 - Week 1: Language fundamentals, TDD
 - Week 2: JavaScript in the browser
 - Week 3: JavaScript full stack. Combining both weeks.
 - Project.
