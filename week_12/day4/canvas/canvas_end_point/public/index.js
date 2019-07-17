window.addEventListener('load', function() {
  var canvas = document.getElementById('main-canvas');
  // console.log('canvas', canvas);

  var context = canvas.getContext('2d');
  // console.log(context);

  //draw rectangle
  context.fillStyle = 'pink';
  context.fillRect(10, 10, 50, 50);

  //draw line
  context.beginPath();
  context.moveTo(100,100);
  context.lineTo(100,200);
  context.stroke();

  //draw triangle
  context.beginPath();
  context.moveTo(200, 200);
  context.lineTo(200, 300);
  context.lineTo(100, 300);
  context.closePath();
  context.stroke();
  context.fill();

  //draw circle
  var drawCircle = function(x, y){
    context.beginPath();
    context.arc(x,y,50,0,Math.PI*2,true); // Outer circle
    context.stroke();
  }

  canvas.addEventListener('click', function(event) {
    drawCircle(event.x, event.y);
    // drawCircle(event.layerX, event.layerY);
    // console.log(event)
  });

  // draw image
  var img = document.createElement('img');
  img.src = "cat.png";

  var drawCat = function(){
    context.drawImage(img, 200, 200, 90, 90);
  }

  img.addEventListener('load', drawCat);

  // color picker button
  var changeColour = function(){
    // console.log(this.value)
    context.strokeStyle = this.value;
  }

  var colourPicker = document.querySelector('#input-colour');
  colourPicker.addEventListener('change', changeColour);
});
