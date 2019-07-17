var express = require('express');
var catRouter = express.Router();

var cats = ["Bengal", "British Shorthair", "Siamese"]; 

// Index
catRouter.get('/', function(req, res) {
  res.json({ data: cats });
});

// Show
catRouter.get('/:id', function(req, res) {
  res.json({ data: cats[req.params.id] });
});

// Update
catRouter.put('/:id', function(req, res) {
  cats[req.params.id] = req.body.cat;
  res.json({ data: cats });
});

// Create
catRouter.post('/', function(req, res) {
  cats.push(req.body.cat);
  res.json({ data: cats });
});

// Delete
catRouter.delete('/:id', function(req, res) {
  cats.splice(req.params.id, 1);
  res.json({ data: cats });
});

module.exports = catRouter;
