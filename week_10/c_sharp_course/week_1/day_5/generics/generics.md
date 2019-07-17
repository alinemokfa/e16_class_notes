# Generics

## Learning Objectives
  * Understand C# Generics
  * Create a simple generic class

## Intro

So far, when we've been writing classes, we've given the class members/instance variables specific types e.g.

```csharp

class Account {
  private int id;
  private string name;

  public int Id
  {
      get { return this.id; }
  }

  public string Name
  {
      get { return this.name; }
      set { this.name = value; }
  }

  public Account(int id, string name)
  {
    this.id = id;
    this.name = name
  }

}

```

So in this example we are saying that the account id is always an integer and that the name is always a string. But what if we wanted to use a string for the account id? We'd need to create another class which is basically the same, but with different types. 

This is where generics come in. Generics allow us to create classes or methods that can work with any data type. They let us define classes with placeholders for the type of its fields, methods, parameters etc. At compile time, these placeholders are replaced with some specific type.

A generic class can be defined using angle brackets <>. So lets go back and refactor our account class:

```csharp

 class Account<T> {
   private T id;
   private string name;

   public T Id
   {
       get { return this.id; }
   }

   public string Name
   {
       get { return this.name; }
       set { this.name = value; }
   }

   public Account(T id, string name)
   {
     this.id = id;
     this.name = name;
   }

 }
```


When we create an instance of our class, we also need to put the type we are using inside the angle brackets e.g.

```csharp
Account<int> account1 = new Account<int>(1234, "Jack Jarvis");
Account<string> account2 = new Account<string>("CC99XX", "Victor McDade");
```

> perhaps mention that they have seen this before with Lists


```csharp

using System;

namespace GenericsExample {
  class Account<T> {
    private T id;
    private string name;

    public T Id
    {
        get { return this.id; }
    }

    public string Name
    {
        get { return this.name; }
        set { this.name = value; }
    }

    public Account(T id, string name)
    {
      this.id = id;
      this.name = name;
    }

    public string ToString()
    {
      return this.id +"(" + typeof(T).ToString() + ") : " + this.name;
    }

  }

  class Program
  {
      static void Main()
      {
          Account<int> account1 = new Account<int>(1234, "Jack Jarvis");
          Account<string> account2 = new Account<string>("CC99XX", "Victor McDade");
          Console.WriteLine(account1.ToString());
          Console.WriteLine(account2.ToString()); 
      }
  }
}
```
