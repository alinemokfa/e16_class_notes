var app = function() {
  addQuote("Some dude", "This is a quote");
  addQuote("Jay Chetty", "That's totally a frog");
};

var addQuote = function(author, text) {
  var quoteArticle = createQuoteArticle();
  var blockquote = createBlockQuote(text);
  var cite = createCite(author);
  var quotes = document.querySelector('#quotes');
  appendElements(quotes, quoteArticle, blockquote, cite);
};

var createQuoteArticle = function() {
  var quoteArticle = document.createElement('article');
  quoteArticle.classList.add('quote');
  return quoteArticle;
};

var createBlockQuote = function(text) {
  var blockquote = document.createElement('blockquote');
  blockquote.innerText = text + " ";
  return blockquote;
};

var createCite = function(author) {
  var cite = document.createElement('cite');
  cite.innerText = author;
  return cite;
};

var appendElements = function(quotes, quoteArticle, blockquote, cite) {
  blockquote.appendChild(cite);
  quoteArticle.appendChild(blockquote);
  quotes.appendChild(quoteArticle);
};

window.onload = app;