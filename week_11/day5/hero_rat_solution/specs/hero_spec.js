var Hero = require('../hero');
var Food = require('../food');
var assert = require('assert');

describe('hero', function() {
  it('should have a name', function() {
    var hero = new Hero({name: 'Ift'});
    assert.equal('Ift', hero.name);
  });
  it('should start at 100 health', function() {
    var hero = new Hero({name: 'Ift'});
    assert.equal(100, hero.health);
  });
  it('should have a fav food', function() {
    var hero = new Hero({name: 'Ift', favouriteFood:'pizza'});
    assert.equal('pizza', hero.favouriteFood);
  });
  it('should be able to gain health through eating', function() {
    var hero = new Hero({name: 'Ift', favouriteFood:'pizza'});
    var foodStub = { name:'aFood', nutrition:20 };
    hero.eat(foodStub);
    assert.equal(120, hero.health);
  });
  it('should be able to gain 1.5 times nutrition if fav food', function() {
    var hero = new Hero({name: 'Ift', favouriteFood:'pizza'});
    var foodStub = { name:'pizza', nutrition:20 };
    hero.eat(foodStub);
    assert.equal(130, hero.health);
  });
  it('should lose health if made poisonous', function() {
    var hero = new Hero({name: 'Ift', favouriteFood:'pizza'});
    var food = new Food({name: 'cake', nutrition: 20});
    food.poison();
    hero.eat(food);
    assert.equal(80, hero.health);
  });
});
