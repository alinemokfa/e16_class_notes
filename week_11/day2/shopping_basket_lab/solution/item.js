var Item = function (options) {
	this.name = options.name;
	this.price = options.price;
  this.quantity = options.quantity;
	this.bogof = options.bogof || false;
}

module.exports = Item;
