var assert = require('assert');
var Food = require('../food');
var Rat = require('../rat');

describe('Food', function() {
  it('should have a name', function() {
    var roland = new Rat('Roland');
    assert.equal('Roland', roland.name);
  });

  it('should poison some food', function() {
    var roland = new Rat({name: 'Roland'});
    var food = new Food({name: 'pizza', nutrition: 20});
    roland.touchFood(food);
    assert.equal(true, food.poisoned);
  });
});
