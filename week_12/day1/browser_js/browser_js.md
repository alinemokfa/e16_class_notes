# Browser JS

## Learning Objectives
- Writing JavaScript in the browser console
- Using Chrome devtools to see resources
- Understand how we can serve up JS to the browser

### Duration
45 mins

### Intro
So we are JavaScript developers.  We've created games and applications with multiple objects. JavaScript is just a programming language, in which we can describe our thoughts and ideas.

What has made JavaScript the most used language in the world, is that it is the language in which browsers talk. This week we are going to see how we can expand on the fundamental skills we gained last week, to see how they can be applied to frontend web development.

### Let's Emigrate to BrowserLand

... and let's talk about ENVIRONMENTS. Not something we've really discussed yet.

*"The browser is a really hostile programming environment."*
- Douglas Crockford

We've written JavaScript code in .js files on our computer and used node to run them. Much like we did with Ruby.

Now we're going to write scripts that are run not by node but by the JavaScript engine in the browser. Without web browsers, there would be no JavaScript. 

The browser (Chrome, Firefox, IE) will be the environment for this week.

In our case, we're using Chrome so our programs will be run by Google's V8 JavaScript engine (which happens to be the same engine that node is built on)

That's all well and good but how do we create interactivity for our users? 

### Getting Started

The focus of the week is going to be writing JS to manipulate HTML in the browser. However, to start we need to get that HTML to the browser. 

We're going to use a minimal JS server framework similar to Sinatra called Express. Can you remind me what the most basic job of a web server is to do? 

> Client-server relationship, draw if you need to

Great, let's get going and run our new little server.

> Give out start code

Let's run the server - remember we need to run npm install first to bring down Express.

```
# terminal
npm install
npm start
```

By the end of week 3 you will understand what is going on in server.js, but we won't dwell on it here.

### Console

If we right-click and inspect in the browser we get our DevTools. 

You can also use Command+alt+J to get the console up.

In here are many very useful tabs, but most important is the console. 

This is a JavaScript run time(REPL), much like IRB or the Node console. We can do all the JS stuff we learned last week.

Which tabs in DevTools do we care about?

We won't use all of these tabs, the key ones we are going to get very familiar with are:

 - [Network](https://developers.google.com/web/tools/chrome-devtools/#network)
 - [Console](https://developers.google.com/web/tools/chrome-devtools/#console)
 - [Application](https://developers.google.com/web/tools/chrome-devtools/#application)

So if we open the console we can type JavaScript code and run it. 

```
# console

var a = 1;
a;
c = {age: 25, magic: 99};
c.age;
```

Cool. A nice familiar place.

Note: We can do multiple lines with shift + return.

[Task:] Create a Wizard object with the name Harry and a function defend that says "Expecto patronum".

Solution:

```
# console

var harry = {
  name: "Harry",
  defend: function(){return "Expecto Patronum"}
}
```

### Using *script* tags

We want to start writing our JS in a javascript file, just like we did last week and then server it up to the browser (using our server.js!). To do this, we will make a new file called app.js.

```
# terminal 

touch public/app.js

```

Now, at the moment it's just floating around in space, we haven't actually told the html page we want to use it thus it's never being served up by anything (show the empty application tab). We do this using script tags.

```html
//index.html

<script src="app.js"></script>  //ADDED
```

Now, you may see sometimes that JS is being written directly inside script tags like this (no need to code along)

```html
//index.html

<script>
  var harry = "Harry";
</script>
```

This is bad, we don't want to do this for various reasons including:
* It pollutes our HTML
* It makes it hard to find our code
* It blocks the rendering of the page
* It can't be minified (can you guess what that is?)
* It can't be bundled (we will see this with Webpack next week)

And many other reasons. Always put your JS into external files.

Cool, now when inspect our site using dev tools we can see our script in resources and the network tab.

### Using our script

Cool, so let's start using our script.

```js
//app.js

console.log('sup!')
```

Great! We've successfully managed to serve up our script to the browser.

[TASK:] Create your wizard in your script and log out his defend message to the console.

Solution:

```js
//app.js
  var harry = {
    name: "Harry",
    defend: function(){return "Expecto Patronum"}
  }
  console.log(harry.defend());
```
