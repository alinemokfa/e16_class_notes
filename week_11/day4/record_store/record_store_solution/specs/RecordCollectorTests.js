var assert = require("assert");
var RecordCollector = require("../RecordCollector.js");
var RecordStore = require("../RecordStore.js");
var Record = require("../Record.js");

describe("Record Collector Tests", function() {

  var recordStore;
  var record;
  var record2;
  var recordCollector;

  beforeEach("Setup", function() {
    recordStore = new RecordStore("Zsolt Healy's Records", "Edinburgh");
    record = new Record("Nirvana", "Nevermind", 9.99);
    record2 = new Record("Red Hot Chilli Peppers", "By The Way", 7.50);
    recordCollector = new RecordCollector(8.00);
  });

  it("Record collector's has cash of 8.00", function() {
    assert.equal(8.00, recordCollector.cash);
  });

  it("Record collector can buy a record", function() {
    recordCollector.buyRecord(record2);
    assert.equal(1, recordCollector.collection.length);
  });

  it("Record collector's cash goes down when buying record", function() {
    recordCollector.buyRecord(record2);
    assert.equal(0.50, recordCollector.cash);
  });

  it("Record can't buy record if not enough cash", function() {    
    assert.equal("Sorry you can't afford this record", recordCollector.buyRecord(record));
    assert.equal(0, recordCollector.collection.length);
  });

  it("Record Collector can sell record", function() {
    recordCollector.buyRecord(record2);
    recordCollector.sellRecord(record2);
    assert.equal(0, recordCollector.collection.length);
  });

  it("Record Collectors cash increases when selling", function() {
    recordCollector.buyRecord(record2);
    recordCollector.sellRecord(record2);
    assert.equal(8.00, recordCollector.cash);
  });

})