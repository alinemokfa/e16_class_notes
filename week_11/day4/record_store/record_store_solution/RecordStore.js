function RecordStore(name, city) {
  this.name = name;
  this.city = city;
  this.inventory = [];
  this.balance = 0;
}

RecordStore.prototype.addRecord = function(record) {
  this.inventory.push(record);
}

RecordStore.prototype.listInventory = function() {
  var inventoryList = this.inventory.map(function(record) {
    return record.prettyPrint()
  })
  return inventoryList
}

RecordStore.prototype.sellRecord = function(recordToSell) {
  var recordIndex = this.inventory.indexOf(recordToSell);
  this.inventory.splice(recordIndex, 1);

  this.balance += recordToSell.price
}

RecordStore.prototype.calculateStockValue = function() {
  var stockValue = null;
  this.inventory.forEach(function(record) {
    stockValue += record.price;
  });
  return stockValue.toFixed(2);
}

RecordStore.prototype.financeReport = function() {
  var stockValue = this.calculateStockValue();
  return "Current Balance: " + this.balance + " Current Stock Value: " + stockValue

}


module.exports = RecordStore;
