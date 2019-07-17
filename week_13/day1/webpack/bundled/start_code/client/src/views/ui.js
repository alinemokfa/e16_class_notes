const UI = function (container) {
  this.container = container;
}

UI.prototype.createText = function (text, label) {
  const p = document.createElement("p");
  p.innerText = label + text;
  return p;
}

UI.prototype.appendText = function (element, text, label) {
  const pTag = this.createText(text, label);
  element.appendChild(pTag);
}

UI.prototype.createReview = function (container, review) {
  this.appendText(container, review.comment, "Comment: ");
  this.appendText(container, review.rating, "Rating: ");
  this.appendText(container, review.author, "Author: ");
}

UI.prototype.render = function (films) {
  for (let film of films) {
    const li = document.createElement("li");
    this.appendText(li, film.title, "Film: ");

    for (let review of film.reviews) {
      this.createReview(li, review);
    }

    this.container.appendChild(li);
  }
}

module.exports = UI;
