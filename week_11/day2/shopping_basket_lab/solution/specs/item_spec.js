var assert = require('assert');
var Item = require('../item.js');

describe('Item', function () {

	var item;

	beforeEach(function () {
		item = new Item({ name: 'potato', price: 1, quantity: 5, bogof: true });
	});

	it('should have a name', function () {
		assert.strictEqual(item.name, 'potato');
	});

	it('should have a price', function () {
		assert.strictEqual(item.price, 1);
	});

	it('should have a quantity', function () {
		assert.strictEqual(item.quantity, 5);
	});

	it('should have a bogof value of true if value is passed in', function () {
		assert.strictEqual(item.bogof, true);
	});

	it('should have a default bogof value of false if not passed in', function () {
		item = new Item('potato', 1)
		assert.strictEqual(item.bogof, false);
	});

});
