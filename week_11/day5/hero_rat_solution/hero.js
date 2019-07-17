var Hero = function(spec) {
  this.name = spec.name;
  this.health = 100;
  this.favouriteFood = spec.favouriteFood;
};

Hero.prototype.eat = function (food) {
  var multiplier = 1;
  if( food.name === this.favouriteFood ) {
    multiplier = 1.5;
  }
  if( food.poisoned ) {
    multiplier *= -1;
  }
  this.health = this.health + ( food.nutrition * multiplier );
};

module.exports = Hero;
