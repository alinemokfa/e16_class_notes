const Food = require('../food.js');
const assert = require('assert');

describe('Food', function () {
  let food;

  beforeEach(function () {
    food = new Food('pizza', 10);
  });

  it('should have a name', function () {
    assert.strictEqual(food.name, 'pizza');
  });

  it('should have a replenishment value', function () {
    assert.strictEqual(food.replenishmentValue, 10);
  });

  it('should initially not be poisoned', function () {
    assert.strictEqual(food.isPoisoned, false);
  });

  it('should be able to be poisoned', function () {
    food.poison();
    assert.strictEqual(food.isPoisoned, true);
  });
});
