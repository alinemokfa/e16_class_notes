# Writing the DOM

## Learning Objectives
- Know how to create and append DOM elements

### Duration
1.5 hours

## Creating DOM elements and appendChild

Cool so we've seen how to update elements, but we haven't seen how to create them.

We can create new DOM elements using document.createElement(name of element) and add it to the page.

Let's create a new quote. There's a few steps to this. Before we start, we need to have a look at the structure of a quote.

Article (.quote) -> Blockquote -> Cite

Next, we need to build these up in order starting with the parent container(article).

```js
//app.js
var app = function () {
  //1. Create the parent container and it's class
  var quoteArticle = document.createElement('article');
  quoteArticle.classList.add('quote');

  //2. Create the first child (blockquote)
  var blockquote = document.createElement('blockquote');
  blockquote.innerText = "New Quote. ";

  //3. Create the child inside the blockquote
  var cite = document.createElement('cite');
  cite.innerText = "Some Person";

  //4. Append the cite to the blockquote
  blockquote.appendChild(cite);

  //5. Append the blockquote to the article
  quoteArticle.appendChild(blockquote);

  //6. Add everything to the quotes list
  var quotes = document.querySelector('#quotes');
  quotes.appendChild(quoteArticle);
}
```

[Task:] 30 mins (pairs)

We'd like to make it easy to add new quotes, so we're going to refactor this to a function we can reuse. Or rather, you are!

Make this a named function and refactor it to be separate functions. Try not to make it too abstract, just do something simple to get the job done.

e.g you might have your named function call a function that looks like this:

```
var addQuote = function(author, quoteText) {
  var quoteArticle = createQuoteArticle();
  var blockQuote = createBlockQuote(quoteText);
  var cite = createCite(author);

  appendElements(quoteArticle, blockquote, cite);
}
```

Solution:

```js
var QUOTES_ARRAY = [
  { quote: "Now is the summer of our discontent", author: "Shakespeare" },
  { quote: "Go away!", author: "Matt Healy" },
  { quote: "Classic Steve...", author: "Cohort 9" }
];

var createQuoteArticle = function(){
  var quoteArticle = document.createElement('article');
  quoteArticle.classList.add('quote');
  return quoteArticle;
}

var createBlockQuote = function(text){
  var blockquote = document.createElement('blockquote');
  blockquote.innerText = text + " ";
  return blockquote;
}

var createCite = function(author){
  var cite = document.createElement('cite');
  cite.innerText = author;
  return cite;
}

var appendElements = function(quotes, quoteArticle, blockquote, cite){
  blockquote.appendChild(cite);
  quoteArticle.appendChild(blockquote);
  quotes.appendChild(quoteArticle);
}

var addQuote = function(author, text){
  var quoteArticle = createQuoteArticle();
  var blockquote = createBlockQuote(text);
  var cite = createCite(author);
  var quotes = document.querySelector('#quotes');
  appendElements(quotes, quoteArticle, blockquote, cite);
}

var app = function(){
  for (var quote of QUOTES_ARRAY) {
    addQuote(quote.author, quote.quote);
  }
}

window.onload = app;
```


