# Canvas

### Learning Objectives
  Show creating a canvas tag.
  Show drawing basic shapes in the canvas.
  Draw objects based on where a user clicked on the canvas.

## Intro
The canvas is a DOM element that we can draw and add images onto.  It can also display custom built animations.

Some examples of what the canvas can do:

https://codepen.io/dissimulate/pen/KrAwx

https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API/Tutorial/Basic_animations

In this lesson you will draw some simple shapes on the canvas and tie DOM events to the canvas. 

Let's add the canvas element to our page.
> Handout startpoint

```js
  //index.html
    <body>
      <canvas id='main-canvas' width='600' height='500'></canvas> //NEW
    </body>
```

Can't see anything? Let's put a border around it so we can see the canvas and let's put the canvas in the top left of our window.
```css
  //public/main.css
  body {
    margin: 0;
  }
  canvas {
    border: 1px solid black;
  }
```

Okay great we have somewhere that we can draw on. Let's get to it.

## Getting a canvas context to render onto
We want to find the canvas element.  Where should the code live to find the element?(discuss)
The callback that we pass to the window to fire off on its load event might work. That way we'll know that the DOM has loaded and we'll be able to find our canvas.

```js
  //index.js
  window.addEventListener('load', function() {
    var canvas = document.getElementById('main-canvas');
    console.log('canvas', canvas);
  });
```

We can see that the canvas has loaded and we've assigned it to a variable for us to use.

To draw anything on the canvas, we need a 'context' object to render our drawing onto. We can think of the context as a rendering layer. Canvases can render things onto 2D or 3D contexts - we'll be using a 2D one for this lesson.

Here we ask for a 2D context to use so that we can begin drawing.

```js
  //index.js
  window.addEventListener('load', function() {
    var canvas = document.getElementById('main');
    // console.log('canvas', canvas);
    var context = canvas.getContext('2d');
    console.log(context);
  });
```

## Drawing a rectangle

The canvas object is pretty simple and only comes with one default shape we can draw, a rectangle (or square!). You can call either fillRect() or strokeRect() to draw one.

Note: When we talk about filling a canvas drawing, that's filling the whole shape with colour. Stroking means drawing a line along the path that is drawn.

The context fillRect and strokeRect methods take in 4 arguments: (x, y, width, height).

The x and y state the position where the rect should be, on a grid that starts with 0,0 in the top left corner.

```js
  //index.js
  var context = canvas.getContext('2d');

  //draw rectangle
  context.fillRect(10, 10, 50, 50);

```

> [see the Canvas_grid.png image]

Why is it black?  Black is the default fill color for the canvas.
[Task] Change the the color of the rectangle to color of your choice.
https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API

Solution

```js
  //index.js
  var context = canvas.getContext('2d');

  //draw rectangle
  context.fillStyle = 'pink';
  context.fillRect(10, 10, 50, 50);

```

## Drawing Paths
For lines and shapes other than rectangles we need to draw paths. You can think of a path as a series of points, connected by lines, that we can then either stroke the outline of or fill. 

### Drawing a line

```js
  //index.js
  //draw line
  context.beginPath();
  context.moveTo(100,100);
  context.lineTo(100,200);
  context.stroke();
};
```

## Drawing a triangle

```js
  //index.js
  //draw triangle
  context.beginPath();
  context.moveTo(200, 200);
  context.lineTo(200, 300);
  context.lineTo(100, 300);
  context.closePath();
  context.stroke();
};
```

It is important to note that for the stroke command to return to the starting point we have to call closePath(), otherwise it will just stroke the lines we've told it to draw. However the fill command will automatically close off the path by returning to the start and then fill the resulting shape. 

### Drawing a circle
To draw a circle we also draw a path, with the help of the arc method.
https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API/Tutorial/Drawing_shapes

[Task]  Draw a circle 10mins.
https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/arc

