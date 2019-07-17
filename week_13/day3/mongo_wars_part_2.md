# Mongo Web App part 2

## Learning Objectives
- Perform a GET, POST, DELETE request on an API using XMLHttpRequest.

## Duration
1.5 hours

# Intro

We’re going to continue with the star wars web app. We have used insomnia to test it is all working, so now we will go to the UI and hook it all.

## Read

So when the website loads, we want to pull down all the quotes so we can render them onto the page. First things first, we will call the get method from our request object, we pass it a callback which will trigger when the get request triggers. At the end of the app function we will call the method.

```
  request.get(getQuotesRequestComplete);
```

Then we declare that function.

```
  const getQuotesRequestComplete = function(allQuotes)  {
  
  }
```

Now we will say that the callback (whenever it is called), will be passed all the quotes. Lets now update the get method in request.js.

```
  Request.prototype.get = function(callback) {
    const request = new XMLHttpRequest();
    request.open('GET', this.url);
    request.addEventListener('load', function() {
      if(this.status!==200) {
        return;
      }

      const responseBody = JSON.parse(this.responseText); 

      callback(responseBody);
    });
    request.send();
  }
```

The benefit of doing it this way is that we do not have to worry about what we are getting back, so we can reuse this for not just quotes but films or anything we want!

Okay, so remember we are calling callback with the responseBodyy? Well now we need to decide what to do with this.

```
  const getQuotesRequestComplete = function(allQuotes)  {
    allQuotes.forEach(function(quote) {
      quoteView.addQuote(quote);
    });
  }
```

So we call quoteview and we add each quote (which in turn adds it to our view). And we can see it loads. Perfect. Now onto the creation of quotes in the UI.

## Create

So we have a <form> in our website. We could just add the method of Post and action to /quotes but lets say we do not want the page to load everytime we submit something, that could proving taxing. Lets first stop the form from doing that.

Inside app.js, we handle the submit button click, we can actually tell it to not do what it is originally meant to do.

```
  const createButtonClicked = function(evt) {
    evt.preventDefault();
    console.log('form submit clicked'); 
  }
```

If we now click the button it does not refresh or submit the form, we must do it manually.

We now need to get the values from the name input box and the quote input box.

```
  const createButtonClicked = function(evt) {
    evt.preventDefault();
    console.log('form submit clicked'); 

    const nameInputValue = document.querySelector('#name').value;
    const quoteInputValue = document.querySelector('#quote').value;
  }
```

So lets have a look at the request post method, it requires a callback and a body, the body is exactly what you passed in insomnia earlier today. Lets define that body now.

```
  const body = {
    name: nameInputValue,
    quote: quoteInputValue
  };
```

And finally lets call the post method and pass it the body as well.

```
  request.post(createRequestComplete, body);
```

Declare the callback 

```
  const createRequestComplete = function(quote) {
  }
```

Okay lets define the post logic. We open a post request. We check for the 201 status code this time, parse the logic as before and pass it to the callback.

```
  Request.prototype.post = function(callback, body) {
    const request = new XMLHttpRequest();
    request.open('POST', this.url);
    request.addEventListener('load', function() {
      if(this.status!==201) {
        return;
      }

      const responseBody = JSON.parse(this.responseText); 

      callback(responseBody);
    });
  }
```

Finally we need to stringify the body before we send it to the server.

```
  Request.prototype.post = function(callback, body) {
    const request = new XMLHttpRequest();
    request.open('POST', this.url);
    request.addEventListener('load', function() {
      if(this.status!==201) {
        return;
      }

      const responseBody = JSON.parse(this.responseText); 

      callback(responseBody);
    });
    request.send(JSON.stringify(body));
  }
```

Good, now lets define what happens in the callback. We know that the server will respond with the created item, so we can just pass that to quoteView and bam, there it is.

```
  const createRequestComplete = function(quote) {
   quoteView.addQuote(quote);
  }
```

Odd, why is it saying undefined. Well actually we need to tell the server what we are passing it, otherwise it doesnt know. Forms do that automatically but now we need to do that bit. Its quite straightforward, if sending content in a body to the server, tell it what it is. In this case, we tell the server that the Content-Type is application/json. Back in our post method.

```
  Request.prototype.post = function(callback, body) {
    const request = new XMLHttpRequest();
    request.open('POST', this.url);
    request.setRequestHeader('Content-Type', 'application/json'); // This line was added
    request.addEventListener('load', function() {
      if(this.status!==201) {
        return;
      }

      const responseBody = JSON.parse(this.responseText); 

      callback(responseBody);
    });
    request.send(JSON.stringify(body));
  }
```

And now it all works. Nice.


### TASK - DELETE

Okay now your turn. 

* First what does the delete button click method do. (What request method does it call)
* Next, when you say request.open, what HTTP method are we using
* What status code are we expecting? (Check server.js if in doubt)
* Are we expecting anything back from the server? 
* What does the callback do if the request is successful? What method on quoteView do we need to call?


Solution:

First lets define what happens when the button is clicked 

```
  const deleteButtonClicked = function(evt) {
    request.delete(deleteRequestComplete);
  }
```

```
  const deleteRequestComplete = function() {
  }
```

Then in request.js

```
  Request.prototype.delete = function(callback) {
    const request = new XMLHttpRequest();
    request.open('DELETE', this.url);
    request.addEventListener('load', function() {
      if(this.status!==204) {
        return;
      }

      callback();
    });
    request.send();
  }
```

Notice the 204 status code and the fact we do not need to parse any JSON as our server doesnt respond with anything.

Lastly, finish the callback.

```
  const deleteRequestComplete = function() {
    quoteView.clear();
  }
```