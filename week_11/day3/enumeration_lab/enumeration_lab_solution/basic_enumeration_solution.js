var Enumeration = function() {}

Enumeration.prototype.find = function (array, callback) {
  for (var object of array) {
    if (callback(object)) {
      return object;
    }
  }
}

Enumeration.prototype.map = function (array, callback) {
  var newArray = [];
  for (var object of array) {
    newArray.push(callback(object));
  }
  return newArray;
}

Enumeration.prototype.filter = function (array, callback) {
  var filteredArray = [];
  for (var object of array) {
    if (callback(object)) {
      filteredArray.push(object);
    }
  }
  return filteredArray;
}

Enumeration.prototype.some = function (array, callback) {
  var result = false;
  for (var object of array) {
    if (callback(object)) {
      result = true
    }
  }
  return result;
}

Enumeration.prototype.every = function (array, callback) {
  var resultArray = [];
  for (var object of array) {
    if(callback(object)) {
      resultArray.push(object);
    }
  }
  if (resultArray.length === array.length){
    return true
  } else {
    return false
  }
}

Enumeration.prototype.reduce = function(array, callback) {
  var total = 0;
  for (var object of array) {
    total = callback(total, object)
  }
  return total;
}

module.exports = Enumeration;
