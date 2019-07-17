# Introduction to sockets

Approx 30-45 minutes.

## Learning Objectives

- Understand the advantages of using socket.io rather than polling for changes
- Understand how to use socket.io to create a realtime multi-user application

### Introduction

Let's think about a situation where we would want to build something like an online chatroom.

How could we go about building something like this, using the techniques we know already?

> Give the class a chance to discuss how they might go about this. Lead them towards...

 We could push new messages to a server, and maybe use MongoDB to store them. Then, we could use a technique called _polling_ to repeatedly ask the server for information at predefined intervals.

 Although this wouldn't work too badly, there are some disadvantages to such an approach:

- If chat messages were sent _more_ frequently than our poll period, there would be a delay before they saw the most recent messages. They might not even be responding to the latest messages. Oh no!
- If chat messages are sent _less_ frequently than our poll period, we are sending more requests than we need to, using more bandwidth, and putting the server under more strain.

There is a different solution to this problem of real-time updates: we're going to look at a library called socket.io.

### What is socket.io?

The socket.io website tells us that it allows "real-time bidirectional event-based communication." But what does that mean?

Basically, it means that our client and server can have a two-way conversation, easily passing information back and forth. You can think of it like a telephone call, where one person speaks and the other responds.

By contrast, when we use polling, it's more like sending a letter to someone. You fire off a request, (maybe) get a response, then the connection is closed.

In this context, our server is going to be powered by Express, and our client is going to be powered by `create-react-app`; a web app.

We could just as easily connect to our server using an Android or iOS app with socket.io - it has clients for those platforms too.

Socket.io is a really powerful library that allows us to build all sorts of real-time applications, from chatrooms, to games, and much, much more.

Let's take a look at how we can use socket.io to build a chatroom.

> Hand out the start_point, and ask the students to set it up and spend five minutes looking over the code.

### Our strategy

Notice that in our ChatContainer component, we have an array of messages inside the state object. When a new message is pushed onto that array, the child components re-render, showing the new message on the page.

When we submit a message, we want to pass it up to our server instead. Then, the server is going to broadcast this message to all connected clients, which will push this message onto their own individual states. This will trigger the same re-rendering we saw before.

It's important to note that communication in socket.io is _event based_. This means that our clients will be firing an event (which we'll call 'chat') and our server will be listening out for this event.

### Server set up

Firstly, we need to configure our server. Let's install the server's dependencies, and install socket.io while we're at it.

```bash
cd server
npm install
npm install --save socket.io
```

And let's open up our server-side code:

```bash
atom .
```

Let's take a look at our server.js file. It should look pretty familiar, but there are a couple of points to note.

Firstly, you'll see that server.js is listening on port 3001, rather than the more usual 3000. This is so that we can run our server and create-react-app at the same time. (create-react-app likes to sit on port 3000 too!)

We're also using something that might look a little bit unfamiliar:

```js
// allows cross origin resource sharing
app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "http://localhost:3000");
  res.header("Access-Control-Allow-Credentials", true);
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
```

This snippet of code just ensures that we can connect to our server from port 3000, which will be our create-react-app.

### Listening for connections

Next, we want to listen out for any incoming socket connections in our server.js file.

We're going to bring in socket.io to work with:

```js
// server.js
var express = require('express');
var app = express();
var http = require('http').Server(app);
var io = require('socket.io')(http); // ADDED
```

Next, we're going to listen out for any incoming socket connections:

```js
// server.js

// Underneath the CORS stuff:
io.on('connection', socket => {

});
```

So when server.js hears an incoming connection coming in, it's going to do whatever is in the anonymous function that we've written.

Next, let's listen out for a particular event happening, and we'll call it 'chat'.

```js
// server.js

io.on('connection', socket => {
  // ADDED
  socket.on('chat', message => {
    io.sockets.emit('chat', message);
  });
});
```

So when the server receives a 'chat' event, with a message, it's going to broadcast that message to all connected clients by calling `io.sockets.emit`.

For the two arguments in this function call, we're going to label the outgoing event as 'chat' again, and we're going to broadcast the same message to all clients that we received.

That's all we need to do in the server file.

### Client

In our client, we need to do a bit of initial setup.

```bash
# open a new terminal tab
cd ../client
npm install
npm install --save socket.io
```

Now we need to tackle two things in our client code:

- Instead of pushing each new message onto our own state array, we need to push it up to the server
- We need to listen for any new messages coming in, and handle them appropriately

First of all, let's give ourselves the socket library to work with in the client.

```js
// client/containers/ChatContainer.jsx

import React from 'react';
import ChatForm from '../components/ChatForm';
import Message from '../components/Message';
import io from 'socket.io-client'; // ADDED
```

Notice that we're importing the socket.io _client_ here.

Next, we need a socket instance variable to work with. We're going to use this to send and receive to and from the server. (Notice that we need to pass in the URL of our server.)

```js
// client/containers/ChatContainer.jsx

this.state = {
  messages: [],
  name: null,
  msg: null
};

// ADDED
this.socket = io("http://localhost:3001");
```

We're going to handle sending requests up to the server next. Instead of pushing messages onto our own array, we're going to push them up to the server:

> Make sure you delete `this.addMessage(newMessage)` from the following function

```js
// client/containers/ChatContainer.jsx

submitForm(event) {
  event.preventDefault();

  // Make sure we have a name & message before proceeding
  if (this.state.name && this.state.msg) {
    // construct a new message
    const newMessage = { author: this.state.name, text: this.state.msg };

    // CHANGED
    this.socket.emit('chat', newMessage);
  }
}
```

So once we've created a new message object, we're just passing it up to the server using the socket instance variable that we created earlier. Notice that we're tagging it as 'chat' - this is the event that the server is listening out for.

Finally, we need our component to listen out for any messages being sent to it.

```js
// client/containers/ChatContainer.jsx, in constructor()

this.socket = io('http://localhost:3001');
this.socket.on('chat', this.addMessage.bind(this)); // ADDED
```

We might need to restart our client and server here, but at this point, everything should be working!

Open two browser windows pointing at http://localhost:3000 and test it out! You should see that chat messages sent on one client appear on the other.

### A step further

> Note that the Edinburgh network doesn't currently allow connections to other machines, so this section of the codealong won't work. However, you can demo the app at [Heroku](https://blooming-chamber-44519.herokuapp.com/). It might take a minute or two to fire up when it's first loaded.

Find your IP address by running the following command:

```bash
# terminal

ipconfig getifaddr en0
```

Test it out by asking all the students to go to http://{YOUR_IP_ADDRESS}:3000/ in their web browsers and typing a few messages.
