var Food = function(spec) {
  this.name = spec.name;
  this.nutrition = spec.nutrition;
  this.poisoned = false;
};

Food.prototype.poison = function() {
  this.poisoned = true;
}

module.exports = Food;
