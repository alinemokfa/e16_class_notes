var Basket = require('../basket.js');
var Item = require('../item.js');
var assert = require('assert');

describe('A Basket', function () {

  var basket;
  var item1;
  var item2;
  var item3;

  beforeEach(function () {
    basket = new Basket();
    item1 = new Item({ name: 'carrot', price: 0.5, quantity: 1 });
    item2 = new Item({ name: 'tv', price: 100, quantity: 1, bogof: true });
    item3 = new Item({ name: 'water bottle', price: 5, quantity: 2, bogof: true });
  });

  it('should have no items to begin with', function () {
    assert.strictEqual(basket.items.length, 0);
  });

  it('should be able to add an item', function () {
    basket.addItem(item1);
    assert.strictEqual(basket.items.length, 1);
  });

  it('should be able to remove an item', function () {
    basket.addItem(item1);
    basket.removeItem('carrot');
    assert.strictEqual(0, basket.items.length);
  });

  it('should calculate cost of a single item', function () {
    assert.strictEqual(0.5, basket.calcItem(item1));
  });

  it('should not apply 10% discount of less than 20 quid', function () {
    basket.addItem(item1);
    var total = basket.applyDiscount(20, 10);
    assert.strictEqual(0.5, total);
  });

  describe('when our basket is populated with items', function () {
    beforeEach(function () {
      basket = new Basket();
      basket.addItem(item2);
    });

    it('should be able to empty itself of items', function () {
      basket.empty();
      assert.strictEqual(0, basket.items.length);
    });

    it('should calculate basket total', function () {
      assert.strictEqual(100, basket.total());
    });

    it('should apply 10% discount of over 20 quid', function () {
      var total = basket.applyDiscount( 20, 10 );
      assert.strictEqual(total, 90);
    });

    it('should get an extra 5% discount if loyalty card', function () {
      basket.switchLoyaltyCard();
      var total = basket.applyDiscount( 20, 10 );
      assert.strictEqual(total, 85);
    });
  });

  describe('when we have basket with bogofs', function () {
    beforeEach(function () {
      basket = new Basket();
      basket.addItem(item2);
      basket.addItem(item3);
    });

    it('should calculate cost of a single item with a bogof', function () {
      assert.strictEqual(basket.calcItem(item3), 5);
    });

    it('should allow bogof offers and reduce total', function () {
      var total = basket.total();
      assert.strictEqual(total, 105);
    });
  });
});
