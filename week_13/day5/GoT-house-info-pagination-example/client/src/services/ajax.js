const Ajax = function () {}

Ajax.prototype.get = function (url, onComplete) {
  const request = new XMLHttpRequest();
  request.open('GET', url);
  request.send();

  request.addEventListener('load', function () {
    if (this.status !== 200) return;
    const jsonString = this.responseText;
    const data = JSON.parse(jsonString);
    onComplete(data);
  });
}

module.exports = Ajax;
