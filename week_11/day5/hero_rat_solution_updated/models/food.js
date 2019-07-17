const Food = function (name, replenishmentValue) {
  this.name = name;
  this.replenishmentValue = replenishmentValue;
  this.isPoisoned = false;
}

Food.prototype.poison = function () {
  this.isPoisoned = true;
};

module.exports = Food;
