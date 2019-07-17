# Local Storage

## Learning Objectives

- Understand what localStorage is
- Be able to add an item to localStorage
- Be able to retrieve an item from localStorage

## Duration
40 mins

## Intro

Up until now we've been losing the state of our application every time we load the page. We can do lots of awesome things with JavaScript, but as soon as we refresh the page everything is reset back to the initial values defined in our HTML and `window`'s `load` event`.

Luckily the browser has a little key/value store similar to `SharedPreferences` that we saw in Android Studio.

> Give out starter code

## Saving to local storage

Local storage is just a bit of memory we can access in the browser that we can use to store small pieces of data. It acts just like an object, in that it stores key value pairs.

If we run our little app, we should see a couple of text inputs and a button. When we click the button the text value of the inputs is displayed on the page. This is lost as soon as we refresh the page though.

We're going to use `localStorage` to persist our favourite food between requests. First, we need to store the data about the favourite food.

```js
// index.js

var handleButtonClick = function () {
  var name = getInputValue('name');
  var species = getInputValue('species');
  
  var pet = {
    name: name,
    species: species
  };

  setDefinitionText('name-display', pet.name);
  setDefinitionText('species-display', pet.species);
  
  localStorage.setItem('pet', pet); // NEW
}
```

Now if we open up the application tab in Chrome, we can see that a new key `pet` has been created and our object has been stored under it. There's a problem though... Our object has been turned into the string `"[object Object]"`. We'll need to convert our object to JSON first if we want to store it properly.

```js
var jsonString = JSON.stringify(pet) // NEW
localStorage.setItem('pet', jsonString); // UPDATED
```

Great! Now our object is being stored properly. Let's get the data back out and display it when the page loads.

```js
// index.js

var app = function () {
  var button = document.querySelector('button');
  button.addEventListener('click', handleButtonClick);

  var jsonString = localStorage.getItem('pet'); // NEW
  var savedPet = JSON.parse(jsonString); // NEW

  setDefinitionText('#name-display', savedPet.name); // NEW
  setDefinitionText('#species-display', savedPet.species); // NEW
}
```

Woo! Our pet is now persisted between page refreshes! We could even close the browser or restart the server and our data would still be there when we came back. Awesome!
