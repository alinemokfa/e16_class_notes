var assert = require('assert');
var Record = require('../Record.js');

describe("Record Tests", function() {

  it("Record should have a name", function() {
    var nevermind = new Record("Nirvana", "Nevermind", 9.99);
    assert.equal("Nirvana", nevermind.artist);
  });

  it("Record should have title", function() {
    var nevermind = new Record("Nirvana", "Nevermind", 9.99);
    assert.equal("Nevermind", nevermind.title);
  });

  it("Record should have price", function() {
    var nevermind = new Record("Nirvana", "Nevermind", 9.99);
    assert.equal(9.99, nevermind.price);
  });

  it("Prints out details as a string", function() {
    var nevermind = new Record("Nirvana", "Nevermind", 9.99);
    assert.equal("Artist: Nirvana, Title: Nevermind, Price: 9.99", nevermind.prettyPrint());
  });

})