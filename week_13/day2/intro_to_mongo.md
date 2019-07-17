# Intro To Mongo

## Objectives
- Understand what a NoSQL database is
- Understand how to run mongo on our Mac
- Understand how to create a database
- Understand how to create a collection
- Understand how to create a document
- Understand how to delete a database

## Duration

# Intro

So far we've been using SQL databases to store our information. SQL relies on tables, rows and columns to store it's data. SQL databases are great for storing _relational data_ and are highly performant for _write operations_. 

However, SQL databases are not so good when we have data which doesn't fit well into a  relational model. Let's take our films example:

```js
var films = [{
  title: "Titanic",
  reviews: [
    {
      rating: 1,
      comment: "lel"
    }
  ]
}]
```

In SQL, we'd have to deconstruct this into it's individual parts and save it to separate tables.

- A film has many reviews
- The reviews are never referenced by anything else
- We might have a Films table and a Reviews table.
- With a more compicated data source like REST Countries we'd end up with many tables (languages, bordering countries...)

Wouldn't it be nice if we could somehow just attach the reviews to the film directly and we only had ONE collection of posts? No need for a separate reviews table.

This is where NoSQL comes in!

# NoSQL

There's various NoSQL databases in the universe and the one we are going to look at is Mongo.

In Mongo, we have no concept of tables or rows or columns. No concept of joins. Nothing. All we have is _collections_ which contain _documents_ which have _field_. That's it. A document is effectively a little JSON object serialized to binary to be stored (BSON).

* Draw table on board -
```
SQL         NoSQL
---         -----
database    database
tables      collections
rows        documents
columns     fields
```


This is AMAZING news because we can just create some JSON and throw it and Mongo and it will quite happily store it for us. It's unbelievably cool.

First things first, let's have a look at making our first mongo database.

# Interacting with mongo

Let's have a look at some basic commands in the mongo terminal.

There's more good news, we write JavaScript to talk to Mongo! Not SQL! Omg!! Happy days or what??

Before we do anything, we need to start a little mongo server on our machine.

```
# terminal

mongod
```

```
# terminal

mongo
use farm;
```

This will create a database called farm if it doesn't exist, or select it if it does exist.

Now we have access to a "db" object. This has a collection of useful methods on it we can use, as well as any collections that we make.

```
# terminal - mongo

db.animals.insert({name:"charlie", type:"horse"});
```

This is interesting. This both creates a collection called animals and inserts an entry to it.

You'll notice this is sent back to us:

```
# terminal - mongo

WriteResult({ "nInserted" : 1 })

# terminal - mongod
{ "_id" : ObjectId("57ee97f632192469e2449020"), "name" : "Kenny", "type" : "Horse" }
bye
```

This tells use that 1 entry was inserted. It's also returned the entry to us, with an _id attached to it. This is a special kind of object that returns a unique identifier for the entry (constructor function with one parameter). Much like Serial8 from PostGres.

If we want to use this id, we need to use the field "_id".

To drop the database we use a method on the db object.

```
# terminal - mongo

db.dropDatabase()
```

[i]: Task:
- Create a food database
insert an entry with a 'name' and 'flavour' into a 'crisps' collection

## Scripts to the rescue

Rather than suffering this horrendous nightmare we're going to use a little script we can run. It's just going to be a simple .js file! Note though, we will be writing commands _as if we were in the mongo terminal world_. So things like console.log _will not work_. Only commands that are compatible with mongo.

```
# terminal

touch mongo_play.js
```

```js
//mongo_play.js
use farm;
db.dropDatabase();
```

We'll drop the database each time to avoid having lots of the same entry while we are playing with it.

We can run this using the following command:

```
# terminal

mongo < mongo_play.js
```

You'll see it sends any information from mongo back to us. Let's insert an animal like we did before.

```js
//mongo_play.js

use farm;
db.animals.insert({ //NEW
  name: "Erik",
  type: "Polar Bear"
});
```

Cool! We've successfully inserted an animal into our collection.

[Task:] Add another animal

## Schemaless Database

You'll notice we've not had to define a _schema_ for our database. We've not said what properties that an animal can have. Infact, Mongo doesn't care. We can put Documents into our Collections and that is all it cares about. We could add a totally unrelated thing to our db and that would be fine.

```js
//mongo_play

use farm;
db.dropDatabase();

db.animals.insert({ 
  name: "Erik",
  type: "Polar Bear"
});
db.animals.insert({ //NEW
  brand: "Nike",
  type: "Trainer"
});

```

This is both good and bad! It gives us amazing flexibility - there's no constraint on what properties must be on our documents. But it does mean it's up to us to be sensible :)

Let's change that back to be an animal.

```js
//mongo_play.js
db.dropDatabase();

use farm;
db.animals.insert({ 
  name: "Erik",
  type: "Polar Bear"
});
db.animals.insert({ //UPDATED
  name: "Fred",
  type: "Fox"
});
```

## Finding Stuff

We can find our items by using the find() method on the collection object.

```js
//mongo_play.js

db.animals.find();
```

We can also pass this little objects to find specific things for us.

```js
//mongo_play.js

db.animals.find({name: "Fred"});
```

This will only match on animals called Fred.

## Updating stuff

The update method takes at least two arguments. The first is the property to lookup

```js
//mongo_play.js

//SAME AS BEFORE
db.animals.update(
   { name: "Fred" },
   {
     $set: { type: "Goose" },
   }
)
db.animals.find();
```

## Deleting Stuff

```js
//mongo_play.js

db.animals.remove( { name: "Fred" } )
```

There's all sorts of flags we can attach to this - if we want to delete the first match or all matches etc.

## Multiple Collections

Let's make a new little database to model CodeClan. We can insert mutliple items using array notation.

```
# terminal
touch code_clan.js
```

```js
//codeclan.js
use codeclan;
db.dropDatabase();


db.students.insert([{
  name: "Fred",
  favouriteFood: "Pizza"
},
{
  name: "Jeff",
  favouriteFood: "Haggis"
}]);

db.students.find();

```

We can list all the collections in a db using the 'show collections' command.

```js
//codeclan.js

use codeclan;
db.dropDatabase();


db.students.insert([{
  name: "Fred",
  favouriteFood: "Pizza"
},
{
  name: "Jeff",
  favouriteFood: "Haggis"
}]);
db.students.find();

show collections; //NEW

```

Let's say we want to also track instructors, how do you think we'd go about making a new _collection_ inside of the _same database_ object?

```js
//codeclan.js

use codeclan;
db.dropDatabase();


db.students.insert([{
  name: "Fred",
  favouriteFood: "Pizza"
},
{
  name: "Jeff",
  favouriteFood: "Haggis"
}]);

db.students.find();

db.instructors.insert([{ //NEW
  name: "John",
  favouriteFood: "Pasta"
},
{
  name: "Jarrod", 
  favouriteFood: "Burgers"
}]);

db.instructors.find(); //NEW

show collections;

```

[Task:] Go and look at the documentation here: https://docs.mongodb.com/manual/reference/method/js-collection/

Find another method you think is cool to share with the class.

## Cheat Sheet

Show the list of databases `>show dbs`  
Switch to a different database  `>use <DATABASE>`   
Show the collections of the current database  `>show collections`   
Drop a collection  `>db.<COLLECTION>.drop()`  
Drop a database  `>db.dropDatabase()`   
Exit from the shell  `>exit`
