# Intro to Python

Duration: 1 - 1.5 hours

## Learning Objectives

- Understand that learning different languages / technologies is an essential part of being a developer
- Appreciate that Python and Ruby share many common features and ideas
- Gain exposure to some basic Python programming

### Introduction

We've spent four weeks getting to grips with Ruby, learning all the syntax we need to make thing in that language. What happens if you see a job you really want to apply for, but it advertises, say, Python as a requirement rather than Ruby?

You shouldn't let this put you off! New programming languages can be learned relatively quickly, when you have a solid foundation in OOP, as we have.

Let's demonstrate this. We're going to work through - essentially - the first two weeks of the course, in an hour.

### About Python

Python was created by the Dutch engineer, Guido Van Rossum, in the late 1980s. It is a high-level, interpreted language, which aims to be easy-to-learn, and easy to read and write.

It also places quite a big emphasis on aesthetics - beautiful, or _Pythonic_ code.

Let's see what that means, in practice!

```bash
> python
```

We can launch a Python REPL ("Read - Evaluate - Print - Loop") by using the `python` command. It's just like doing `irb` in Ruby.

```Python
import this
```

The Zen of Python is a poem that outlines what the Python community considers to be the essence of good Python practice. For a (slightly!) more formal outline, check out [PEP8](https://www.python.org/dev/peps/pep-0008/).

> It's ctrl-d or `quit()` to quit the Python REPL!

### Starting off

Note that we'll be using the version of Python that comes with your Mac. (Probably 2.7.) This is a wee bit out of date, but it's still quite widely used. Python 3.x is the latest version, and is a bit more common now.

In Python, we can print things by using the `print()` command:

```Python
print("Hello World!")
print(35)
```

Now Python isn't _quite_ as object-oriented as Ruby. In Ruby, every method is attached to an object. In Python, we've got the idea of in-built functions. We don't need to import these functions - they are just always available. We're going to see a few more of these later.

Just like we did in Ruby, we can assign variables:

```python
my_name = "John"
print("Hello, " + my_name)
```

There's no string interpolation in Python 2, so we can just concatenate using the `+` operator.

The REPL is fine to play with, but let's write a slightly longer program.

```bash
mkdir pyplay
cd pyplay && touch basics.py
atom .
```

OK! We can put code in `.py` files, and execute them with - for example - `python basics.py`.

```python
# basics.py
print("Hello world!")
```

> Execute the file as above.

### Functions

In Ruby, we use the `def...end` syntax to denote what should belong inside a function. In Python, we use indentation to manage this. Anything that belongs inside our function is indented one tab to the right.

```python
def say_hello():
    print("Hello World!")

say_hello()
```

If we de-indent the print statement, we get an IndentationError.

```python
def say_hello():
print("Hello World!")

say_hello()
```

Python is much stricter than Ruby when it comes to brackets - you *must* use brackets to call functions or methods in Python.

Opinion varies on whether tab or space characters should be used, but you can set up your editor to do either. The PEP8 document suggests spaces, but it also suggests that the most important thing is to be consistent.

We can also pass arguments to functions:

```python
def say_hello(name):
    print("Hello " + name)

say_hello("Bob")
```

### Conditionals

Conditionals are indented in the same way - anything that is indented once to the right of the `if` statement is considered to belong to that statement.

```python
def greet(name):
    if(name == "John"):
        print "Hi, " + name
    else:
        print "Err, I don't know you!"

greet("John")
greet("Zsolt")
```

### Arrays

There are no arrays in Python - just something very, very similar called a `list`. The main difference between Python and Ruby is that we don't have the many, many array methods that Ruby has.

But we do have the most common ones!

[Check the docs here](https://docs.python.org/2.7/tutorial/datastructures.html#more-on-lists).

We have (at the time of writing):

- `append()`
- `extend()`
- `insert()`
- `remove()`
- `pop()`
- `index()`
- `count()`
- `sort()`
- `reverse()`

That's it!

Each method has various - sometimes optional parameters to control how they behave.

Let's try it out in the REPL.

```python
my_list = ["Spam", "Ham", "Eggs"]
my_list.reverse()
print(my_list)
```

And just like in Ruby, we can store different types in an array.

```python
my_stuff = [1, 2, "apple", "banana"]
```

### Loops

Lists and arrays aren't much use without loops, so let's take a look at how that works.

In Ruby, we had numerous options for looping through data structures. We had `for..in`, `each`, `times..do`, `while`, `until`, `unless`...

In Python, again, you have far fewer options: `for..in`, and `while`. Let's take a loop at a for loop in Python.

```python
# basics.py
favourite_foods = ["Pizza", "Cake", "Sandwiches"]

for food in favourite_foods:
    print(food)

print "The loop has finished!"
```

Just as we did with functions, we're indenting the code that lives inside the `for` loop. (And we're de-indenting once we're finished, and adding another print statement for good measure.)

This is a good time to introduce you to another important feature of Python. Due to the very active community there are a ton of well written, well documented external libraries - or packages, as we call them for Python. If you installed Python or Python3 with homebrew, you should have the pip package manager, which you can check in the terminal with `pip -V` or `pip3 -V`

If you do have one, you can just run 

```
pip install numpy
```

to install NumPy, a scientific computing library that let's you do amazing things.

Let's create 2 new arrays, and try to multiply them!

```python
array1 = [2,4,6]
array2 = [1,3,5]

print(array1 * array2)
```

We obviously get an error. However, if we convert these arrays to NumPy arrays, we will get the ability to multiply 2 arrays with each other!

```python
import numpy as np
array1 = np.array([2,4,6])
array2 = np.array([1,3,5])

print(array1 * array2)
```

And this is how you install/require packages.

### Hashes

Python doesn't have hashes either, but it does have something called a `dictionary` which is again, very similar. The biggest difference is that a dictionary's keys *must* be a string. Anything else will throw an error.

```python
# basics.py
person = {
    "name": "John",
    "favourite_foods": ["Pizza", "Cake", "Sandwiches"]
}

print(person["name"])

for food in person["favourite_foods"]:
    print food
```

We also have the `.keys()` and `.values()` methods to return the keys and values, as a list in Python 2.

> Watch out - Python 3 returns something different here, which you have to convert to a list by doing `list(person.keys())`, for example

### OOP

Now that you've seen the basics of Python, let's look at classes and objects. We're going to do some TDD.

```bash
# terminal
touch TestCake.py Cake.py
```

Let's start off by importing the stuff we need in the TestCake.py file.

```python
# TestCake.py
import unittest
from Cake import Cake

```

In Ruby, we `requir`ed the files we needed, but in Python, it's a little more complicated than that.

Python has the idea of Packages and Modules. For now, it's OK to think about a module as a single Python file. A Package can be thought of as a directory containing modules.

> It's actually a little bit more subtle than that, but this explanation is OK to begin with.

So when we do `import unittest`, we're actually importing a single module - a single Python file. When we do `from Cake import Cake`, we're importing a single class from the module `Cake`.

We should also be aware that we need to tell Python where our code lives on our machines, by setting an environment variable called the PythonPath. However, we don't need to worry too much about this if our code is in one directory, as it will be today.

Let's proceed.

```python
# TestCake.py
import unittest
from Cake import Cake

# added
class TestCake(unittest.TestCase):

```

So we've added our class definition, and we've included `unittest.TestCase` in the brackets - this means that our class will inherit from that class.

> You might want to mention that Python actually supports multiple inheritance by including more than one class in the parentheses.

```python
# TestCake.py
import unittest
from Cake import Cake

class TestCake(unittest.TestCase):
    # added
    def setUp(self):
        ingredients = ["Sugar", "Flour", "Chocolate"]
        self.cake = Cake("Brownie", ingredients, 5)
```

OK - so we create a `setUp` method on the class that will run prior to every test, creating a new cake.

But we're adding a `self` parameter to setUp - what's that about?!

Methods attached to a class in Python *must* include the `self` parameter on their signature. _This is the instance of the class in question_. We don't need to use `self` when we're calling the method, but we do need to use it in our method signatures.

So we can assign instance variables by doing `self.thing`. This is much the same as doing `@thing` in Ruby.

Let's continue, and write a few tests.

```python
import unittest
from Cake import Cake

class TestCake(unittest.TestCase):
    def setUp(self):
        ingredients = ["Sugar", "Flour", "Chocolate"]
        self.cake = Cake("Brownie", ingredients, 5)

    # added
    def test_cake_has_name(self):
        self.assertEquals("Brownie", self.cake.name)

    def test_cake_has_ingredients(self):
        self.assertEquals(3, len(self.cake.ingredients))

    def test_cake_has_rating(self):
        self.assertEqual(5, self.cake.rating)
```

OK, so there are a couple of things to note.

We don't need `attr_accessor` or anything like that. Python doesn't really have any concept of access modifiers. ([In one famous post](https://mail.python.org/pipermail/tutor/2003-October/025932.html), this philosophy was described as "We're all consenting adults here"!) So if we want to get the cake's name, we can just do `self.cake.name`.

We're also creating a new Cake instance by calling `Cake(arguments)`.

There's one more line we need to add to make the tests run:

```python
# ...end of file, all the way to the left
unittest.main()
```

Now we can run our tests and watch them fail.

We can make these tests pass by creating the class:

```python
# Cake.py
class Cake:
    def __init__(self, name, ingredients, rating):
        self.name = name
        self.ingredients = ingredients
        self.rating = rating
```

The `__init__` method is just like Ruby's `initialize()`. Notice that we pass in the instance, in `self`, even though we don't have to pass it in when we create an instance in the test file.

This can be a little confusing - it means that the method signature has four arguments, while we only actually pass three in when we create a Cake object.

Finally, let's write a test for a method on our class.

```python
# TestCake.py
def test_cake_can_bake(self):
    self.assertEqual("The cake is baking!", self.cake.bake())
```

And make it pass:

```python
# Cake.py
def bake(self):
    return "The cake is baking!"
```

### Optional task

Add a cake shop class, and tests.

A cake shop should have:

- A name
- A list of cakes

A cake shop should be able to calculate the average rating of the cakes it has in stock. (You will need to look into the `sum` built-in method, and you might need to look into how to convert integers to floats - `float()`.)
