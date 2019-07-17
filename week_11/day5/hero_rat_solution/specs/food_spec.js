var assert = require('assert');
var Food = require('../food');

describe('Food', function() {
  it('should have a name', function() {
    var food = new Food({name: 'pizza', nutrition: 20});
    assert.equal('pizza', food.name);
  });
  it('should have a nutritional value', function() {
    var food = new Food({name: 'pizza', nutrition: 20});
    assert.equal(20, food.nutrition);
  });
  it('should not be poisonous', function() {
    var food = new Food({name: 'pizza', nutrition: 20});
    assert.equal(false, food.poisoned);
  });
  it('should be able to be poisoned', function() {
    var food = new Food({name: 'pizza', nutrition: 20});
    food.poison();
    assert.equal(true, food.poisoned);
  });

});
