var assert = require("assert");
var RecordStore = require("../RecordStore");
var Record = require("../Record.js");

describe("Record Store tests", function() {

  var recordStore;
  var record;
  var record2;

  beforeEach("Setup", function(){
    recordStore = new RecordStore("Zsolt Healy's Records", "Edinburgh");
    record = new Record("Nirvana", "Nevermind", 9.99);
    record2 = new Record("Red Hot Chilli Peppers", "By The Way", 7.99);

  });

  it("Should have a name", function() {
    assert.equal("Zsolt Healy's Records", recordStore.name);
  });

  it("Should have a city", function() {
    assert.equal("Edinburgh", recordStore.city);
  });

  it("Should start with an empty inventory", function() {
    assert.equal(0, recordStore.inventory.length);
  });

  it("Should have a balance that starts at 0", function() {
    assert.equal(0, recordStore.balance);
  });

  it("Should be able to add a record to the inventory", function() {
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    assert.equal(2, recordStore.inventory.length);
  });

  it("Should be able to list the inventory", function() {    
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    assert.equal("Artist: Nirvana, Title: Nevermind, Price: 9.99", recordStore.listInventory()[0]);
  });

  it("Record store can sell a record", function() {    
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    recordStore.sellRecord(record2);
    assert.equal(1, recordStore.inventory.length);
  });

  it("Record store's balance should increase when selling record", function() {
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    recordStore.sellRecord(record2);
    assert.equal(7.99, recordStore.balance);
  });

  it("Record store can report on finances", function() {
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    assert.equal("Current Balance: 0 Current Stock Value: 17.98", recordStore.financeReport());
  });

})