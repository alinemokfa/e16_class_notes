var Bank = function() {
  this.accounts = []
}

Bank.prototype.addAccount = function (account) {
  this.accounts.push(account)
}

Bank.prototype.totalValue = function () {
  var total = this.accounts.reduce(function(acc, currentAccount) {
    return acc + currentAccount.value;
  }, 0)
  return total
}

Bank.prototype.accountByName = function (name) {
  var foundAccount = this.accounts.find(function(account) {
    return account.name === name;
  })
  return foundAccount;
}

Bank.prototype.largestAccount = function () {
    var largest = this.accounts[0]

    this.accounts.forEach( function( account ) {
      if (account.value > largest.value ) {
        largest = account;
      }
    })
    return largest;
}

// Alternative using reduce()

// Bank.prototype.largestAccount = function() {
//   return this.accounts.reduce(function(largest, account){
//     return largest.value > account.value ? largest : account;
//   })
// }

Bank.prototype.averageValue = function () {
  return this.totalValue() / this.accounts.length
}

module.exports = Bank;
