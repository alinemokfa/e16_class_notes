# JS Ajax

## Learning Objectives

- Understand what a REST api is
- Understand how to make an api call using JS
- Understand what JSON is
- Understand the difference between a JSON string and a JSON object

## Duration
45 mins

# Intro

A lot of what we do on the web is going to involve apis. This could be our own apis that we build, or it could be consuming an api someone else has made. There's all sorts of cool apis we can use, from weather data to spotify. Either way, we are going to want to grab some data and do something with it. The good news is this is fairly easy in JS and pretty neat too.

# Rest APIs

Do you remember what REST is? We used restful routes in our Sinatra apps when we made our applications, that adhered to the 7 restful routes. The good news is that most apis adhere to these rules too so it makes them really easy to use.

Before we go any further, go and grab the JSON formatter extension for Chrome:

https://chrome.google.com/webstore/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa?hl=en

This will make it a lot easier to read our JSON results.

Let's have a look at the api we are going to use today - the rest countries api.

https://restcountries.eu/

### Task
Have a read of the documentation and the routes. 
Visit them in your browser and look at the data.

So the main route we are going to use today is this one

https://restcountries.eu/rest/v2/all

This gives us ALL the country data.

> If the API is down there is a very similar version at https://restcountries.herokuapp.com/api/v1 - country name is slightly different to access but otherwise works the same.

# JS HTTP Requests

So we could have made a request to this api in Java, or Ruby. However, the results would have been dealt with _server side_ then delivered to the browser in the request.

JS is really cool because we make the request _from the client directly_ using a special object in JS.

The key point about about making requests in JS is that the client requests information from the server in the background and doesn't interrupt the user on the page. There's no reloading anymore, it's all seamless. Exciting right??

Let's have a go.

## Our first JS HTTP request

> give out starter code

First thing we will do is stuff our url we want to use into a variable then pass this to a function which will be responsible for making the request along with a callback it should invoke when the request has completed.

```js
//index.js

var app = function(){
  var url = 'https://restcountries.eu/rest/v2';
  makeRequest(url, requestComplete);
}
```

Next we want to create this function.

```js
//index.js

var makeRequest = function(url, callback){
  //create a new XMLHttpRequest object
  var request = new XMLHttpRequest();
  //set the type of request we want with the url we want to call
  request.open("GET", url);
  //set the callback we want it to use when it has completed the call
  request.addEventListener('load', callback);
  //send the request!
  request.send();
}
```

Lastly we need to write our little callback.

```js
//index. js

var requestComplete = function(){
  console.log("Whoot!");
}
```

Great, it's working. Now let's actually use the data that is returned!

```js
//index.js

var requestComplete = function(){
  //this will be the request object itself
  if(this.status !== 200) return;
  //grab the response text
  var jsonString = this.responseText;
  console.log(jsonString);
  var countries = JSON.parse(jsonString);
  var country = countries[0];
}
```

Woah! As you can see the response comes back as a massive string, which isn't much use to anyone. In order to use it in a meaningful way, we want to convert it to a _json object_. Since although the string is in _json format_ it is _not_ an object, it's a string. We want to convert it to be an object, so we can acces properties on it etc. Luckily, there is a helper method we can use.

```js
//index.js

var requestComplete = function(){
  if(this.status !== 200) return;
  var jsonString = this.responseText;
  var countries = JSON.parse(jsonString); //NEW
  console.log(countries);
}
```

Let's grab the first country and have a look at it.

```js
//index.js

var requestComplete = function(){
  if(this.status !== 200) return;
  var jsonString = this.responseText;
  var countries = JSON.parse(jsonString); 
  var country = countries[0]; //NEW
  console.log(country); //NEW
}
```

OK, we know we have an array of countries on our frontend now. We can remove our console.log Let's add them to our list so that they display on the page.

```js
//index.js

var requestComplete = function(){
  if(this.status !== 200) return;
  var jsonString = this.responseText;
  var countries = JSON.parse(jsonString); 
  populateList(countries); //CHANGED;
}
```

We're passing responsibility for creating the list to another function. Let's create it.

```js
//index.js

var populateList = function(countries){
  console.log(countries);
}
```

Now we can do our work with the DOM and add li elements to the ul. We'll need to loop round our countries array.

```js
//index.js
var populateList = function(countries){
  var ul = document.getElementById('country-list');

  countries.forEach(function(country){
    var li = document.createElement('li');
    li.innerText = country.name;
    ul.appendChild(li);
  });
}
```

Hooray! We know have a nice list of all the countries.

### Exercise (15 mins)
  - Instead of making the AJAX call when the window loads, add a button that when clicked, makes the AJAX call and populates the list.