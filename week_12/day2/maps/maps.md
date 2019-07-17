# Learning Objectives
* Make a simple google map
* Add markers
* Add click event

# Mapping and Geolocation

Maps and geolocation has become a big thing - almost every website you visit will have a map or a "share location" feature on it. Today we are going to look at how we can utilise this in our own apps.

# Google maps

> Hand out start point

First we need to include a link to the script that gives us access to the Google Maps API. Let's add it in the head tag. Google Maps is a library type of API, in that it gives us a library of code which creates an object with useful methods for us to interact with to build things. 

```html
<!-- index.html -->

<script src="https://maps.googleapis.com/maps/api/js"></script>
```

Once this is added we should be able to go into the browser console and type 'google' and see the Google Maps interface object with all its methods that are now available to us.

We also need a div for our map to live inside which we will add inside the body tags.

```html
<!-- index.html -->

<div id='main-map'> </div>
```

At the very least, this div must have a height or it won't display. Let's go to our main.css file in the public folder and give our map a width and a height.

```css
/* main.css */

#main-map {
  height:500px;
  width:500px;
}
```

There's a script in the public folder called app.js where we are going to start putting our code.
Again we need to add a link to this in our HTML. Let's add it after the Google Maps API link (order is important!).

```html
<!-- index.html -->

<script src='app.js'> </script>
```

Cool now we are ready to add our map! Now, we need to make sure our map loads AFTER the DOM is ready and the elements we expect to be there exist. In our case, it's our "map" div. 

```js
//app.js

window.addEventListener('load', initialize);
```

This calls the initialize function when the window has loaded so any code we write in there is going to execute only after the window has loaded everything in the DOM.

Let's define this function.

```js
//app.js
//PUT THIS ABOVE window.addEventListener !!

var initialize = function() {
}
```

Let's create a constructor function of our own called MapWrapper. This will hold the Google Map we create and also methods to interact with it. We'll make this in a separate script called mapWrapper.js. 

```
# terminal 

touch public/mapWrapper.js
```
We will need to add this to our index in a script tag, below app.js.

```html
<!-- index.html -->

<script src='mapWrapper.js'> </script>
```

```js
//mapWrapper.js

var MapWrapper = function() {
}
```

```js
//app.js

var initialize = function() {
 var mainMap = new MapWrapper(); //NEW
}
```
Google Maps provides us with a method that allows us to attach a google map to a particular DOM element we specify. We need to get hold of this element and pass it into that method.

```js
//mapWrapper.js

var MapWrapper = function() {
  var container = document.getElementById('main-map'); //NEW
  this.googleMap = new google.maps.Map(container, {

  }); //NEW
}
```
The second parameter here is an object which takes our settings. At the very least, we have to tell the map where to centre on for the first load and also what the zoom level should be.

```js
//mapWrapper.js

var MapWrapper = function() {
  var container = document.getElementById('main-map'); 
  this.googleMap = new google.maps.Map(container, {
    center: {lat: 40.712784, lng: -74.005941}, //NEW - WATCH SPELLING
    zoom: 10 //NEW
  });
}

```
Now if we go to localhost:3000 we should see something spectacular. Whoot! There's our map.

[TASK:] Find out the latlng for London and centre the map on it.


We should probably pass in the latlng co-ordinates to the constructor. We'll put it into a variable since we'll want to use it later.

```js
//mapWrapper.js
var MapWrapper = function(coords) { //UPDATE
  var container = document.getElementById('main-map'); 
  this.googleMap = new google.maps.Map(container, {
    center: coords, //UPDATE
    zoom: 10
  });
}
```

```js
//app.js
var initialize = function() {
var center = {lat: 51.507351, lng: -0.127758}; //NEW
var mainMap = new MapWrapper(center); //UPDATE
}
```

While we are at it, let's move the zoom and container into parameters too.

```js
//mapWrapper.js
var MapWrapper = function(container, coords, zoom) { //UPDATE
  this.googleMap = new google.maps.Map(container, {
    center: coords,
    zoom: zoom //UPDATE
  });
}
```

```js
//app.js
var mapDiv = document.getElementById('main-map'); //NEW
var mainMap = new MapWrapper(mapDiv, center, 10); //UPDATE
```

## Markers

