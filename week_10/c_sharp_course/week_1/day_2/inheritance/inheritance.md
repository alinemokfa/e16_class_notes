# Inheritance

## Learning Objectives

- Be able to describe inheritance
- Implement superclass and subclass
- Know how to override methods
- Sharing a constructor

Sometimes we might have a bunch of classes that all share some behaviour. For example, a sparrow can fly, but so can a crow.

A car has wheels, but so does a motorbike - they also both help you travel somewhere, and both have an engine that can start.

How can we represent this in our code?

> perhaps draw each class on the board as we go along

```bash
#terminal

touch Car.cs Motorbike.cs CarTest.cs MotorbikeTest.cs Main.cs

subl .
```

```csharp
//CarTest.cs

using System;
using NUnit.Framework;

[TestFixture]
public class CarTest
{
  Car car;

  [SetUp]
  public void Init()
  {
      car = new Car();
  }

  [Test]
  public void TestCarCanStartEngine()
  {
      Assert.AreEqual("Vrrmmm", car.StartEngine());
  }
}
```

```csharp
//Car.cs

class Car {
  public string StartEngine()
  {
    return ("Vrrmmm");
  }
}
```

```csharp
//Main.cs

  class Runner {
    public static void Main()
    {
    }
  }
```

Now if we want to make a motorbike that also starts its engine what do we do? The simplest solution is that we can copy and paste the code.

```csharp
//MotorbikeTest.cs

using System;
using NUnit.Framework;

[TestFixture]
public class MotorbikeTest
{
  Motorbike motorbike;

  [SetUp]
  public void Init()
  {
      motorbike = new Motorbike();
  }

  [Test]
  public void TestMotorbikeCanStartEngine()
  {
      Assert.AreEqual("Vrrmmm", motorbike.StartEngine());
  }
}
```

```csharp
//Motorbike.cs

class Motorbike {
  public string StartEngine()
  {
    return ("Vrrmmm");
  }
}

```

This is dirty. We want to be able to reuse our code.

If we want to change this method then we need to alter it in two places. Isn't that a pain? Wouldn't it be great if we just needed to change it in one place. After all, the code is the same in both places. This is where inheritance comes in. 

> perhaps draw diagram on board Animals -> Birds and Mammals etc.

The class which passes stuff down to another class is called a 'super class' i.e. NOT 'Super' class.

We can move this to a "super class" where the behaviour can be shared among the two "sub classes".

```bash
# terminal

touch Vehicle.cs VehicleTest.cs
```

```csharp
//VehicleTest.cs

using System;
using NUnit.Framework;

[TestFixture]
public class VehicleTest
{
  Vehicle vehicle;

  [SetUp]
  public void Init()
  {
      vehicle = new Vehicle();
  }

  [Test]
  public void TestVehicleCanStartEngine()
  {
      Assert.AreEqual("Vrrmmm", vehicle.StartEngine());
  }
}
```

```csharp
//Vehicle.cs

class Vehicle {
  public string StartEngine()
  {
    return ("Vrrmmm");
  }
}
```


We now need to tell our 'Car' and 'Motorbike' classes that they are subclasses of 'Vehicle':

```csharp
//Motorbike.cs

class Car : Vehicle {

}
```

```csharp
//Motorbike.cs

class Motorbike : Vehicle {

}
```

Our tests still pass. This is as if the two classes are joined together - the behaviour is passed down to the subclass. This is called "inheriting" properties or behaviours.

> check class on par here

## Overriding

But what if we wanted our motorbike to still be able to start it's engine, but do something different from its parent?

We can 'override' the method in the superclass by declaring a method of the same name in the subclass
and then giving that method the specific behaviour.

We call a method in a class, Ruby first looks to the class, and then the super class.

> perhaps another diagram, or explain on the board. 

Let's change the motorbike so it has specific behaviour.

```csharp
//MotorbikeTest.cs

[Test]
public void TestMotorbikeCanStartEngine()
{
    Assert.AreEqual("Vrrmmm (I'm a motorbike), HELL YEAH!", motorbike.StartEngine()); //MODIFIED
}

```

