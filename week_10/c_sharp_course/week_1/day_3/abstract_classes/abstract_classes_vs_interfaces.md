# Abstract Classes

## Objectives

- Understand what an abstract class is
- Understand the template method
- Understand the difference between an abstract class and an interface

## Intro

We've seen that we can make a class abstract by using the 'abstract' keyword. This meant that we could not "new" up that class when it wasn't appropriate. A "bear" can never have an instance, it has to be either a Polar Bear or a Grizzly Bear. Bear's don't exist as a "thing" in the wild per say.


## Interfaces recap

Often in interviews you will be asked to explain the difference between an abstract class and an interface.

Interfaces:

- Allow a class to gain the interfaces type as their own

Our PolarBear is both a PolarBear and a Gatherer if we have a look in the unit test

- Define a set of methods that **must** be implemented on the class extending it. 

This way we can guarantee that methods will be present when we are coding to an interface and not a concrete type. 

If we use a Gatherer as a type in a method and call gatherFood(), we can guarantee that any class implementing it will have this method present. It may not do anything, but it will be there.

If we comment out the gatherFood() method in polar bear and recompile, we should get an error.

## Abstract classes

Now it turns out abstract classes can achieve the same thing using abstract methods.

We saw that abstract methods have no method body. The method must be defined in the subclass, just like an interface.

## Differences

However, abstract classes can still contain implementations. As we saw with our 'StartEngine' method

For free, our Car and any other Vehicl subclass can now start their engine. We can always override this behaviour too if we want to. 

All the normal "benefits" of inheritance still apply. We can share properties across all of our objects, e.g. number of legs or eyes, stuff that every bear has. We can't do any of this with an interface.

## Disadvantages

There is a problem however. We are still constrained by the same problems as inheritance. We can only have one superclass, and all the methods on that class bleed down to all of our children whether we want them or not.

## In Summary

If you ever get asked the difference in an interview...

Abstract classes:

- Subclass can have only ONE superclass
- Can contain properties
- Can contain default implementations
- Can define abstract methods which must be implemented on subclass
- Give the superclass type to the subclass

Interfaces:

- Implementing class can have MANY interfaces
- Cannot contain properties
- Cannot contain default implementations
- Defines method signatures which must be implemented on class using it
- Gives the implementing class the interface type



