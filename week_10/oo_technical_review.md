# OO Interview Revision

## Learning Objectives

- Know the sorts of OO questions that might arise at interview
- Understand what interviewers are looking for when asking those questions
- Be able to answer common OO interview questions

> In this lesson, the aim is to get students to attempt answers first, and crowd-source something decent. Then you can explain what sort of answer interviewers will be looking for.

## Classes and Objects

Question: In traditional OO programming the two main constructs are Classes and Objects.  Can you explain what they are and how they differ?

Answer: Objects are instances of classes.  Classes can be thought of as a blueprint for an object.  We write these blueprints and then instantiate objects from it.  Can then call methods on these objects to solve problems  

> It could be helpful to draw a picture here. Maybe a `Person` class, and then people objects such as Keith, Zsolt, etc.

## The 4 Pillars of OO

> We haven't mentioned the "Four Pillars of OO" to students until this point. A good idea might be to ask the "What is X?" questions and then explain that these four topics have a name.

### What is Abstraction?

Abstraction works in several ways. The most common way you will have seen is something you do every day: abstracting code into objects. These objects give us a simplified interface to deal with so that, for example, we don't need to be thinking about how `Integer`s are saved to the hardware while trying to write an online shopping basket. All we need to know is that there's an `Integer` class that deals with numbers in common ways.

Another form of abstraction is generalising the shape of a collection of classes behind an interface.

These sorts of abstractions help us keep our code SOLID. In particular, it makes it much easier to see where you might be breaking the Single Responsibility Principle.

### What is Encapsulation?

Encapsulation is where an object manages its own private state. For example, a Java `Diary` class might keep an array of `DiaryEntry` objects, but only expose a public `getLastEntry()` method. In this case, the array of entries is said to be 'encapsulated' in the `Diary`.

### What is Inheritance?

Inheritance is when an object adopts behaviours from a "parent class" or "superclass." Examples of this include custom activities in Android, which extend the system-provided `Activity` class.

It should be noted that inheritance can be overused. If there is a bug in a class, it could either be in that class, or any one of its (potentially numerous) superclasses. This is why you might sometimes hear people talking about favouring composition over inheritance. This means we define a class' behaviour by delegating them out to other objects. (See, e.g., the Strategy pattern).


### What is Polymorphism?

Polymorphism is the ability to use the same 'interface' with objects of different types. A good example is Java's `ArrayList` type - it has two methods `remove(int index)` and `remove(Object object)` which perform similar jobs, but depending on the type they receive (i.e., an `int` or some `Object` subclass) work in slightly different ways. This is known as "ad hoc polymorphism."

The `ArrayList` type itself is actually polymorphic in a slightly different way. Whether we have an `ArrayList<String>` or an `ArrayList<Integer>` we still talk to the list itself in the exact same way. This is formally known as "parametric polymorphism" (i.e., it is polymorphic over some type parameter).

Finally, subclassing an existing class is a type of polymorphism. If we have a class `Dog` that inherits from `Mammal` that inherits from `LivingThing`, then a `Dog` can be used with methods that expect either of its superclasses without any issues. Though this of course assumes that we've followed the Liskov substitution principle.

#### Why is this important?

Two reasons. The first is that writing code that works with lots of different types with minimal changes can help keep things DRY. The second is that it can reduce coupling. Coupling is when two unrelated pieces of code become linked in ways they shouldn't be. Reducing coupling helps obey the open-closed principle.

## What is the difference between an abstract class and an interface?

It comes down to two simple things: first off, a class can adopt many interfaces, but have only one superclass (abstract or concrete); secondly, interfaces cannot contain state.

Prior to Java 8 interfaces also couldn't contain default method implementations, meaning they were literally just a description of how a class might look. However, interfaces can now contain default implementations for methods they declare.
