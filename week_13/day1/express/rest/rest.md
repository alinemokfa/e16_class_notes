# RESTful Routes in Express

## Learning Objectives
- Know how express does routes and routing
- Understand what body-parser does
- Understand the Router object
- Be able to create a RESTful api in Express

## Duration
30 mins

# Intro

Can you remember the RESTful routes? The good news is, the patterns in express are basically the same as Sinatra. We're going to have a look at some of them just now and use them to create our own very simple API.

# Read-only routes

Let's say we have a set of cats we want to interact with.

> give out start code (remember to npm install)

```js
//server.js

var express = require('express');
var app = express();

var cats = ["Bengal", "British Shorthair", "Siamese"]; //NEW

app.get('/', function (req, res) {
  res.json({ data: 'sup!'});
});

app.listen(3000, function () {
  console.log('App running!');
});
```

## Index

```js
//server.js

app.get('/cats', function (req, res) { //NEW
  res.json(cats);
});
```

## Cat by Id

Remember the most specific routes needs to go first, so be sure to put this above the cats route!

```js
//server.js
//THIS MUST GO ABOVE CATS
app.get('/cats/:id', function (req, res){
  res.json({data: cats[req.params.id]});
})
```

> use int(for array index) when passing id via url

# Update routes

## Bad news


Part of the idea behind express is to keep things as lightweight as possible, but this comes with some pros and cons.

One of the pros is that it keeps things fast. The less that express has to think about when a request is made, the faster it can hand back a response. Another good thing is that it makes things explicit. If you see express code you can easily see any extra things it is doing by looking at the extra code. 

However the downside to this is that some things you might think would be basic "out of the box" behaviour aren't there in express.

One of these missing features is a way to read data sent with the body of the request - like when we sent new names or details in Sinatra to update our models. We'll use a little library called BodyParser for this.

```
# terminal

npm install --save body-parser
```

We need to then include this in our server.js. It's horrible but we just need to deal with it.

```js
//server.js
//top of file

var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
```

Cool we now have the tools we need to deal with POST requests.

## Create a cat

Create a new cat

```js
//server.js

app.post('/cats', function (req, res) {
  cats.push(req.body.cat);
  res.json({data: cats});
});
```

We can test this using Insomnia. Insomnia is a cool little REST client we can download on our machines.

https://insomnia.rest/

- POST request to localhost:3000/cats
- Body: json {"cat": "Persian"}

Using Insomnia to make requests to our API is mimicking how it would be if someone was making a request to our API from somewhere else on the web (just like when we made requests to other APIs last week).

## Update a cat

```js
//server.js

app.put('/cats/:id', function (req, res) {
  cats[req.params.id] = req.body.cat;
  res.json({data: cats});
});
```

## Delete a cat

```js
//server.js

app.delete('/cats/:id', function (req, res) {
  cats.splice(req.params.id, 1);
  res.json({data: cats});
});
```


> CHECK IN TO SEE HOW EVERYONE IS DOING
> perhaps take a break here (if not done so already)

# Express Routing

Okay, so this is working but it's a little messy. Ideally we'd like to separate our server setup from our actual api (in case we have several resource routes in our app). Express gives us a Router object that we can use to separate our router files.

Why use routing?

  - Helps with management of MVC structured apps
  - Separation of concerns (one developer might be using ES6 in their router file. Others not.)
  - Maintainability
  - Each router can use it's own middleware
  - Easier to test

We're going to create a __controllers__ directory to hold all of our controllers.

```
# terminal - top level

mkdir controllers
cd controllers  
touch cats.js dogs.js index.js
```

Our index.js is going to pull in the other two controllers (dogs and cats) and we can us the index.js in our main app.

Let's move our cat routes __out__ of the server.js and put them in the cats controller.

At the same time we're going to remove the __cats__ prefix and get a Router object from express. 

So the files should now look like:

```js
//server.js

var express = require('express');
var app = express();


app.listen(3000, function () {
  console.log('App running on port ' + this.address().port);
});
```

```js
//controllers/cats.js

var express = require('express')
var catRouter = new express.Router();

catRouter.get('/', function (req, res) {
  res.json({data:cats});
});

catRouter.get('/:id', function (req, res) {
  res.json({data:cats[req.params.id]});
});

catRouter.put('/:id', function (req, res) {
  cats[req.params.id] = req.body.cat;
  res.json({data: cats});
});

catRouter.post('/', function (req, res) {
  console.log(req.body);
  cats.push(req.body.cat);
  res.json({data: cats});
});

catRouter.delete('/:id', function (req, res) {
  cats.splice(req.params.id, 1);
  res.json({data: cats});
});
```

Finally, we'll need to export our router to make it available to the main app.

```js
//controllers/cats.js
//SAME AS ABOVE

module.exports = catRouter;
```

Next, let's paste in our cats array.

```js
//controllers/cats.js

var express = require('express')
var catRouter = new express.Router();
var cats = ["Bengal", "British Shorthair", "Siamese"]; //NEW

catRouter.get('/', function (req, res) {
  res.json({data:cats});
});

catRouter.get('/:id', function (req, res){
  res.json({data:cats[req.params.id]});
});

catRouter.put('/:id', function (req, res) {
  cats[req.params.id] = req.body.cat;
  res.json({data: cats});
});

catRouter.post('/', function (req, res) {
  console.log(req.body)
  cats.push(req.body.cat);
  res.json({data: cats});
});

catRouter.delete('/:id', function (req, res) {
  cats.splice(req.params.id, 1);
  res.json({data: cats});
});

module.exports = catRouter;
```

Our next file controllers/index.js will be responsible for loading all controllers (we only have one at the moment). It will also define some more routes but without a prefix, like a home page and an about page.

```js
//controllers/index.js

var express = require('express');
var router = new express.Router();

router.use('/cats', require('./cats'));

router.get('/', function (req, res) {
  res.json({data: "Welcome!"});
})

router.get('/about', function (req, res) {
  res.json({data: "All about us!"});
})

module.exports = router;
```

Finally, we can include the controller/index.js in our main app. Node will always look for a file called 'index' if we specify only the directory name, but let's be specific so we can follow the flow of our app more easily.

```js
//server.js

var express = require('express');
var app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.use(require('./controllers/index'));//NEW

app.listen(3000, function () {
  console.log('App running!');
});
```

Isn't that much neater and more manageable? Let's make a request to our cats INDEX route. 

```
http://localhost:3000/cats
```


SOLUTION:

```js
//controllers/dogs.js

var express = require('express');
var dogRouter = new express.Router();
var dogs = ["Greyhound", "Golden Retriever", "Poodle"]; 

dogRouter.get('/', function (req, res) {
  res.json({data: dogs});
});

dogRouter.get('/:id', function (req, res) {
  res.json({data: dogs[req.params.id]});
});

dogRouter.put('/:id', function (req, res) {
  dogs[req.params.id] = req.body.cat;
  res.json({data: dogs});
});

dogRouter.post('/', function (req, res) {
  console.log(req.body)
  dogs.push(req.body.dog);
  res.json({data: dogs});
});

dogRouter.delete('/:id', function (req, res) {
  dogs.splice(req.params.id, 1);
  res.json({data: dogs});
});

module.exports = dogRouter;

```


```js
//controllers/index.js

var express = require('express');
var router = new express.Router();

router.use('/cats', require('./cats'));
router.use('/dogs', require('./dogs')); //NEW

router.get('/', function (req, res) {
  res.json({data: "Welcome!"});
});

router.get('/about', function (req, res) {
  res.json({data: "All about us!"});
});

module.exports = router;
```


