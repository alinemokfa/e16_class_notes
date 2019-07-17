DROP TABLE pizzas;

CREATE TABLE pizzas (
  id serial4 primary key,
  first_name varchar(255),
  last_name varchar(255),
  topping varchar(255),
  quantity int2
);