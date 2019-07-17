# Hashes

### Learning Objectives

1. Create a hash
2. Add items to a hash
3. Retrieve items from a hash
4. Delete items from a hash
5. Understand what a symbol is

We have seen that we can store a collection of objects in an array object. Let's say we
wanted to store the food we are going to have that day.

```ruby 
# irb
meals = [ 'yoghurt', 'roll', 'steak' ]
meals[0]
# => 'yoghurt'
```

This is fine but we need to remember that breakfast is index 0, lunch is index 1 and dinner is index 2. We can only access items by their index in an array.

In our example, we actually have additional information about the objects in our collection. We know the first one is breakfast, the second is lunch and the third is dinner. We don't actually care which order they are stored in really. Also, if we forgot the position of breakfast we would need to search through the whole set to find it again!

In Ruby, and many other languages, there is another collection we can use: a Hash. It's sometimes called a Dictionary or Associative Array in other languages.

In a hash every item is given a unique key of our choosing and it is this key that is used to retrieve the object not an index. The order is irrelevant so we can't rely on the ordering.

Each key in the hash is unique allowing you to always find the value you stored against a particular item.

It's a little bit like a filing cabinet - we have labels we associate with things we want to store e.g. finance, recipes, reciepts. It doesn't matter what "index" the items are stored at (there's no need to know Finance is the first set of items in the drawer), what matters is the label we filed it under. If we moved all the items around, we could still find "Finance" easily by its label.

## Using Hashes

### Creating Hashes

We have a couple of options for initialising a hash. We can 'new' it up.

```ruby
# irb
my_first_hash = Hash.new
```

We can create an empty hash directly

```ruby
my_second_hash = {}
```

Lastly we can create a populated hash.

```ruby
meals = { "breakfast" => "yoghurt",  "lunch" => "roll", "dinner" => "steak" }
```

In this hash, have have keys which are string and values which are strings. The keys could be other types of things, like Integers, and the values could be any object - Arrays, Booleans, anything.

```ruby
silly_thing = { 1 => "2", 2 => "3", 4 => false }
```

### Accessing elements

We can access elements in a simlar manner to arrays. However, using the key rather than the index.

```ruby
meals["breakfast"]
```

If we try to access an element for which there is no key the hash will return `nil`. 

```ruby
meals["supper"]
```

This is a default value that is returned when accessing keys that do not exist in the hash. We can override this value if we wish by passing our own value as the argument when we create it:

```ruby
meals = Hash.new(0)
```

Now it will always return 0 when a key is not found. 

## Modifying Elements

We can add objects to a hash much like we would assign variable.

```ruby
meals["supper"] = "pancakes"
```

We can also replace objects

```ruby
meals["dinner"] = "pasta"
meals
```

We can remove items using the delete method.

```ruby
meals.delete("breakfast")
meals
```

# Helpful methods

A hash has lots of helpful methods, including a way to list all the keys:

```ruby
meals.keys
```

Can you guess the type of what has been returned? Yes! An Array.

We can also get the list of values:

```ruby
meals.values
```

# Symbols

Symbol is a class provided to us by Ruby when objects are particularly suited as keys for hashes.  A Symbol is essentially a special string, but it's a constant value. We can never alter the symbol by adding things to it or do many of the other functions we might expect to use on a string. Symbol comparison is a lot faster than String comparison so they are ideal for hash keys.

We won't get bogged down in this, but it's a very common thing in Ruby and when you start using symbols you won't want to go back to strings for keys.

```ruby
:my_sym
:hello

:my_sym + :hello #NOPE
```

```ruby
meals = { :breakfast => "yoghurt",  :lunch => "roll"  }
```

Symbols are so commonly used as keys in hashes that Ruby gives us a special syntax.

```ruby
meals = { breakfast: "yoghurt",  lunch: "roll" }
meals[:breakfast]
```

## Nested Hashes

Let's make a quick hash of countries.

```bash
#terminal

touch countries_hash.rb
```

```ruby
#countries_hash.rb

countries = {
    uk: "London",
    germany: "Berlin"
  }
}
```

This is fine, but what if we also want to store the population? Would we make a separate hash?

We can actually store a hash inside of a hash! Sounds scary, but it can actually be very useful. Let's add the populations.

```ruby
#countries_hash.rb

countries = {
	uk: {
		capital: "London",
		population: 1000
	},
	germany: {
		capital: "Berlin",
		population: 5
	}
}
```

### Task
See if you can figure out how to get the population out of Germany.

```ruby
# population of Germany
countries[:germany][:population]
```

### Task
Make a hash containing the avengers Iron Man and Hulk. Each avenger has a name (Tony Stark and Bruce Banner) and a set of moves with an attack power. Iron man can punch (10) and kick (100) and Hulk can smash (1000) and roll (500).

#### Solution

To create the hash:

```ruby
#avengers_hash.rb

avengers = {
  ironman: {
    name: "Tony Stark",
    moves: {
      punch: 10,
      kick: 100
    }
  },
  hulk: {
    name: "Bruce Banner",
    moves: {
      smash: 1000,
      roll: 500
    }
  }
}
```

To retrieve the attack power of the hulk's smash move from the hash:

```ruby
#avengers_hash.rb
# attack power of hulk's smash move

avengers[:hulk][:moves][:smash]
```


