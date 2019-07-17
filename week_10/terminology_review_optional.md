# Terminology Revision

## Learning Objectives

- Brief reminder of some terminology so there is no room for confusion

> In this lesson, the aim is to get students to attempt answers first, and crowd-source something decent. 

### Functions & Methods

What is a function and what is a method?
Generally speaking both are the same, they are a piece of code that can be called by name, passed data to and potentially return data. The difference however is that methods are part of an object and can interact with the objects properties.

### Arguments & Parameters

Parameters are variables defined in the function as data that can be passed into the method or function

Arguments are actual values that we passed into the function.

So if I were to say "What arguments did you pass?" 
Your response should be along the lines "An array of numbers, or string or whatever you passed"

If i were to say "What parameters does it accept?"
Then your response could be "It accepts 3 things, hashes, or strings or whatever"

### Reference vs Primative types

Primative types are types that are stored directly in memory. So int a = 5 meaning in the memory address that a points to, there will be a value of 5. Primative types are not objects and have no methods.

Reference types however, only have a pointer stored in memory, with the pointer pointing to another bit of memory that is specially designed for dynamic allocation of data.

(If you want to know more, look into Stack & Heap) 

### Type

So with types, all we are really saying is "What data type is it"

Now, the type can be anything, interfaces, enums, classes etc. Even primatives like int, double, float etc.

So lets go to basics. If I have a

```
    public int doBearStuff(Animal bear) {
        return bear.doBearStuff();
    }
```

And i say what type does doStuff return? It returns type int.

Again, if i ask what parameter does doBearStuff accept? It accepts one parameter of type what?

Type bear, amazing, great.

Again its the same with enums, array, interfaces. So type edible, type array etc. All of these are correct in terminology.

Note: If i say what is the return value, now i am actually asking what was returned! Like 5, or "hello" or a new bear that has the name shirley.

## Class Properties and Fields

So, our class Animal has lets say a name or age. What can we call this.

```
    public class Animal {
        private string name;
        private int age;
    }
```

Well you have 2 choices. One way to say that Animal has 2 properties, an name and a age, what type are these?

Cool, another terminology you could hear are fields. So if i said that Animal has 2 fields, a name and an age, then I am still saying the same thing technically.

## Declaring a variable

So when I say you need to declare a variable of type int. What am i actually asking you guys to do?

Well technically i have just saying create a variable of type int, lets say we will call it a.

```
    int a;
```

Quite straightforward, but now you know what declaring something means. I can say, oh first you should declare an array of strings. And lets call that variable strArray. You will know to write

```
    String[] strArray
```

## Instance

So if I were to access you to declare an instance of the person class. All i am asking you is to declare a variable, lets call it person and it will be of type person. 

```
    Person person;
```

This can be interchangable with object. Now remember, instance is used for classes etc. You dont say an instance of primative types. 

## Initilize

Okay, so you declared a variable. But if I were to say, oh you are getting that bug because you forgot to initilize that variable. Now what could I be saying. 

Well all I am saying is that you declared the variable like so

```
    int a;
```

But you never set a to anything, you tried to use a but never actually done anything with it, it could be any value (which is dangerous).

So to fix it I can say either

```
    int a = 5;
```

or some fancy other logic

```
    int a;
    if(something)
        a = 5;
    else
        a = 6;
```

## Instantiation 

Instantiation is just my way of saying create or initilize a class. Only used for objects etc not primative types.

So if i said you need to instanciate the person class. I am just telling you to use the new keyboard.

```
    Person person = new Person("Darren")
```

## Constructors
So if I where to say to you, what is a constructor? Or create a constructor?

Well a constructor is a method, that has no return type, that describes how to set up the class, kinda like using the blueprint to create our object. The constructor could do a few things, but normally they accept parameters to initilize some properties.

```
    public class Animal {
        private string name;

        public Animal(string name) {
            this.name = name;
        }
    }
```

So that method, has no return type (doesnt return anything) but accepts a parameter of type string (variable named name) and initializes the instance property (name) to be what was passed in the parameter. 

# Access Modifiers

This is just what visibility there is on properties or fields, classes, interfaces, enums etc.

So is it public, private, protected or no modifier (default).

Lets touch base with that for now:

Public -> Accessable inside class, package, subclass (same package), subclass (different package), and the world. So pretty bad.

protected -> Accessable inside class, package, subclass (same package), subclass (different package), but NOT the world. So this is good if you wanted people to be able to modify it only if they extend it (or through methods for the world).

private -> Just accessible by the class, subclasses dont see it, nobody sees it and only accessible through methods if they exist.

default (no modifier) -> Accessable inside class, package, subclass (same package), but not subclasses of different packages and not the world. So this can be good if lets say i wanted my own stuff to be able to mess with it, but if anyone extends it then they cannot touch it. Cool.


# Resources
 
Access Modifiers table: http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
Terminology for beginners: http://www.programmingforbeginnersbook.com/blog/expand_your_programming_vocabulary/

