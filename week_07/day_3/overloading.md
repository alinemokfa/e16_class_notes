# Method Overloading

## Objectives
- Recap method overloading from last week
- Show overloading of constructors

## Method Overloading

Last week we saw how we can 'overload' methods. This is where we declare more than one method with the same name in the same class, with each having different parameters.

There are two ways to overload a method:
- By changing the arguments type.
- By changing the number of arguments

But why would we do this, rather than just having different method names for each different version of the method?

Suppose we wanted to do the same operation, but with different numbers of arguments, or with arguments of different types. Using different method names for each can get messy and confusing. If the methods basically do the same thing, then they should have the same name (remember about making method names meaningful).

> hand out starter code

> just talk through this showing how confusing things can get

```java
//MethodOverloadingExample.java
 //adding different number of ints

public String addTwoInts(int number1, int number2) {
  int result = number1 + number2;
  return "Result of adding 2 ints is " + result;
}

public String addThreeInts(int number1, int number2, int number3) {
  int result = number1 + number2 + number3;
  return "Result of adding 3 ints is " + result;
}

public String addFourInts(int number1, int number2, int number3, int number4) {
  int result = number1 + number2 + number3 + number4;
  return "Result of adding 4 ints is " + result;
}

```

Or
```java
//MethodOverloadingExample.java
//subtracting different types

public String subtractDoubleFromDouble(double number1, double number2) {
  double result = number1 - number2;
  return "Subtracting double from double. Result is " + result;
}

public String subtractIntFromDouble(double number1, int number2) {
  double result = number1 - number2;
  return "Subtracting int from double. Result is " + result;
}

public String subtractDoubleFromInt(int number1, double number2) {
  double result = number1 - number2;
  return "Subtracting double from int. Result is " + result;
}
```

## Changing the argument's type

> Student's have already seen this last week.

In the 'subtract<TYPE>From<TYPE>' example above, we can simply change the name to all of these methods to be the same e.g.`subtract`

```java
//MethodOverloadingExample.java
//subtracting different types

public String subtract(double number1, double number2) { //MODIFIED
  double result = number1 - number2;
  return "Subtracting double from double. Result is " + result;
}

public String subtract(double number1, int number2) { //MODIFIED
  double result = number1 - number2;
  return "Subtracting int from double. Result is " + result;
}

public String subtract(int number1, double number2) { //MODIFIED
  double result = number1 - number2;
  return "Subtracting double from int. Result is " + result;
}
```

We now need to change our tests to call the overloaded `subtract` method in each case:

```java
//MethodOverloadingExampleTest.java

@Test
    public void subtractDoubleFromDouble() {
        String result = testClass.subtract(2.5, 1.2); //MODIFIED
        assertEquals("Subtracting double from double. Result is 1.3", result);
    }

    @Test
    public void subtractIntFromDouble() {
        String result = testClass.subtract(4.5, 2); //MODIFIED
        assertEquals("Subtracting int from double. Result is 2.5", result);
    }

    @Test
    public void subtractDoubleFromInt() {
        String result = testClass.subtract(5, 1.2); //MODIFIED
        assertEquals("Subtracting double from int. Result is 3.8", result);
    }

```

Our tests should all still pass.

##Changing the number of arguments

In the 'add<NUMBER>Ints' example above, we can simply change the name to all of these methods to be the same e.g.`add`

```java
//MethodOverloadingExample.java
//adding different number of ints
 public String add(int number1, int number2) {  //MODIFIED
    int result = number1 + number2 + number3 + number4;
    return "Result of adding 2 ints is " + result;
  }

  public String add(int number1, int number2, int number3) {  //MODIFIED
    int result = number1 + number2 + number3;
    return "Result of adding 3 ints is " + result;
  }

  public String add(int number1, int number2, int number3, int number4) {  //MODIFIED
    int result = number1 + number2 + number3 + number4;
    return "Result of adding 4 ints is " + result;
  }

  // and so on
```

And again we also need to modify our tests so that they all call the `add` method:

```java
//MethodOverloadingExampleTest.java

@Test
public void addingTwoInts() {
    String result = testClass.add(1, 2);
    assertEquals("Result of adding 2 ints is 3", result);
}

@Test
public void addingThreeInts() {
    String result = testClass.add(1, 2, 3);
    assertEquals("Result of adding 3 ints is 6", result);
}

@Test
public void addingFourInts() {
    String result = testClass.add(1, 2, 3, 4);
    assertEquals("Result of adding 4 ints is 10", result);
}
```

Our tests should all still pass.

## Changing the return type

NOTE that changing the return type of the method does ***NOT*** overload the method, as this still can result in ambiguity. For example:

```java
public int add(int number1, int number2) {
  return number1 + number2;
}
```

Cannot be overloaded by simply changing the return type to e.g. `double`:

```java
public double add(int number, int number 2) {
  return number1 + number2;
}
```

This will result in a compiler error:

```console
Error:(37, 16) error: method add(int,int) is already defined in class MethodOverloadingExample
```

This is because the compiler will look for a method `add` which takes two `int``s as arguments. In this case there are two, so the compiler does not know which one to use as the return type is not taken into consideration when looking for which method to call.

> perhaps show this in the IDE

## Constructor Overloading

Just as we can overload methods, we can also overload constructors. If we have a class with more than one instance variable e.g.:

```java
//ConstructorOverloadingExample.java
public class Student {
  private int id;
  private String name;
  private int age;
}

```

Then we can have a constructor where we can initialise all of the instance variables:

```java
//ConstructorOverloadingExample.java
public class Student {
  private int id;
  private String name;
  private int age;

  public Student(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }
}

```

And to use it to create a `Student`:

```java
  Student student = new Student(1, "Wilma", 21);
```

But we also might want to just create an instance of a `Student` without initializing any of the instance variables as we might just want an 'empty' `Student` where all the instance variable are set to `null`:

```java
//ConstructorOverloadingExample.java

public class Student {
  private int id;
  private String name;
  private int age;

  public Student(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public Student() {

  }
}

```

And to test it:

```java
import static org.junit.Assert.*; //MODIFIED


  @Test //ADDED TESt
  public void testEmptyStudent() {
      Student student = new Student();
      assertEquals(0,student.getId());
      assertNull(student.getName());
      assertEquals(0,student.getAge());
  }
```

Just as with method overloading when we call the constructor there has to be a version where the argument(s) match in type ***AND*** number. For instance, using the above example, the following would result in a compiler error because there is no matching constructor:

```java

  Student student = new Student("Jane");
```

> TASK: Create an version of the constructor(with test) to get this to work

> SOLUTION:
```java
//StudentTest.java

@Test
public void testStudentHasNameOnly() {
    Student student = new Student("Jane");
    assertEquals(0,student.getId());
    assertEquals("Jane", student.getName());
    assertEquals(0,student.getAge());
}
```

```java
//Student.java

public Student(String name) {
  this.name = name;
}

```

## Recap

When we have methods which do the same thing but have different numbers and or types of parameters then, as long as they all return the same type we can call these methods by the same name, using method overloading.

We can also overload constructors, as they are basically methods, giving different argument types/numbers.