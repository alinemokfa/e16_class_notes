# Many to Many - Join tables

Let's create a new database to model a zombie apocalypse. We want to keep track of which victims have been bitten by which zombies and when it happened. Looking at the description of what our DB will do, all the nouns indicate tables we'll need.

Zombies will have
- a name
- a type
- an id

Victims will have
- name
- run speed
- id

Extension:
How can we track the victims that a given zombie has bitten, and which zombies have bitten a given victim?

>  draw this on the board (many to many)

```sql
  DROP TABLE zombies;
  DROP TABLE victims;

  CREATE TABLE zombies
  (
    id SERIAL8 PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255)
  );

  CREATE TABLE victims
  (
    id SERIAL8 PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    run_speed INT2
  );

  INSERT INTO victims (name, run_speed) VALUES ('Aline', 12);
  INSERT INTO victims (name, run_speed) VALUES ('Callum',11);
  INSERT INTO victims (name, run_speed) VALUES ('Kayla',15);
  INSERT INTO victims (name, run_speed) VALUES ('John',30);

  INSERT INTO zombies (name, type) VALUES ('Tony', 'crawler');
  INSERT INTO zombies (name, type) VALUES ('Sandy', 'runner');
  INSERT INTO zombies (name, type) VALUES ('Darren', 'witch');
  INSERT INTO zombies (name, type) VALUES ('Jarrod', 'tank');
```

Now zombie's can bite multiple people, and people can be bitten by multiple zombies (ouch) so we can't simply add a person_id to a zombie or a zombie_id to a person. What are we going to do?

This is where the magic of join tables comes in.

```sql
# psql terminal
 CREATE DATABASE zombies;
```

```bash
 #terminal
 touch zombies.sql
 psql -d zombies -f zombies.sql
```
This is fine, but we need some way to marry the two tables together. A zombie can bite many victims and a victim can be bitten by many zombies.

In zombies.sql

```sql
-- zombies.sql
-- First drop table

DROP TABLE bitings;

-- Last created table
CREATE TABLE bitings
(
  id SERIAL8 PRIMARY KEY,
  victim_id INT8 REFERENCES victims(id),
  zombie_id INT8 REFERENCES zombies(id),
  infected_on DATE NOT NULL
);
```

Now let's add some unfortunate incidents to the bitings table.

```sql
-- zombies.sql CHECK THESE IDs exist in your db!!!

INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (1, 1, 'March 27 2017');
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (2, 2,'March 29 2017');
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (4, 3, 'March 30 2017');

--zombie 1 went on a killing spree
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (1, 3, 'March 30 2017');
```

How do we find out the names of the people who have been bitten by Tony?

```sql
-- zombies.sql

  -- First, find out the ID of Tony.
  SELECT * FROM zombies WHERE name = 'Tony';

  -- We just want the victim_id for our purposes.
  SELECT victim_id FROM bitings WHERE zombie_id = 1;

  -- Now we can get the people's names from the person_ids. Note that (2,3) is kind of like an array.
  SELECT name FROM victims WHERE id IN (1,3);
 ```

We had to execute three queries here to get the data we wanted, which isn't very efficient. But it got us there.
