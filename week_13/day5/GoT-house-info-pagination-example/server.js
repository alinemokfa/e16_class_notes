const express = require('express');
const server = express();

server.use(express.static('client/public'));

server.listen(3000, function () {
  console.log(`App running on ${ this.address().port }`);
});
