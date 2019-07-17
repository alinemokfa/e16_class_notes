# Generics

## Learning Objectives

  * Know what generics are
  * Understand when we would use generics
  * Be able to make a simple generic class

## Intro

Because Java is a statically typed language, when creating a new class, we have to specify the types of its properties. But what if we want to instantiate that class, with a property of a different type? We could create a whole new class, with a property of that different type, but that wouldn't be very dry. Generics are a solution to this problem.

## Generics in Lists

The List interface in Java makes use of generics. We can create lists containing any type of object and the list's use of generics allow us to specify the type when we instantiate it.

ArrayLists implements the List interface, so everytime we create a new ArrayList of objects, we are making use of the generics.

```java
ArrayList<Account> accounts = new ArrayList<Accounts>();
```

If we go to the Java docs for the ArrayList it says:
`Class ArrayList<E>` 

The `<E>` (also often written as `<T>`) tells us we can pass in the type when we instantiate it.
`https://docs.oracle.com/javase/7/docs/api/java/util/List.html`


## Creating a non-generic Java class

So far, when we've been writing classes, we've given the class members/instance variables specific types e.g.

```java

class Account {
  private int id;
  private String name;

  public Account(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

}

```

So in this example we are saying that the account id is always an integer and that the name is always a string. But what if we wanted to use a string for the account id? We'd need to create another class which is basically the same, but with different types. 

## Creating a generic class

This is where generics come in. Generics allow us to create classes or methods that can work with any data type. They let us define classes with placeholders for the type of its fields, methods, parameters etc. At compile time, these placeholders are replaced with some specific type.

A generic class can be defined using angle brackets <>. So lets go back and refactor our account class:

```java

class Account<T> {
  private T id;
  private String name;

  public Account(T id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public T getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

}
```


You will see that when we declare a generic class then it looks very similar to when we declare a regular class, except that the class name is followed by a type parameter section.

Just as methods can have more than one parameter, the type parameter section of a generic class can have one or more type parameters separated by commas. 

These classes are known as parameterized classes or parameterized types because they accept one or more parameters.

## Instantiating a generic class

When we create an instance of our class, we also need to put the type we are using inside the angle brackets.

> Note that the type is an object (e.g. `Integer` rather than `int`) just like when we stored a value in a HashMap

Let's do that in our AccountTest class:

```java

public class AccountTest {

    Account<Integer> account1;
    Account<String> account2;

    @Before
    public void before() {
        account1 = new Account<Integer>(1234, "Jennifer Saunders");
        account2 = new Account<String>("CC99XX", "Joanna Lumley");
    }

    @Test
    public void testGetIdInteger() {
        Integer id = 1234;
        assertEquals(id, account1.getId());
    }

    @Test
    public void testGetIdString() {
        String id = "CC99XX";
        assertEquals(id, account2.getId());
    }


}

```

## Benefits of generics

By using generics we can make our classes more flexible. They enable us to specify types at the point of instantiation.
