DROP TABLE lightsabers;
DROP TABLE jedi;

CREATE TABLE jedi (
  id SERIAL8 PRIMARY KEY,
  name VARCHAR(255),
  darkside BOOLEAN,
  age INT
);

CREATE TABLE lightsabers (
  id SERIAL8 PRIMARY KEY,
  colour VARCHAR(255) NOT NULL,
  owner_id INT8 REFERENCES jedi(id),
  hilt_metal VARCHAR(255) NOT NULL
);

INSERT INTO jedi (name, darkside, age) VALUES ('Luke', false, 21);
INSERT INTO jedi (name, darkside, age) VALUES ('Obi-Wan', false, 33);
INSERT INTO jedi (name, darkside, age) VALUES ('Rey', false, 10);

INSERT INTO lightsabers (colour, owner_id, hilt_metal) VALUES ('green', 1, 'palladium');
INSERT INTO lightsabers (colour, owner_id, hilt_metal) VALUES ('green', 2, 'gold');
INSERT INTO lightsabers (colour, owner_id, hilt_metal) VALUES ('red', 1, 'hematite');
