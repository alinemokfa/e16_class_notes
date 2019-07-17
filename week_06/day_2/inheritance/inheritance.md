# Inheritance

## Learning objectives

- Understand how inheritance works in Java

# Intro

When we were learning Ruby, we saw how useful it was to gather classes together when they share properties or functionality. We used *inheritance* to describe the relationship between superclasses and subclasses.

> Scan the room for blank expressions. Have a quick recap of inheritance in Ruby if necessary.

```
class Vehicle
  ...
  def start_engine
    "Vrmmmm!"
  end
end

class Car < Vehicle

end
```

The same concept exists in Java, and although the syntax is a little different, the idea is much the same. We can use the 'extends' keyword to use inheritance.

```
class Vehicle {
  int numWheels = 4;
}

public class Car extends Vehicle {
  public int getNumWheels(){
    return this.numWheels;
  }
}
```

We can see from the example above that the Car class has inherited the numWheels property from the parent vehicle class. If we want, we can *override* the property's value with something new.

```
class Vehicle {
  int numWheels = 4;
}

public class Motorbike extends Vehicle {
  public Motorbike(){
    numWheels = 2;
  }
}
```

Note that we have to override the instance variable in the constructor.

We can override methods to do something specific for that class:

```
class Vehicle {
  public String startEngine(){
    return "Vrrrm!";
  }
}

public class Car extends Vehicle {
  public String startEngine(){
    return "Vrrrm! I'm a car!";
  }
}
```

## Super!

Just as in Ruby, we can use the `super` keyword to trigger functionality from the parent class. We can refactor the code above to be more DRY.

```
class Vehicle {
  public String startEngine(){
    return "Vrrrm!";
  }
}

public class Car extends Vehicle {
  public String startEngine(){
    return super.startEngine() + " I'm a car!"
  }
}
```

When the `super()` method is called on its own, it will call the parent class' constructor.

```
class Vehicle {
  int numWheels;

  public Vehicle(int numWheels){
    this.numWheels = numWheels;
  }
}

class Car extends Vehicle {
  public Car(int numWheels){
    super(numWheels);
  }
}
```

In this example, when we instantiate a new car, we will pass an integer parameter to the parent vehicle class:

```Car fiesta = new Car(4);```

## Types of inheritance

So far, we have been using single inheritance, where our Car class inherits from a single parent, Vehicle. We can also create an *inheritance chain*, where a class inherits from more than one layer of parent classes. For example:

```
class Vehicle {

}

class Car extends Vehicle {

}

class ElectricCar extends Car {

}
```

However, we can never inherit directly from more than one parent class. This would be illegal:

```
class ElectricCar extends Car, Vehicle {

}
```

## Task (Optional) - 20 minutes

Create your own inheritance chain for modelling various types of animal.

- Your base class should be Animal, and should have methods for `eat()` and `breathe()`.
- Create a subclass of Animal called Mammal. Mammals should have a `brushHair()` method.
- Create two further subclasses of Mammal: Human and Chimpanzee. They should have a `speak()` method.

Make each method return a suitable string. Check that you can create a human and a chimpanzee object, and make sure that they can each eat, breathe, brush their hair, and speak.
