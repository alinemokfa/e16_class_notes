const express = require('express');
const app = express();

app.get('/', function (req, res) {
  res.json({ data: 'Hello!' });
});

app.listen(3000, function () {
  console.log(`App running on port ${ this.address().port }`);
});
