var Basket = function () {
  this.items = [];
  this.loyaltyCard = false;
}

Basket.prototype.empty = function() {
  this.items = [];
}

Basket.prototype.switchLoyaltyCard = function() {
  this.loyaltyCard = !this.loyaltyCard;
}

Basket.prototype.addItem = function(item) {
  this.items.push(item);
}

Basket.prototype.removeItem = function(name) {
  for (var item of this.items) {
    if (item.name === name) {
      var index = this.items.indexOf(item);
      this.items.splice(index, 1);
    }
  }
}

Basket.prototype.applyDiscount = function(spentOver, discountPercentage) {
  var total = this.total();

  if (total > spentOver) {
    var extraDiscount = this.loyaltyCard ? 5 : 0;
    var totalDiscount = discountPercentage + extraDiscount;
    var discount = 1 - (totalDiscount / 100);
    return(total * discount);
  }

  return total;
}

Basket.prototype.calcItem = function(item) {
  if (item.quantity > 1 && item.bogof) {
    item.quantity = Math.ceil(item.quantity / 2);
  }
  return item.quantity * item.price;
}

Basket.prototype.total = function() {
  var total = 0;

  for (item of this.items) {
    var subTotal = this.calcItem(item);
    total += subTotal;
  }

  return total;
}

module.exports = Basket;
