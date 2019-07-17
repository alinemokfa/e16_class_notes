#  Types and Testing

## Learning Objectives
  - Exposure to numeric types and booleans.
  - Using JUnit to test.

## Before starting

> JUnit should be installed on CodeClan laptops at the Meet Your Cohort day. This should be verified by asking students to run `junit` in Terminal:

```bash
$ junit

JUnit version 4.12

Time: 0.003

OK (0 tests)
```

> If it hasn't installed for whatever reason, see [JUnit Installation Notes](junit_installation.md) for troubleshooting

## Testing with JUnit

We're going to start doing TDD just like we used to in Ruby. This will help us practice our new language and see how we can do the same thing we used to do, but in a Java friendly way.

We're going to write some tests for our Bear class, and the convention is to name the test file the class name plus 'Test', so in this case BearTest.

```
#terminal
touch BearTest.java
```

We need to import both the junit testing package and also the AssertEquals function. The classes we want to test also need to be available to this file - in this case we'll have all the files in the same directory so we don't need to do anything, but when we come to packaging up our classes we need to make sure they're imported.

```java
//BearTest.java

  import static org.junit.Assert.assertEquals;
  import org.junit.Test;

```

We then declare a class called BearTest (same as the file name).

Each test should be started by writing '@Test'. (This tells JUnit to run the following function as a test, so if any exceptions are thrown the test fails - this is a Java annotation, which can be used for a range of things, not just testing).

We then write a function which returns void and has a name descriptive of what is being tested.

```
#terminal
touch BearTest.java
```

```java
//BearTest.java

  import static org.junit.Assert.assertEquals;
  import org.junit.Test;

  public class BearTest{
    @Test
    public void hasName(){
      Bear bear = new Bear("Baloo");
      assertEquals( "Baloo", bear.getName() );
    }
  }
```

Here we have used assertEquals, which compares an expected value with the result of something, in this case the bear's name with the result of the getName() function.

```
[SHOULD ALREADY HAVE THIS FROM PREVIOUS LESSON]

#terminal
touch Bear.java
```


```java
//Bear.java

  class Bear{
    private String name;

    public Bear(String name){
      this.name = name;
    }
    public String getName(){
      return this.name;
    }
  }
```

## Running Tests with Junit CLI

We can run these tests from the terminal using the junit command. Remember to compile the test files as well as your normal classes!

```
#terminal

javac *.java
junit BearTest
```

## int

Java gives us the 'int' type to handle integer values.  Let's give the bear an age. We'll follow TDD and write the test first.

```java
//BearTest.java

public class BearTest{
  @Test
  public void hasName(){
    Bear bear = new Bear("Baloo");
    assertEquals( "Baloo", bear.getName() );
  }

  @Test
  public void hasAge(){
    Bear bear = new Bear("Baloo", 25);
    assertEquals( 25, bear.getAge() );
  }
}
```

Solution:

```java
//Bear.java

  class Bear{
    private String name;
    private int age;

    public Bear(String name, int age){
      this.name = name;
      this.age = age;
    }
    public String getName(){
      return this.name;
    }
    public int getAge(){
      return this.age;
    }
  }
```

But wait! Our program won't compile now because we are creating a new Bear in our first test with just a name. Let's alter our first test to pass in an age argument too.

```java
//BearTest.java

@Test
public void hasName(){
  Bear bear = new Bear("Baloo", 25);
  assertEquals( "Baloo", bear.getName() );
}

```

> inevitably someone will ask why String is a capital and int is lowercase. This is going to be covered in the (quick) reference types lesson coming up next!

If you need a bigger number than int can hold, you can use long.

## double(float)

For non-integer numbers Java gives us the double type.  Double stands for double precision float.  They can contain twice the amount of data as a float.  This allows for doubles to store larger numbers to more decimal points.

When we're testing for a double, we should always include a third parameter in the assert for a delta, which is a range that the expected value can be lower or higher by. E.g. if we said 1.5, 0.01, it could be between 1.49 and 1.51.

> Remember the delta for the double test!

```java
//BearTest.java

public class BearTest{
  //AS BEFORE
  @Test
  public void hasWeight(){
    Bear bear = new Bear("Baloo", 25, 95.62);
    assertEquals( 95.62, bear.getWeight(), 0.01 );
  }
}
```

You might have noticed we're being a bit repetitive by creating a new bear at the start of each test. To save doing this we can add in a setup step using @Before. This signals to JUnit a piece of code to run before each test is run.

> when setting this up go over scope of class vs functions.

Now we can write the code to pass the Weight test.

```java
//BearTest.java
// Change import org.junit.Test to be org.junit.*

public class BearTest{
    Bear bear;

    @Before
    public void before(){
      bear = new Bear("Baloo", 25, 95.62);
    }

   //remove Bear setup from each test
  }
}

```

Solution

```java
//Bear.java

  class Bear{
    private String name;
    private int age;
    private double weight;

    public Bear(String name, int age, double weight){
      this.name = name;
      this.age = age;
      this.weight = weight;
    }
    public String getName(){
      return this.name;
    }
    public int getAge(){
      return this.age;
    }
    public double getWeight(){
      return this.weight;
    }
  }
```

## boolean
Java gives us a boolean type to handle truthiness.

> Unlike Ruby and Javascript where every object has a truthy or falsey value, Java is more uptight. If evaluating the truthiness of something it needs to be a conditional statement or a boolean object.

Create a readyToHibernate method based on weight. Let's do the tests together:

```java
//BearTest.java

public class BearTest{
  //AS BEFORE
  @Test
  public void readyToHibernateIfGreaterThan80(){
    assertEquals( true, bear.readyToHibernate() );
  }
  @Test
  public void notReadyToHibernateIfLessThan80(){
    Bear thinBear = new Bear("Baloo", 25, 65.44);
    assertEquals( false, thinBear.readyToHibernate() );
  }
}
```

[Task:] Go write the code to pass it.

Solution:

```java
//Bear.java

class Bear{
  private String name;
  private int age;
  private double weight;

  public Bear(String name, int age, double weight){
    this.name = name;
    this.age = age;
    this.weight = weight;
  }
  public String getName(){
    return this.name;
  }
  public int getAge(){
    return this.age;
  }
  public double getWeight(){
    return this.weight;
  }
  public boolean readyToHibernate(){
    return this.weight >= 80.00;
  }
}
```

## char
The char type is used to store a single character. we use the SINGLE quotes to defined the value.

```java
char gender = 'f';
```

Optional: Add a height (double) property.
Add a BMI method (divide weight in kilograms (kg) by height in metres (m) then divide the answer by height again).  
Change readyToHibernate so it's based on BMI > 30

## Quiz

Select all statements where the declaration type does not match the value.

```java

char gender = 'G';
boolean fact = true;
boolean number = 17;
String name = "Yogi";
double price = 17.89;
long total = 100.1;
```

### Solution
number and total are wrong.
