# Task:

We're going to be using this code in our example today, so we'd like you to have a little read through it. To make sure you really understand it complete the following tasks:

1. Add an author to a review

```js
//review.js
var Review = function(options){
  this.film = options.film;
  this.comment = options.comment;
  this.rating = options.rating;
  this.author = options.author; //NEW
}
```

2. Render this to the screen

```js
//ui.js
render: function(reviews){
  var container = document.getElementById("reviews");
  for(var review of reviews) {
    var li = document.createElement("li");
    this.appendItem(li, review.film.title, "Title: ");
    this.appendItem(li, review.comment, "Comment: ");
    this.appendItem(li, review.rating, "Rating: ");
    this.appendItem(li, review.author, "Reviewer: "); //NEW
    container.appendChild(li);
  }
}
```

3. Write out the dependencies of each file
Reviews: Film, Review
UI: Reviews
index.js: UI
