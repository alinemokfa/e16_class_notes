# Databases and SQL Introduction

### Objectives

 - Understand what a database is
 - Explain what SQL is
 - Know how to use CRUD
 - Know how to create relationships

## What is a database?

A database is just somewhere for us to store our data. There are many different shapes and sizes of database. SQL is a language which is often used to query these databases and that's what we will be learning today.

## What do we do with databases

What do we store in databases?

 What sorts of manipulations do we make to data in databases?

 - Create (we can't do anything unless we can put data in)
 - Read (once it's in there, we need to get it out)
 - Update (if it needs to change, we need to be able to change it)
 - Delete (we'll need to be able to remove data from our database)

We refer to these four operations as "CRUD". This is important since you will come across it later when we begin web programming

## What is SQL?

"SQL" stands for "Structured Query Language" (pronouced either as "ess-queue-ell" or "sequel"). In the same way that we use Ruby to talk to the computer, we can use SQL to talk to a database.

## PostgreSQL

SQL is just a language - we need an engine to run it on. In the same way that Ruby is just a language, that runs on an "interpreter" - our Ruby robot we spoke about before.

PostgreSQL is an open source object-relational database system that we will be using on the course.

To check that psql is installed, we can type this.

```zsh
# terminal
which psql
```

If there are any issues with running `psql`, ensure that the `postgresapp` is installed and running (it should have been configured in installfest), and that the path is updated to include it - launch `psql` from the system icon, and note the path used.

```zsh
# terminal
psql
```

To quit the sql terminal

```sql
-- psql terminal
\q
```

## Structure

In SQL, a database is a collection of "tables". A table is a collection of "columns" and "rows".

A table describes the type of item that we want to store. A column represents some information we might find interesting about that item. A row is the physical data we want to save.

For example, we might have a Zoo database with a table called Animals. The animals table might have the columns Name, Age and Colour. The animals table might have the row "Leon, 12, Red".

## Creating a database

To work with data in databases we perform the four CRUD operations.
So we'll work through the SQL commands that give us that functionality.

Before we can do anything though, we need to create a table to store our records in. But before we can create a table, we have to create a database to put it in!

```sql
-- psql terminal
CREATE DATABASE star_wars; -- REMEMBER SEMI COLON
\q
```

## Data Types

So before we run off and create lots of shiny tables, we need to talk about datatypes. You'll be glad to hear they roughly match up to what we have already seen in Ruby. There are many data types we can use in SQL - the most common we will be using are:

* VARCHAR - fixed length text (string)
* INT - numerical data (fixnum)
* BOOLEAN - true / false data (trueclass, falseclass, booleans)

We can pass arguments to VARCHAR and INT to say how large we want the data in the field to be as a maximum.

# Creating tables

By convention, we will name our database tables as the plural of the thing we are creating. So rows of animal data would be stored in a table called Animals. Sheep would be stored in a table called... well, sheep.

Let's make a table that's going to store data about jedi. A jedi might have the following attributes:

- name
- darkside (true / false)
- age

Before we create a table, we will drop it so that we can run our script multiple times. PostGres won't let you create a table that already exists.

```zsh
# terminal
touch jedi.sql
```

```sql
-- jedi.sql
DROP TABLE jedi;

CREATE TABLE jedi (
  name VARCHAR(255),
  darkside BOOLEAN,
  age INT2
);
```

- What is our table called?
- What are the names of our columns?
- What are the size constraints?

There is a special command that we can run from the terminal to execute postgres scripts.

```zsh
# terminal
psql -d star_wars -f jedi.sql
psql
```

Open a psql terminal in a new tab, keep this open for running selects

```zsh
psql
```

```sql
# psql terminal
\c star_wars
\d+ jedi
```

We will write all of our statements in the one file and comment them out, so you can keep the story of what we are working through.


## Creating (-C-rud)

We're going to start with the C in CRUD but first let's learn the SQL statement that you'll probably use most of all.

```sql
-- jedi.sql
SELECT * FROM jedi;
```

This says 'get everything from the jedi table'. The * means 'all the fields'.

To "create" records in SQL, we use the `INSERT` clause.

We are going to make a lot of use of the Sublime shortcuts cmd + D to copy a line as well as cmd + / to comment a line.

```sql
-- jedi.sql
INSERT INTO jedi (name, darkside, age) VALUES ('luke',false, 21);
-- SEMI COLONS!
INSERT INTO jedi (name, darkside, age) VALUES ('vader',true, 100);
```

```sql
-- jedi.sql
SELECT * FROM jedi;
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```

Note that the INSERT 1 0 is that 1 row was inserted with an id of 0 (has no id, more on this later).

We need to be careful with speechmarks in postgres sql - we should always use single quotes. Single quotes behave in the normal way we'd expect - defining text. Double quotes are reserved for system operations. Try not to worry too much about this, just remember to use single quotes when dealing with data.

If we ever need to use a speechmark in our inserted text, we need to escape it with a backslash or use two of them.

We use the convention uppercase for SQL keywords and lowercase for our own terms. It's not mandatory but it makes it easier to read.

## Inserting nulls

What would happen if we do this?

```sql
-- jedi.sql
INSERT INTO jedi (name, age) VALUES ('obiwan', 33);
```

```sql
-- jedi.sql
SELECT * FROM jedi
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```
Notice that the value for darkside is null. Any values which are not passed in are set to null.

## Selecting (c-R-ud)

This is the R is CRUD.

We have been "reading" records with the `SELECT` clause.

```sql
-- jedi.sql
SELECT * FROM jedi;
```

The star is saying that we want all the fields returned, if we said:

```sql
-- jedi.sql
SELECT name FROM jedi;
```

It would only list the names.

We can also use SELECT to count how many rows we have

```sql
-- jedi.sql
SELECT COUNT(*) FROM jedi;
```

# Updating (cr-U-d)

This is the U in CRUD.

We use the `UPDATE` clause to change the values in existing records.

```sql
-- jedi.sql
UPDATE jedi SET darkside = true;
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```

Note that it says UPDATE 3 - what does this mean?

This has updated all our records (3 of them)...what if we only want certain records to update?

We can use a **WHERE** clause to achieve this.

```sql
-- jedi.sql
UPDATE jedi SET darkside = false WHERE name = 'luke';
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```

We can be even more explicit and using the AND keyword

```sql
-- jedi.sql
UPDATE jedi SET darkside = false WHERE name = 'obiwan' AND age = 33;
SELECT * FROM jedi;
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```

[TASK:]
- Add a new jedi "Anakin" with age 12 and darkside set to false.
- Update anakin to be age 22
- Update anakin's darkside to be true

```sql
-- jedi.sql
INSERT INTO jedi (name, darkside, age) VALUES ('anakin', false, 12);
UPDATE jedi SET age = 22 WHERE name = 'anakin';
UPDATE jedi SET darkside = true WHERE name = 'anakin' AND age = 22;
```


# Deleting (cru-D-)

This is the D in CRUD.

To delete records we use the `DELETE` clause. But **be careful**, there's no undo! When a record is deleted from a DB it's gone for ever. "Undelete" in the database world is "restore from last night's backup" (if there *was* a backup...)

```sql
-- jedi
DELETE FROM jedi WHERE name = 'luke';
SELECT * FROM jedi;
```

```zsh
# terminal
psql -d star_wars -f jedi.sql;
```

[Task:] Add a jedi and then delete it

# Uniquely identifying rows

What happens if we had 2 jedis with the same name and age? It's unlikely but it could happen.

```sql
-- jedi.sql
INSERT INTO jedi (name,darkside,age) VALUES ('obiwan', false, 32);
```

```zsh
# terminal
psql -d star_wars -f jedi.sql;
```

So it's 32 year old obiwans birthday. How do we uniquely identify him in the database to update him?

```sql
-- jedi.sql
UPDATE jedi SET age = 33 WHERE name = 'obiwan' AND age = 32;
```

```zsh
# terminal
psql -d star_wars -f jedi.sql;
```

That's grand but what happens when the other Obiwan's birthday comes along? We have no way of uniquely identifying this row, and any query we try to execute will update both Obiwans.

Oops.

The answer to this is to add a column to every table when we create it. That column will contain a number, which will be unique for each row in the DB, and ideally, is managed by the database itself, so we don't need to worry about adding it when we insert new records.

## Serials

We are going to need an ID column, to solve our problem of uniquely identifying rows.

The new `id` field is a `SERIAL8` type -- an internal type of PostgreSQL's, which will look after numbering for us in an eight byte integer field. This gives us up to 9 million trillion ids which is probably enough.

Serials are super special integers, that auto increment themselves. If we had simply used INT, we'd have to manually curate them and make sure we added 1 (which would be horrible). This would also cause issues if we had concurrent users - what if they both made a row at the same time? Serials take care of this nightmare for us.

Note that different database engines handle this in different ways, serials are a PostGRES specific construct which other engines might use.

Let's update our jedi

```sql
-- jedi.sql
CREATE TABLE jedi(
  id SERIAL8,
  name VARCHAR(255),
  darkside BOOLEAN,
  age INT2
);
```
If we run our script now we should see something cool. Each of our entries magically has a unique id, and we didn't need to do anything to manage it.

## Lightsabers

Let's create a table to store the lightsabers of our jedi.

Lightsabers will have

- hilt_metal
- colour
- owner name

Let's add a new table at the top of our file and comment out the queries we wrote earlier.
```sql
-- jedi.sql
DROP TABLE lightsabers; -- Above DROP TABLE jedi
-- Just below CREATE TABLE jedi 
CREATE TABLE lightsabers (
  id SERIAL8,
  hilt_metal VARCHAR(255),
  colour VARCHAR(255),
  owner VARCHAR(255)
);
```

```zsh
# terminal
psql -d star_wars -f jedi.sql;
```

Aside: You will often see 255 used because it's the largest number of characters that can be counted with an 8-bit number. It maximizes the use of the 8-bit count, without frivolously requiring another whole byte to count the characters above 255. We'll come back to binary another time.

```sql
-- jedi.sql
INSERT INTO lightsabers (colour, owner, hilt_metal) VALUES ('green', 'yoda', 'palladium');
INSERT INTO lightsabers (colour, owner, hilt_metal) VALUES ('green', 'luke', 'gold');

SELECT * FROM lightsabers;
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```

```sql
# psql terminal
SELECT * FROM lightsabers;
```

[Task:] Add a lightsaber

# Constraints

We can add "constraints" to our table definition, which will validate the data we try to enter against some basic rules.

  - A lightsaber must have a colour, an owner and a hilt metal

```sql
-- lightsabers.sql
CREATE TABLE lightsabers (
  id SERIAL8,
  colour VARCHAR(255) NOT NULL,
  owner VARCHAR(255) NOT NULL,
  hilt_metal VARCHAR(255) NOT NULL
);
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```

Let's try to insert some invalid data.

```sql
# jedi.sql
INSERT INTO lightsabers (colour) VALUES ('red');
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```


## Primary Keys

We associated lightsabers with jedis by adding the owner's name to the lightsaber table. Can you anticipate anything wrong with this?

  - Duplication - If an owner changes their name, it needs to be changed everywhere
  - What if two people have the same name?

What other solution could we use? Instead of storing the owner's name, what about storing the ID of their row in the jedi table?

If we want to use an ID, it's important that we make sure that every row has an ID. Currently, we could set the ID field of our lightsabers to be null or a duplicate value.

```sql
-- jedi.sql
UPDATE lightsabers SET ID = 1;
```

Luckily, postgres has a way to prevent this.

A primary key is a column that uniquely defines a record. A primary key column cannot contain a NULL value. A table can have only one primary key. So we are explicitly saying that we want our ID field to be our main identifier for the rows in the table.

```sql
-- jedi.sql
CREATE TABLE lightsabers (
  id SERIAL8 PRIMARY KEY, -- UPDATED
  colour VARCHAR(255) NOT NULL,
  owner VARCHAR(255) NOT NULL,
  hilt_metal VARCHAR(255) NOT NULL
);

CREATE TABLE jedi (
  id SERIAL8 PRIMARY KEY, -- UPDATED
  name VARCHAR(255),
  darkside BOOLEAN,
  age INT
);
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```

Now we can't alter it like we just did.

```sql
UPDATE lightsabers SET ID = 1;
```

## Foreign Keys

We can now use this primary key as an identifier in another table. When we do this we refer to it as a 'foreign key'. It's simply a primary key from another table.

```sql
-- jedi.sql
CREATE TABLE lightsabers (
  id SERIAL8 PRIMARY KEY,
  colour VARCHAR(255) NOT NULL,
  owner_id INT8 REFERENCES jedi(id), -- UPDATED
  hilt_metal VARCHAR(255) NOT NULL
);
```

We can see that the jedi table now has a serial id and the lightsabers table now has a "references jedi(id)" statement. Our owner_id is a reference to the primary key in the jedi table.

Foreign keys are generally named according to the convention "table_name_singular_id", unless another name makes more 'sense' (but it would always have `_id` to indicate it's a foreign key).

Now, before we do anything else - what happens if we change the order of the drops and run this again? Because lightsabers now depends on people, if we want to delete the people table we must remove any tables that depend on it's primary keys.

Otherwise we'd end up with a whole bunch of zombie references to it.  Let's fix that up and put it back in the correct sequence.

If we inspect our newly created rows, we can see the ids of the owners. Let's use these to create some lightsabers.

```sql
-- jedi.sql
SELECT * FROM jedi; --find the ids - depending on who got deleted 1 should be gone...

INSERT INTO lightsabers (colour, owner_id, hilt_metal) VALUES ('green', 2, 'palladium');

INSERT INTO lightsabers (colour, owner_id, hilt_metal) VALUES ('red', 3, 'gold');
```

```zsh
# terminal
psql -d star_wars -f jedi.sql
```

What happens if we try to add a lightsaber with an owner id of 4?

```sql
-- jedi.sql
INSERT INTO lightsabers (colour, owner_id, hilt_metal) VALUES ('red', 4, 'gold');
```

We get an error, as we would expect.


This is what we call a One to Many relationship. Each lightsaber has ONE owner (jedi).   A Jedi can have MANY lightsabers,  as different rows in the lightsaber table can have the same owner_id.

```sql
INSERT INTO lightsabers (colour, owner_id, hilt_metal) VALUES ('purple', 3, 'titanium');
```
