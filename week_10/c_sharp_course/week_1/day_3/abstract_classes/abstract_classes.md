# Abstract Classes

## Objectives

- Understand what an abstract class is.

## Intro

Sometimes we might want to have a class where we just want to use it as a 'superclass', but not create an actual instance of it, as it's not really appropriate. One example of this is the 'Vehicle' class we created when we talked about inheritance. We are using the 'Vehicle' class as a 'superclass' but do we really want to create an instance of 'Vehicle'? Probably not.

This is where the idea of an abstract class comes in.  

### Making a class abstract
To make a class abstract we simply use the ```abstract``` keyword in our class declaration i.e.:

```csharp
//Vehicle.cs

abstract class Vehicle { //MODIFIED
  //same as before
}
```

If we try and compile all our code now, then we will get a compilation error in VehicleTest.cs as we now cannot create an instance of 'Vehicle'. But we can compile and run our code as long as we no longer include VehicleTest.cs on our compiler command line:

```bash
#terminal

csc Main.cs Car.cs CarTest.cs Motorbike.cs MotorbikeTest.cs Vehicle.cs
```

> we can delete the VehicleTest.cs file as we will no longer be running it.

But there is more to abstract classes than just simply being classes we cannot instantiate.

## Abstract methods

As well as a class being abstract, also methods can be abstract. Abstract methods have no method body. The method must be defined in the subclass.

For example, let's add an abstract method 'Drive' to our Vehicle class:

```csharp
//Vehicle.cs

abstract class Vehicle {

  // same as before

  public abstract string Drive();
}
```

Note that this method does not contain any body. What were are basically saying is that any class which inherits from Vehicle must implement a 'Drive' method which returns a string. It doesn't matter what the method does inside the method but it must be called Drive, take no arguments and return a string. 

If we were to try an compile our code now we will get an error saying that the subclasses of Vehicle do not implement the Drive method. So lets's go and fix this now:

```csharp
//TestMotorbike.cs

[Test]//ADDED
public void TestMotorbikeCanDrive()
{
    Assert.AreEqual("use handlebars", motorbike.Drive());
}
```

```csharp
//Motorbike.cs
public override string Drive()//ADDED
{
  return "use handlebars";
}
```

```csharp
//TestCar.cs

[Test]//ADDED
public void TestCarCanDrive()
{
    Assert.AreEqual("use steering wheel", car.Drive());
}
```

```csharp
//Car.cs
public override string Drive()//ADDED
{
  return "use steering wheel";
}
```

Note that we have to use the ```override``` keyword to tell the compiler that we are overidding the abstract method in the superclass. If not, then we will get a compiler error.

## Non-abstract methods

However, abstract classes can still contain implementations. So we can leave our 'StartEngine' method as it is.

For free, our Car and Motorbike can use this StartEngine method. We can always override this behaviour too if we want to (like we do in the Motorbike class)

All the normal "benefits" of inheritance still apply. We can share properties across all of our objects, e.g. number of legs or eyes, stuff that every bear has. We can't do any of this with an interface.

## Disadvantages

There is a problem however. We are still constrained by the same problems as inheritance. We can only have one superclass, and all the methods on that class bleed down to all of our children whether we want them or not.

> ## Task
> * Create a simple bank example where 'Account' is an abstract class which has two subclasses, 'Savings Account' and 'Current Account'


