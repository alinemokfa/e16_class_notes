var MakeupGetter = require('./MakeupGetterES5');

var app = function(){
  var mg = new MakeupGetter("maybelline");
  mg.fetchProducts();
};

window.onload = app;