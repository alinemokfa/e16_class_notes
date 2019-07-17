var WaterBottle = function () {
  this.volume = 0;
  this.hydrationValue = 10;
}

WaterBottle.prototype.fill = function() {
  this.volume = 100;
}

WaterBottle.prototype.drink = function () {
  if (this.volume < this.hydrationValue) {
    var amountLeft = this.volume;
    this.volume = 0;
    return amountLeft;
  }

  this.volume -= this.hydrationValue;
  return this.hydrationValue;
}

WaterBottle.prototype.empty = function() {
  this.volume = 0;
}

module.exports = WaterBottle;
