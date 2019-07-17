var Bank = require('../bank');
var Account = require('../account');
var assert = require('assert');

describe('bank', function() {
  it('should start off with no bank accounts ', function() {
    var bank = new Bank();
    assert.equal(bank.accounts.length, 0);
  });
  it('should be able to add account', function() {
    var bank = new Bank();
    var account = new Account({owner:'Jay',amount:50, type:'buisness'});
    bank.addAccount(account);
    assert.deepEqual(bank.accounts[0], account);
  });
  it('find account by owner name', function() {
    var bank = new Bank();
    var account = new Account({owner:'Jay',amount:50, type:'buisness'});
    bank.addAccount(account);
    var foundAccount = bank.findAccountByOwnerName('Jay');
    assert.deepEqual(foundAccount, account);
  });
  // Find the total account value.
  it('should find the total account value', function() {
    var bank = new Bank();
    var account1 = new Account({owner:'Jay',amount:50, type:'buisness'});
    var account2 = new Account({owner:'Val',amount:150, type:'buisness'});
    bank.addAccount(account1);
    bank.addAccount(account2);
    assert.equal(bank.totalCash(), 200);
  });
  // Find the average value.
  it('should find the average value', function() {
    var bank = new Bank();
    var account1 = new Account({owner:'Jay',amount:50, type:'buisness'});
    var account2 = new Account({owner:'Val',amount:150, type:'buisness'});
    bank.addAccount(account1);
    bank.addAccount(account2);
    assert.equal(bank.accountAverage(), 100);
  });
  it("should find the total value for an account type", function() {
    var bank = new Bank();
    var account1 = new Account({owner:'Jay',amount:50, type:'buisness'});
    var account2 = new Account({owner:'Val',amount:150, type:'buisness'});
    var account3 = new Account({owner:'Kieth',amount:150, type:'personal'});
    bank.addAccount(account1);
    bank.addAccount(account2);
    bank.addAccount(account3);
    assert.equal(bank.totalCash('buisness'), 200);
  });
});