Solution:
context.arc(x, y, radius, startAngle, endAngle, anticlockwise)
[i]: The angles are measured in radians. A radian is the distance of the radius if it was laid around the circle. The circumference of a circle is 2*PI*R.  0 = 0, 180deg(half circle) = Math.PI,  360deg(full circle) = 2*Math.PI
> Can show drawing only half a circle to explain start angle, end angle

```js
  //index.js
  //draw circle
  context.beginPath();
  context.arc(400,100,50,0,Math.PI*2,true); 
  context.stroke();
```

## Interactive canvas
Not only can we draw on the canvas bus we can interact with it.  This is done in the same way interact with any DOM element through events.  Just like we listened to a button click.  We can do the same with the canvas.

```js
  //index.js
  canvas.addEventListener('click', function(event) {
    console.log('clicked', event);
  });
```

In the callback we get passed the event, we can find from this the location that was clicked.

```js
  //index.js
  canvas.addEventListener('click', function(event) {
    console.log('clicked', event);
    console.log('location', event.x, event.y);
  });
```

Note: The event.x/y location gives us where the mouse has been clicked relative to the whole window NOT relative to the canvas. It works fine for us here as our canvas is positioned in the top left of the window. If we want to see where we clicked relative to the canvas, we need to use event.layerX and event.layerY.  

Let's draw a circle at the point which we click.

First let's move the drawing circle functionality into a function:

```js
  //index.js
  var drawCircle = function(x,y) {
    context.beginPath();
    context.arc(x,y,50,0,Math.PI*2,true); 
    context.stroke();
  }
```

And now let's call it when we receive a click event:

```js
  //index.js
  canvas.addEventListener('click', function(event) {
    drawCircle(event.x, event.y);
  });
```

Great, we have an interactive canvas! We can change the 'click' to 'mousemove' for a fun spirograph effect - try it out. 

## Drawing images

To save time, we can import images from outside of our canvas and draw them onto it. This is often used for things like backgrounds or game sprites. 

The drawImage method takes a range of parameter lists, we're going to use the one that uses 5: drawImage(image, x, y, width, height). The image that gets passed in needs to be a HTML image element. As we don't already have the image in an <img> element on our page we can just create a new one and set its src to be the image we want.

```js
  //index.js

  var img = document.createElement('img');
  img.src = "http://emojis.slackmojis.com/emojis/images/1457563042/312/doge.png";

```

Until the image has loaded we can't do anything to it, so we have to use its load event. As we're only loading one image we'll do this right here in our main file, if you were loading lots you would abstract out this code.

```js
  //index.js

  var img = document.createElement('img');
  img.src = "http://emojis.slackmojis.com/emojis/images/1457563042/312/doge.png";

  var drawCat = function(){
    context.drawImage(img, 200, 200, 90, 90);
  }

  img.addEventListener('load', drawCat);

```

Voila! A lovely cat icon. 

## Connecting outside elements to the canvas through event listeners

We're going to connect a colour picker input element to our canvas, so that when we change the colour the stroke colour of the canvas changes. First we need to make a colour input element:

```html
  //index.html
  <input type="color" id="input-colour"> //NOTE AMERICAN COLOR SPELLING

```

We then get this element from the DOM, and assign an onchange event to it. 

```js
  //index.js
  //colour picker button
  var colourPicker = document.querySelector('#input-colour');
  colourPicker.addEventListener('change', changeColour);
```

In our changeColour function we need to find out which colour has been chosen. This gets set to the 'value' of the input, so we can just use 'this.value' to access it. Finally we set that value to be the stroke colour.

```js
  //index.js
  //colour picker button
  var changeColour = function(){
    // console.log(this.value)
    context.strokeStyle = this.value;
  }

  var colourPicker = document.querySelector('#input-colour');
  colourPicker.addEventListener('change', changeColour);
  
```

Now when we change colours, we can use our click event to draw circles of different colours. 
