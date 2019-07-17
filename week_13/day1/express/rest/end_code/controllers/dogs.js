var express = require('express');
var dogRouter = express.Router();

var dogs = ["Greyhound", "Golden Retriever", "Pug"]; 

// Index
dogRouter.get('/', function(req, res) {
  res.json({ data: dogs });
});

// Show
dogRouter.get('/:id', function(req, res) {
  res.json({ data: dogs[req.params.id] });
});

// Update
dogRouter.put('/:id', function(req, res) {
  dogs[req.params.id] = req.body.dog;
  res.json({ data: dogs });
});

// Create
dogRouter.post('/', function(req, res) {
  dogs.push(req.body.dog);
  res.json({ data: dogs });
});

// Delete
dogRouter.delete('/:id', function(req, res) {
  dogs.splice(req.params.id, 1);
  res.json({ data: dogs });
});

module.exports = dogRouter;
