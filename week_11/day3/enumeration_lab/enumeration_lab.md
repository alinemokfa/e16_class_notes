# Enumeration

Your task is to write your own enumeration methods, doing the same thing as the pre-existing ones:

* `find()`
* `map()`
* `filter()`
* `some()`
* `every()`

Bonus points:

* `reduce()`
* Write your own `forEach()` function and use it in your other enumeration methods. (There is no test for this!)

Write your functions in the enumeration.js file in a similar fashion:

```
var Enumeration = function() {}

Enumeration.prototype = {

  find: function(array, callback) {
    // code here that makes the test pass!
  }

module.exports = Enumeration;
```

You will be given start code and some tests ( `./specs/enumeration_specs.js` ) and all you have to do is make them pass!
