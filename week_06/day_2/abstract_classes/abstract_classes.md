# Abstract Classes

## Objectives

- Understand what an abstract class is
- Understand the template method


## Intro

We can make a class abstract by using the 'abstract' keyword.

This means that we can't "new" up that class when it isn't appropriate. A "bear" can never have an instance, it has to be either a Polar Bear or a Grizzly Bear. Bears don't exist as a "thing" in the wild per se.

Abstract classes actually are a bit more powerful than that.

A class that is declared with the abstract keyword is known as an abstract class in Java. It can have abstract and non-abstract methods.

(Abstract methods have no body - non-abstract methods do.)

Before learning Java abstract classes, let's understand abstraction in Java first.

## Abstraction in Java

Abstraction is a process of hiding the implementation details and showing only functionality to the user.

Another way, it shows only important things to the user and hides the internal details for example sending sms, you just type the text and send the message. You don't know the internal processing about the message delivery.

As another example, when we use a web browser, we don't really care how it deals with HTTP requests and responses. We just care that the browser does actually do it. The processes it uses are **abstracted** away from the user.

So in Java, Abstraction lets you focus on what the object does instead of how it does it.

It is worth noting that Abstraction and Encapsulation are similar.  In simple words: You do abstraction when deciding what to implement. You do encapsulation when hiding something that you have implemented.

## Ways to achieve Abstraction

There are two ways to achieve abstraction in java

- Abstract class (0 to 100% abstraction)
- Interface (100% abstraction) - More on this later.

[i:] Give out the starter code and let the students read it for 2 minutes

### Inheritance recap

Lets make another class for a Grizzly Bear.

```java
public class Grizzlybear  {

  public String gatherFood(){
    return "Fishing in the river.";
  }

}

```

What if we wanted some default text to be displayed as well...?

We would have to implement the default text method in each class. We don't want to repeat code so lets change this to include a bear class and have Grizzly and Polar bears inherit from this.

```java
#Bear.java
public class Bear {
  public String gatherFood() {
  return "Gathering food,";
  }
}


#GrizzlyBear.java

public class GrizzlyBear extends Bear {

  public String gatherFood() {
    return super.gatherFood() + " fishing in the river";
  }

}


#PolarBear.java

public class PolarBear extends Bear {

  public String gatherFood() {
    return super.gatherFood() + " breaking the ice";
  }

}

#BearTest
import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BearTest {

 PolarBear bear1;
 GrizzlyBear bear2;

 @Before
 public void before() {
   bear1 = new PolarBear();
   bear2 = new GrizzlyBear();
 }

 @Test
 public void polarCanGather(){
  assertEquals("Gathering food, breaking the ice", bear1.gatherFood());
}
 @Test
 public void grizzlyCanGather(){
  assertEquals("Gathering food, fishing in the river", bear2.gatherFood());
 }

}


```

Ok, all good. Both Polar and Grizzly bears can inherit and call the gatherFood method from the super class. But wait.... we can create a new instance of Bear class. What?? We have no clue what type of bear that this is. Is it a polar bear? Is it a grizzly bear? Is it Yogi Bear?? We simply don't know.

So we want to have the ability to implement common code with sub classes and make sure that we can't instantiate the bear class.

Abstract classes are the answer.

## Abstract classes

Now it turns out that abstract classes can achieve the same thing.

We can declare methods that sub classes have to implement by declaring the methods as abstract too.

Let's do a little refactor.

```java
#Bear.java
public abstract class Bear {  //As before

  public abstract String hibernate(); //NEW
}

#PolarBear.java
public class PolarBear extends Bear {

  public String gatherFood() {
  return super.gatherFood + " breaking the ice";
  }

  public String Hibernate() {
  return "Finding a nice Igloo to sleep";
  }
}

#Grizzlybear.java
public class GrizzlyBear extends Bear {

  public String gatherFood() {
  return super().gatherFood + " fishing in the river";
  }

  public String Hibernate() {
  return "Finding a nice cave to sleep";
  }
}


#BearTest.java
public class BearTest {

//same as before

@Test //NEW
public void canHibernate() {
  assertEquals("Finding a nice Igloo to sleep", bear1.hibernate());
  assertEquals("Finding a nice cave to sleep", bear2.hibernate());
}
```

This will work in exactly the same way as before. If we comment out the code in PolarBear, we get a compiler error just like what happened with the interface.

Abstract methods have no method body. The method must be defined in the subclass, just like an interface.

## How is this useful?

We now can do something like this...

```java
#Bear.java
public String roar(){
  return "roar!";
}

#BearTest.java
@Test
public void canRoar(){
  assertEquals("roar!", bear1.roar());
  assertEquals("roar!", bear2.roar());
}

```

For free, our PolarBear and any other bear subclass can now roar. We can always override this behaviour too if we want to.

All the normal "benefits" of inheritance still apply. We can share properties across all of our objects, e.g. number of legs or eyes, stuff that every bear has. We can't do any of this with an interface.

## Disadvantages

There is a problem however. We are still constrained by the same problems as inheritance. We can only have one superclass, and all the methods on that class bleed down to all of our children whether we want them or not. This is where Interfaces play an important part and we will look at those tomorrow.

## In Summary

- Abstract classes may or may not contain abstract methods, i.e., methods without body ( public void get(); )

- But, if a class has at least one abstract method, then the class must be declared abstract.

- If a class is declared abstract, it cannot be instantiated.

- To use an abstract class, you have to inherit it from another class, provide implementations to the abstract methods in it.

- If you inherit an abstract class, you have to provide implementations to all the abstract methods in it.
