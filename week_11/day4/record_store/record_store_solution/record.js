function Record(artist, title, price) {
  this.artist = artist;
  this.title = title;
  this.price = price;
}

Record.prototype.prettyPrint = function() {
  return "Artist: " + this.artist + ", Title: " + this.title + ", Price: " + this.price
}

module.exports = Record;
