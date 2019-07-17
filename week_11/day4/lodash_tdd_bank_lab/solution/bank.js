var _ = require('lodash');

var Bank = function() {
  this.accounts = [];
};

Bank.prototype = {
  addAccount: function(account) {
    this.accounts.push(account);
  },
  findAccountByOwnerName:function(ownerName) {
    return _.find(this.accounts, function(account) {
      return account.owner === ownerName;
    });
  },
  
  filteredAccounts: function(type) {
    if(!type) return this.accounts;
    return _.filter(this.accounts, function(account) {
      return account.type === type;
    });
  },
  
  totalCash:function(type) {
    var amounts = _.map(this.filteredAccounts(type), function(account) {
      return account.amount;
    });
    return _.sum(amounts);
  },
  accountAverage:function() {
    return this.totalCash()/this.accounts.length;
  }
};


module.exports = Bank;
