# Reading the DOM

## Learning Objectives
- Understand what the document object is
- Know how to access and update DOM elements

### Duration
1 hour

## Document Object
The document object represents any web page loaded into the window and serves as the entry point to the page's content and the DOM tree.

The document is the object that we're most interested in. It has methods that we can use to access DOM elements. 

You can think of these as the tags in our HTML document but wrapped with extra properties and functionality.

The document will be our friend for the next few days.

When the window onload event is triggered, we know that the document has loaded. This means we can now access elements in the DOM and start manipulating them with JavaScript. 

Why? This is the crux of frontend JS. To be able to manipulate what the user experiences without having to make another request to the server. 

If we type 'document.' (the dot is important) into the console you'll see a huge list of methods that are attached to it.

```
  //browser console!
  document.
  document.children
```

## Accessing DOM Elements

There are a handful of methods on the document object that we will use a lot to dip into the DOM and grab a reference to the HTML elements.

> Hand out dom_manipulation_start_point give them 5 mins to look at the html and understand it


## Accessing By ID

Let's say we want to find the tagline div.
We can ask the document to get us specific elements by its ID

```js
//console 
var element = document.getElementById('tagline'); 
```

## Accessing Elements By Class Name

```js
//console 
var elements = document.getElementsByClassName('quote'); 
```

How do we get the first one? Hint, it's an array...

```js
//console 
var element = document.getElementsByClassName('quote')[0];
```

## Accessing Elements by Tag Name

```js
//console 
var elements = document.getElementsByTagName('p');
```

### Task

* Select the cite tags
* Select the quote of the day aside

Solution:

```js
document.getElementsByTagName('cite');
document.getElementById('quote-of-the-day');
```

## Using querySelector to Get The First Item

With HTML5 we have another way to query the DOM.
Query selector takes in a string and uses CSS selectors to know what it is looking for.

```js
//console 
var element = document.querySelector('.quote');
```

We can get all the items by doing this

```js
//console
var elements = document.querySelectorAll('.quote');
```
 
This looks very similar to CSS... so how do you think we get an element by it's ID?
```js
//console
var element = document.querySelector('#sign-up');
```

### Children

Note that we can get at the elements inside of another element using the children property.

```js
//console
var element = document.querySelector('#sign-up');
element.children;
```

We can loop over these using a normal for loop

```js
//console
var element = document.querySelector('#sign-up');
var children = element.children;
for (var i = 0; i < children.length; i++) {
  console.log(children[i]);
};
```

## Updating Elements

Ok, that's all good and well. But what can we do with the elements once we've got them?

### Updating The innerHTML and innerText

We can change the text like we did before, or even the HTML.

```js
  //broswer console
  var tagline = document.getElementById("tagline");
  tagline.innerText = 'New Tagline';
  tagline.innerHTML = '<h2>New Tagline</h2>';
```

### Updating The Class Name

.className gets and sets the value of the class attribute of an element.

```js
// browser console
var quotes = document.getElementsByTagName('article');
var articleClass = quotes[0].className;
```

```js
// set the class name of an element
quotes[0].className = 'red-quote';
```

We can use the style property to alter the css

```js
var tagline = document.getElementById("tagline");
tagline.style.backgroundColor = "yellow";
```

# MiniLab: 30mins (pairs)

Using app.js do the following:

- Task 1: Hide the quote of the day.
- Task 2: Give all the articles a sweet DodgerBlue background

> Good to talk about difference between visibility hidden, display: none.

Hiding an element can be done by setting the display property to none. The element will be hidden, and the page will be displayed as if the element is not there.

Alternatively visibility:hidden; also hides an element.

However, the element will still take up the same space as before. The element will be hidden, but still affect the layout.

SOLUTION:

```js
var app = function() {

  var qotd = document.querySelector('#quote-of-the-day');
  // qotd.style.visibility = 'hidden';
  qotd.style.display = 'none';

  var articles = document.getElementsByTagName('article');
  for (var i = 0; i < articles.length; i++) {
    articles[i].style.backgroundColor = 'wheat';
  };

}
```