```csharp
//Motorbike.cs

class Motorbike : Vehicle {
  public string StartEngine()
  {
    return ("Vrrmmm (I'm a motorbike), HELL YEAH!");
  }
}

```

##`super`
What if wanted our motorbike to do something unique and to also do its parent behaviour.  Enter `base`.
`base` followed by the method name, calls its parent (base/super) class method.

> give example where super class method does whole load of stuff and we want to do the same stuff in the overridden method. 

```csharp
//Motorbike.cs

class Motorbike : Vehicle {
  public string StartEngine()
  {
    string vehicleStart = base.StartEngine();
    return (vehicleStart + " (I'm a motorbike), HELL YEAH!");
  }
}
```

So here, inside the StartEngine() method in the Motorbike class, we first call the StartEngine() in the base/super class (i.e. the version in Vehicle), then get the result and do something with it.

## Shared Constructor

Note that if we add an instance variable and a constructor to Vehicle, all of the derived classes share them.

```csharp
//Vehicle.cs

class Vehicle {

  private int numberOfWheels;

  public int NumberOfWheels
  {
    get { return this.numberOfWheels; }
    set { this.numberOfWheels = value; }
  }

  public Vehicle()
  {
    this.numberOfWheels = 4;
  }
  //same as before
}
```

```csharp
//VehicleTest.cs

[Test]
public void TestVehicleHasNumberOfWheels()
{
    Assert.AreEqual(4, vehicle.NumberOfWheels);
}
```

```csharp
//CarTest.cs

[Test]
public void TestCarHasNumberOfWheels()
{
    Assert.AreEqual(4, car.NumberOfWheels);
}
```

If we added a parameter to the constructor, all of our vehicle classes would have to use it.

```csharp
//Vehicle.cs

public Vehicle(int numberOfWheels)
{
  this.numberOfWheels = numberOfWheels;
}
```

```csharp
//VehicleTest.cs

[SetUp]
public void Init()
{
    vehicle = new Vehicle(4); //MODIFIED
}
```


Now if we want to set one of our subclasses to have that property as a constant value, e.g. so we don't have to keep on passing in that a car has four wheels, we can call base() on the constructor method and pass in the value.

```csharp
//Car.cs

class Car : Vehicle {
  public Car() : base(4)
  {
    
  }
}
```

> Task: Do the same for our motorbike so it always has two wheels.

```csharp
//MotorbikeTest.cs

[Test]
public void TestMotorbikeHasNumberOfWheels()
{
    Assert.AreEqual(2, motorbike.NumberOfWheels);
}

```

```csharp
//Motorbike.cs

class Motorbike : Vehicle {
  public Motorbike() : base(2)
  {
    
  }

  // SAME AS BEFORE
}
```

If we want to also pass additional parameters to the constructor, we can do this - we can override the constructor and also call the superclass constructor to set the wheels.

> perhaps describe example where the superclass has lots of properties, but we're only adding one new property in the subclass.

So let's add another instance variable to our Car class, which is not in the superclass:

```csharp
//CarTest.cs

[SetUp]
public void Init()
{
    car = new Car("Ferrari"); //MODIFIED
}

[Test] //ADDED
public void TestCarHasModel()
{
  Assert.AreEqual("Ferrari", car.Model);
}

```

```csharp
//Car.cs

class Car : Vehicle {
  private string model;

  public string Model
  {
    get { return this.model; }
    set { this.model = value; }
  }

  public Car(string model) : base(4)
  {
    this.model = model;
  }
}
```

# Finally..

This inheritance stuff seems pretty useful. However if we use it too much it can sometimes be limiting, or make us write our code in a convoluted way. For example, imagine we want to make a Bicycle class. Surely this should inherit from Vehicle - it does transport people around, and it does have wheels. However it doesn't have an engine, so inheriting a start_engine method is a bit of a problem.. what are some solutions?

- Overwrite the StartEngine to just return 'I don't have an engine'
- Remove StartEngine from vehicle and put it back on Car and Motorbike
- Add another layer of inheritance to have 'EnginedVehicles' and 'HumanPoweredVehicles'

... all of these are a bit nasty. This is where we come onto composition as an alternative way of structuring our programs.
