const Rat = require('../rat.js');
const Food = require('../food.js');
const assert = require('assert');

describe('Rat', function () {
  let rat;
  let food;

  beforeEach(function () {
    rat = new Rat();
    food = new Food('pizza', 10);
  });

  it('should be able to poison food', function () {
    rat.poison(food);
    assert.equal(food.isPoisoned, true);
  });
});
