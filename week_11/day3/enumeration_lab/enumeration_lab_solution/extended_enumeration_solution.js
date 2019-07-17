// Rename to enumeration.js to make tests pass!

var Enumeration = function() {}

Enumeration.prototype.forEach = function( array, callback ) {
  for( var item of array ) {
    callback( item );
  }
};

Enumeration.prototype.find = function( array, booleanFunction ) {
  var result;
  this.forEach( array, function( item ) {
    if( booleanFunction( item ) ) result = item;
  })
  return result;
};

Enumeration.prototype.map = function( array, transformFunction ) {
  var results = [];
  this.forEach( array, function( item ) {
    results.push( transformFunction( item ) );
  })
  return results;
};

Enumeration.prototype.filter = function( array, booleanFunction ) {
  var results = [];
  this.forEach( array, function( item ) {
    if( booleanFunction(item) ) results.push( item );
  });
  return results;
};

Enumeration.prototype.some = function( array, booleanFunction ) {
  var result = false;
  this.forEach( array, function( item ) {
    if( booleanFunction(item) ) result = true;
  })
  return result;
};

Enumeration.prototype.every = function( array, booleanFunction ) {
  var result = true;
  this.forEach( array, function( item ) {
    if( !booleanFunction(item) ) result = false;
  })
  return result;
};

Enumeration.prototype.reduce = function( array, accumulatingFunction ) {  
  var accumulator = 0;
  this.forEach( array, function( item ) {
    accumulator = accumulatingFunction( accumulator, item );
  });
  return accumulator;
};

module.exports = Enumeration;