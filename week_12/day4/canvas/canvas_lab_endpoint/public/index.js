window.addEventListener('load', function() {
  var canvas = document.getElementById('main');
  var context = canvas.getContext('2d');

  var doAction = function(action) {
    context.beginPath();
    context.moveTo(position.x, position.y);
    position[action]();
    context.lineTo(position.x, position.y);
    context.stroke();
  };

  var downButton = document.getElementById('down-button');
  downButton.addEventListener('click', function(event) {
    doAction('moveDown');
  });

  var upButton = document.getElementById('up-button');
  upButton.addEventListener('click', function(event) {
    doAction('moveUp');
  });

  var rightButton = document.getElementById('right-button');
  rightButton.addEventListener('click', function(event) {
    doAction('moveRight');
  });

  var leftButton = document.getElementById('left-button');
  leftButton.addEventListener('click', function(event) {
    doAction('moveLeft');
  });
});
