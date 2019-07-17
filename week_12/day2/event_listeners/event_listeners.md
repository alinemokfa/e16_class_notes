# Event Listeners

## Learning Objectives
- Understand how to listen to button clicks
- Undertstand how to listen to key presses

## Duration
45 mins

# Intro

So far we've seen how to pass a callback to the `window`'s load event. Turns out there's lots of other events we can hook into as well, like button clicks and all sorts of exciting things.

> Give out starter code

# Different kinds of events

## Button Clicks

Button inputs allow us to hook into their on click event. We'd like to update the paragraph text beneath it when the button is clicked, so let's do that now.

First we need to grab the button, then add an event listener to listen for click events on it.

```js
var app = function(){
  var button = document.querySelector('button');
  button.addEventListener('click', handleButtonClick);
}
```

Next we want to write the callback.

```js
var handleButtonClick = function(){
  var pTag = document.querySelector('#button-result');
  pTag.innerText = 'Woa dude, I totally got clicked!';
}

```

[TASK:] Display how many times the button has been clicked.

Solution:

```js
var buttonCounter = 0;

var handleButtonClick = function(){
  var pTag = document.querySelector('#button-result');
  buttonCounter++;
  pTag.innerText = 'Woa dude, I totally got clicked!'+ buttonCounter +' times dude!'

};
```

Sweet!

## Text changed event

Now we'd like to change the p tag text to match the text that we type into the input box. Text inputs have various events we can use to detect when a key is pressed - keyup, keydown, keypress.

We're going to use keyup. Again, let's locate the element and hook into the relevant event.

```js
//index.js

var app = function(){
  var button = document.querySelector('button');
  button.addEventListener('click', handleButtonClick);

  var input = document.querySelector('input'); //NEW
  input.addEventListener('keyup', handleKeyPress); // CHECK THIS <<<
}
```

And let's write the callback. 

```js
//index.js

var handleKeyPress = function(){
  var pTag = document.querySelector('#text-result');
}
```

We have a little bit of a problem. What we want to do is get the new value of the text box and set that value to be the innerText of the pTag. We could do this:

```js
//index.js

var handleKeyPress = function(){
  var pTag = document.querySelector('#text-result');
  var input = document.querySelector('input');
  pTag.innerText = input.value;
}
```

But it feels grubby. The object invoking the callback is actually the element we want to get back... so it turns out that "this" will be our object!

```js
//index.js

var handleKeyPress = function(){ //UPDATED
  var pTag = document.querySelector('#text-result');
  pTag.innerText = this.value; //UPDATED
}
```

Much nicer.

## On item changed

Lastly we are going to have a look at our drop down. When an item is selected, we'd like to show it in the paragraph below the drop down.

[TASK:] Go find out what event we need.

Great, so we're going to use the change event.

```js
//index.js

var select = document.querySelector('select');
select.addEventListener('change', handleSelectChanged);
```

And lastly the callback

```js
//index.js

var handleSelectChanged = function(){
  var pTag = document.querySelector('#select-result');
  pTag.innerText = this.value + ". Excellent!";
}
```

## Event

On last thing. It's worth noting that our little object actually passes something important to our callbacks - the _event_ that has happened. It has all sorts of useful information. At the moment we are totally ignoring it - let's have a quick look at it.

```js
//index.js

var handleSelectChanged = function(event){
  var pTag = document.querySelector('#select-result');
  pTag.innerText = this.value + ". Excellent!";
  console.log(event);
}
```

Just something to keep in the back of your mind.
