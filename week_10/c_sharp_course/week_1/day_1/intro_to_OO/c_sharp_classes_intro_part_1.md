# OO Intro - Part 1

### Learning Objectives
1. Understand the basic idea of Object Orientation
2. Create a class
3. Create an instance of a class
4. Understand the difference between a class and an object
4. Add properties to class
5. Add methods to class
6. Understand the difference between a function and a method
7. Understand getters
8. Understand setters
9. Explain how OO Encapsulates our program.

# Intro

Now that we've covered the C# basics we can now start looking at object-oriented programming. So what exactly is object oriented programming?

**Fundamentally, object-oriented programming sees the world as data, modelled in code by "objects."** Coupled together with their behaviour - methods.

**In OOP, the programmer focuses on designing 'classes'** that define the properties and behaviours of 'objects' that will be instantiated from our classes.

> Draw a house being cobbled together from lots of components

## Function recap

We can write functions to achieve the behaviour we desire. Passing in the data we want to be updated and getting the function to return the result we want back.
> TODO: find way to show this, perhaps using another language (e.g. C??)

Object orientated programming takes the step of grouping the behaviour and the data together in an object. This way, we can have nicely bundled pieces of related code that can be reused.

Often, we don't just want one object but many of that type.  Think about Strings, Arrays, Integers and in this case Bank Accounts. It is for this reason that when defining the behaviour, we don't do it for a single object,  but for a class of objects.

## Real world example - Person

This might sound a bit scary, but it's really not. Let's think about a real life example.

Here at CodeClan, we have many people. We all have different names, hair colour and favourite colours. However, we all have a name, we all have hair(at least most of us do :-) ) and we all have favourite colours. We know that a person has these traits, and that since we are all people we have our own instances of these things.

In C#, we could say that a Person is a class, a template, a blueprint and that John is an instance - he has specific implementations of the properties we know that a person has. I have brown hair, my name is John and my favourite colours are black and gold.

Similarly, we know that all people can walk, talk and sleep. We all do this, in our own way. I walk differently to Zsolt, he talks differently to Darren. But we all walk and talk because we are People.

We can also represent this in our code, by attaching "behaviours" to classes as well as properties. These are represented by functions, or "methods". More on this later.

## Object Orientated Code

Let's have a look at this in the context of a bank account example. To make a class, we need the "class" keyword in C#. This is going to be our template where we define the properties and behaviours that our bank account objects will have.

```zsh
#terminal

touch BankAccountTest.cs
```

```csharp
//BankAccountTest.cs
using System;
using NUnit.Framework;

namespace Bank
{
    [TestFixture]
    public class BankAccountTest
    {

      [Test]
      public void TestHasName()
      {
          
      }
    }
}
```

Now in  ```TestHasName()``` we want to create an instance of the BankAccount class we are going to create. We do this by using the ```new``` keyword followed by the class name i.e.

```csharp
new BankAccount();
```

But we also want to assign that new bank account to a variable. Remember that when we declare a variable in C# then we need to give it a type. So what type will use for the variable?

> give them a moment to have a think about this

We actually use the class as the type, because our account is an instance of a BankAccount i.e.:

```csharp
BankAccount account = new BankAccount();
```

So our test should now look something like:

```csharp
//BankAccountTest.cs
using System;
using NUnit.Framework;

namespace Bank
{
    [TestFixture]
    public class BankAccountTest
    {

      [Test]
      public void TestHasName()
      {
          BankAccount account = new BankAccount();
      }
    }
}
```


Cool, now we need to actually create a bank account class, so that we can create object instances of it.

```zsh
#terminal

touch BankAccount.cs
```

```csharp
//BankAccount.cs

namespace Bank {
  class BankAccount {

  }
}
```

We also need to create our Runner, so that we have a 'Main' function
```zsh
#terminal

touch Runner.cs
```

```csharp
//Runner.cs

namespace Bank {
  class Runner {
    public static void Main()
    {
    }
  }
}
```

To compile:
```zsh
#terminal

csc BankAccount.cs BankAccountTest.cs Runner.cs
```

