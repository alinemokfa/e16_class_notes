# Introduction to Android

## Learning Objectives

* Know what Android Studio is
* Understand why we're looking at Android
* Understand the benefits of using an IDE
* Be able to write and unit test Java in Android Studio

## Intro

Last week we saw Java and were introduced to the world of statically typed languages.

We're going to continue our journey using a slightly different platform - Android.

Unlike MacOS or Windows, Android is an OS which specifically targets mobile devices.

Luckily, it's written in Java which we already know, but we have to get to grips with how we interact with a mobile device development platform.

One thing about Android is that it has excellent documentation. A good place to look for things is the [Android Developer site](http://developer.android.com/develop/index.html) but there's LOADS of stuff out there to help.

[i]: send students this [link](http://developer.android.com/develop/index.html)
Perhaps also mention the "Android Programming - The Big Nerd Ranch Guide" which we have.

## Why Android?

It's just Java - sometimes complicated Java, but everything we learned in Java is useful in Android.

The aim of this week is ***NOT*** to teach you to become Android developers in 4 days.  
It's just a chance to see one way that Java is used in the real world.

Learning the basics of Android lets us think about:

Working with a large pre-existing code-base
* we have to accept that we can't understand every part of the code, and just ensure we understand the parts we're working with at a given time.
* This is more like how development works on a real-world project, using, learning to understand, and adding to, other people's existing code.

Using an IDE
* We write Android apps in Android Studio, a lot of developers use IDEs like Android Studio to make their development quicker and easier.
* They offer a lot of features and functionality, but it can be a bit overwhelming to learn how to use them at first.
* If you use any IDE at your job, having seen one before will help you get to grips with a new one more easily.

***NOTE*** You will see some things you don't understand - don't worry. You're going to see things you're not expected to understand - just see that this is the way you have to do things in Android.

## Intro to the IDE

In this first lesson, we're ***NOT*** going to build an Android App. We're going to let you get a feel for using Android Studio as an IDE for writing and testing Java code.

The first thing we need to do is set up a 'Project' in Android Studio so that we can add our Java code and test it:

```
// setup

launchpad > android studio

Start a new android project

// application settings

Application name: TDDIntro
Company Domain: com.codeclan.example

Select the sdk version version 16 (Jelly Bean)
```

***NOTE*** you don't need to worry about the sdk version for now, we'll come back to it later when we come to actually building an Android App.

```
Click next

//Form factors

Don't change

// Activity

No activity > next

Click finish

```

This should set up a basic project so that we can now create a Java class and test it.

[i]: we'll describe the project layout in another lesson, when we come to do a full Android app.

## Our first Java class in Android Studio

So we are now ready to do some TDD in Android studio. We are going to create a class for a 'Robot' and use TDD to create some methods for that robot.

Our Robot will perform different household tasks, which will of course drain its battery! So we'd better be able to recharge the battery as well.

So the first thing we need to do is create the class for our Robot.

[i]: in this example, Our Package is called 'example.codeclan.com.tddintro'

```
Right click Java > <Our Package>  > New > Java Class
Name: Robot
```

This has created an empty class for us.

```
// Robot.java
public class Robot  {

}
```

So let's give Robot some attributes:

* name - ```String```
* battery percentage - ```double```
* colour - ```String```

```
// Robot.java
public class Robot  {
  private String name;
  private String colour;
  private double battery;
}
```

## Creating Unit Tests

Let's now write the test. We want to write a unit test for our model. We are not testing any android specific functionality so we have to change the view of the project.

```
Build variants (left hand tab) -> unit tests
```

So, first of all, we need to add a new class to run the tests.

[i]: in the later versions of Android the directory for unit tests appears in the project window in the java directory. It has the same name as the project package but with ```(test)``` in brackets afterwards. There is usually a file already there called something like ```ExampleUnitTest.java```.

```
Right click test package > new class > RobotTest
```

This gives us an empty class.

We could add Junit to the test class by importing on our own like following:

```
import org.junit.Test;
import static org.junit.Assert.*;
```

But Android Studio has a handy little feature that will add unambiguous imports for us. This will be useful later on when we start to work with different packages in the same project.

To enable this feature go to Android Studio menu > preferences.
In here Go to Editor > General > Auto Import and tick "Add unambiguous imports on the fly"

No when we start to add in anything that requires an import Android studio should add the import statement for us.
If it doesn't (for example in AssertEquals) you can add this by moving cursor to somewhere in the word and selecting `alt+return` then choose import static method and select org.jUnit from list.

So our class will look like:

```
//RobotTest.java

import org.junit.Test;
import static org.junit.Assert.*;

public class RobotTest {

}

```

So let's create our first test. Let's say we want to create a new Robot using it's name and colour and that it's battery life will be set to 100% by default.

```
//RobotTest.java

import org.junit.Test;
import static org.junit.Assert.*;

public class RobotTest {
  @Test
  public void testRobotSetUp() {
      Robot robot = new Robot("C3P0", "Gold");
      assertEquals("C3P0", robot.getName());
      assertEquals("Gold", robot.getColour());
  }
}

```

Of course, we haven't yet created the constructor for our Robot class so we will not be able to run/pass the test so let's do that now.

We will declare our Robot's attributes as ```private```
So we'll need to add getters for the name and colour,

```
// Robot.java
public class Robot  {
  private String name;
  private String colour;
  private double battery;

  public Robot(String name, String colour) {
    this.name = name;
    this.colour = colour;
    this.battery = 100.0;
  }

  public String getName() {
    return this.name;
  }

  public String getColour() {
      return this.colour;
  }
}
```

Right click on RobotTest and it will allow us to run it. It should pass.

### Task
Go and write tests for the rest of the methods in the ```Robot``` class, and them implement them:

* ```double checkBattery()```
  * returns percentage of battery life left
* ```String makeDrink (String drink)```
  * passes in the name of the drink being made e.g. tea
  * uses up 10% of the battery life
  * returns the string "I am making" + drink
* ```String washDishes()```
  * uses up 30% of battery life
  * returns the string "I am washing the dishes"
* ```String doDusting()```
  * uses up 20% of the battery life
  * returns the string "I am dusting"
* ```void rechargeBattery()```
  * resets battery to 100.0

[i]: remember the delta when comparing floating point numbers

***POSSIBLE*** solution:

```
//RobotTest.java

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class RobotTest {

    Robot robot;

    @Before
    public void before() {
      robot = new Robot("C3P0", "Gold");
    }

    @Test
    public void testRobotSetUp() {
        assertEquals("C3P0", robot.getName());
        assertEquals("Gold", robot.getColour());
    }

    @Test
    public void testCheckBattery() {
        double battery = robot.checkBattery();
        assertEquals(100.0, battery, 0.01);
    }

    @Test
    public void testMakeDrink() {
        String task = robot.makeDrink("coffee");
        double battery = robot.checkBattery();
        assertEquals(90.0, battery, 0.01);
        assertEquals("I am making coffee", task);
    }

    @Test
    public void testWashDishes() {
        String task = robot.washDishes();
        double battery = robot.checkBattery();
        assertEquals(70.0, battery, 0.01);
        assertEquals("I am washing the dishes", task);
    }

    @Test
    public void testDoDusting() {
        String task = robot.doDusting();
        double battery = robot.checkBattery();
        assertEquals(80.0, battery, 0.01);
        assertEquals("I am dusting", task);
    }

    @Test
    public void testRechargeBattery() {
        String task = robot.doDusting();
        double battery = robot.checkBattery();
        assertEquals(80.0, battery, 0.01);
        robot.rechargeBattery();
        battery = robot.checkBattery();
        assertEquals(100.0, battery, 0.01);
    }

}
```

```
//Robot.java

public class Robot {
    String name;
    double battery;
    String colour;

    public Robot(String name, String colour) {
        this.name = name;
        this.colour = colour;
        this.battery = 100.0;
    }

    public String getName() {
        return this.name;
    }

    public String getColour() {
        return this.colour;
    }

    public double checkBattery() {
        return this.battery;
    }

    String makeDrink(String drink) {
        this.battery -= 10.0;
        return "I am making " + drink;
    }

    String washDishes() {
        this.battery -= 30.0;
        return "I am washing the dishes";
    }

    String doDusting() {
        this.battery -= 20.0;
        return "I am dusting";
    }

    public void rechargeBattery() {
        this.battery = 100.0;
    }

}

```
