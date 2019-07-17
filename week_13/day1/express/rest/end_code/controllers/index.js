var express = require('express');
var router = express.Router();

router.use('/cats', require('./cats.js'));
router.use('/dogs', require('./dogs.js'));

router.get('/', function(req, res) {
  res.json({ data: "Welcome!" });
})

router.get('/about', function(req, res) {
  res.json({ data: "All about us!" });
})

module.exports = router;