```zsh
#terminal
nunit Program.exe
```

Our test isn't actually doing anything, but at least there are no errors.

We can see that we create an instance of an object, a concrete implementation, using the "new" keyword before the class name. This will make a lot more sense as we add properties to our bank account.

> Make sure everyone is on par here.

## Initializing state

The bank account object we created it was pretty empty. If you remember, our bank account needs a holder name, amount and a type.

We want to pass this to the object when we create it, since these are properties every bank account needs to have. It turns out that "new" is just a special function we can use to pass initial data to our object - defining the initial state that our object has.

```csharp
//BankAccountTest.cs

account = new BankAccount("John", 500, "business");
```

If we run this, we will see an error. We have not actually told our class to expect a name, value or type so it doesn't know what to do with it. Let's go add them.

All classes have a special function called a ***constructor*** that we can use to set the state of our object. This constructor has the same name as the class itself, which is confusing.  It is the code in this constructor function that is run when we call "new".

This is just the way C# handles initializing state, don't worry about it too much. All you need to remember is that when we use `new` it is the constructor method which is called. What we pass `new` and what we expect to get in the constructor must match up, just like with a normal function.

So let's create a constructor function in our BankAccount class:

```csharp
//BankAccount.cs

namespace Bank {
  class BankAccount {
    public BankAccount(string name, int amount, string type) {

    }

  }
}
```

The ```public``` keyword allows us to access this method from outside the class.

Cool, so now our test is passing. Note that we can replace the name, value and type of our object with anything we want. This is just one instance of a bank account.

> Do a quick demo of making another bank account then delete it.

However, we are not actually doing anything with the data. It is passed to the constructor, then is lost.

> Break here

## Initialize instance variables

Okay, so we probably want to be able to access our name, value and type after we have first initialized them. The value of the bank is likely to change a lot for sure, so we definitely need to be able to get to it and update it.

We call properties of a class which are available during the entire life of an object "instance variables". As long as our bank account exists in memory, these values will be stored and remembered. This is the object's state.

This is different to the "local" variables we saw before in functions, which live as the function executes then are lost.

Instance variables are declared at the top of the class, outside any methods. Just like local variables they have a type. So lets add instance variables for name, the amount, and the account type to our class:

```csharp
//BankAccount.cs
namespace Bank {
  class BankAccount {

    string name;  //ADDED
    int amount;   //ADDED
    string type;  //ADDED

    public BankAccount(string name, int amount, string type) {

    }
  }
}
```

We can now initialise these instance variables using the arguments passed to the constructor.

```csharp
//BankAccount.cs
namespace Bank {
  class BankAccount {

    string name;
    int amount;
    string type;

    public BankAccount(string name, int amount, string type) {
      this.name = name;
      this.amount = amount;
      this.type = type;
    }
  }
}
```

Note the use of the ```this``` keyword. This is used to show that the variable we want to initialize is the one which is the instance variable of the class, not the one passed as an argument to the constructor. When ```this``` is used it refers to the instance of the current instance of the class.

We now have successfully stored the data in the object. But how do we get it back out?

## Behaviour

While it's cool that we have state,  we can't easily get it from our object.  This is because in C# (as they should probably be in all languages),  instance variables are private - not accessible from outside the object.

### Instance variables are private

This brings us on to defining the behaviour of our object - ways which we can interact with it.  We do this by defining methods - these are functions which are attached to an object. We can call these methods using the . notation on the object.  From now on we'll be writing all of our functions in classes, allowing them to be methods on an object. Let's see an example to allow us to access the holder name of the account.

Why is this important? Well the properties we set on our object are "private". The outside world can't access them, only our object knows about them. This is important since we might use these properties to calculate things inside of our object or do interesting things, but we don't want people to be able to change them willy nilly.

Let's try and access our name of our account.

```csharp
//BankAccountTest.cs

[Test]
public void TestHasName()
{
    BankAccount account = new BankAccount("John",500, "business");
    Assert.AreEqual( "John", account.name ); //ADDED
}

```

When we try to compile this, we get an error. The outside world (us) has no access to this property of the object. It's locked away and guarded.