Wouldn't it be nice to put a marker on the map to show something we are interested in? Let's do it. The easiest one to add is a marker for the centre of the map. Remember how we pulled the coordinates into a variable? It's going to come in useful now.

We can use a Google Maps Marker object, which has one parameter - a settings object. At the very least it needs a position, and a map that it's to be attached to.

Let's make a new function on our MapWrapper prototype.

```js
//mapWrapper.js

MapWrapper.prototype.addMarker = function(coords) {
  var marker = new google.maps.Marker({
    position: coords,      
    map: this.googleMap
  });
}


```
Let's add a marker to the centre of our map.

```js
//app.js

mainMap.addMarker(center);
```

There is a handy website we can use to get the lat longs for things http://www.latlong.net/ let's use this to add interesting things to our map.

[TASK]: Go off and find an interesting place nearby and add a marker to it.

## Click events

There are many map events that we can hook into - you can see them in the api documentation:

https://developers.google.com/maps/documentation/javascript/examples/event-simple

The simplest one is the click event on the whole map. Let's add a wee function to our MapWrapper to handle this.

```js
//mapWrapper.js

Mapwrapper.prototype.addClickEvent = function(){
  google.maps.event.addListener(this.googleMap, 'click', function(event){
    console.log("yo");
  });
}
```

```js
//app.js

mainMap.addClickEvent(); //REMEMBER THIS LINE
```
This function passes in an "event" object we can get properties from, including the lat lng of the point that was clicked.

```js
//mapWrapper.js

Mapwrapper.prototype.addClickEvent = function(){
  google.maps.event.addListener(this.googleMap, 'click', function(event){
    console.log(event);
    console.log(event.latLng.lat());
  });
}

```
Confusingly, the lat/lng are functions so remember the brackets to invoke them when using them.

Do you think you can combine this with the add marker function to add a marker at the location where someone clicks? 

Hint: You need to be careful with the scope of "this"...

> Give them 15 mins to try this. 


In a callback, "this" is set to the element that triggered the callback, not as we would like here, to be the object that the method was defined on.  This has cause many Javascript programmer to table flip.

We can overcome this using the bind method.  This is a method on a function that clones the function it was called on, but with this explicitly set to what we pass in.

```js
//mapWrapper.js

Mapwrapper.prototype.addClickEvent = function(){
  google.maps.event.addListener(this.googleMap, 'click', function(event){
    var position = { lat: event.latLng.lat(), lng: event.latLng.lng() }  
    this.addMarker(position);
  }.bind(this));
}

```

Great! We can now add a marker any time we click on the map. 

## Updating the markers

Currently our mapWrapper has no knowledge about the markers that have been added to the map. Let's say we wanted to add a button that animated all the markers, the mapWrapper would need to know about the markers to update them. Firstly, We are going create an array of markers in the mapWrapper constructor, that gets added to every time we add a marker.

```js
//mapWrapper.js

var MapWrapper = function(container, coords, zoom){
  this.googleMap = new google.maps.Map(container, {
    center: coords,
    zoom: zoom
  });
  this.markers = []; //NEW
}

MapWrapper.prototype.addMarker = function(coords) {
  var marker = new google.maps.Marker({
    position: coords,      
    map: this.googleMap
  });
  this.markers.push(marker); //NEW
}

```

And let's write a function that interates through our array of markers and adds a bounce animation to them.

```js
//mapWrapper.js

MapWrapper.prototype.bounceMarkers = function(){
  this.markers.forEach(function(marker) {
    marker.setAnimation(google.maps.Animation.BOUNCE)
  })
}


```

Now we need to create our button that is going to call that function and animate the markers.

```html
<!-- index.html -->

<div id='main-map'></div>
<button id='button-bounce-markers'>Bounce</button> // NEW

```

And lastly, we are going to assign our `bounceMarkers()` function to our button in app.js. 

```js
// app.js
// (in initialize)

var bounceButton = document.querySelector('#button-bounce-markers')
bounceButton.addEventListener('click', mainMap.bounceMarkers.bind(mainMap))

```

So here we are binding our `bounceMarkers()` function to the instance of the mapWrapper as we pass it to the button's event listener. In the past we have done our binding in the prototype, binding our functions to `this`, but because the button isn't part of the map, we don't want the mapWrapper to be responsible for knowing about it.