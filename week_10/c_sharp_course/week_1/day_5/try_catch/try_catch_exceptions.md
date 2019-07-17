# try-catch & Exceptions

## Learning Objectives

- Know what Exceptions are used for
- Understand when to throw your own Exceptions
- Be able to write and handle Exceptions

## Intro

What is an Exception? An Exception is a problem that we hit when running a program. In C#, an exception is a response to an exceptional circumstance that arises while a program is running.

> Show example

```csharp
//DivideByZeroException.cs

using System;

namespace DivideByZeroException {
    class Program
    {
        static void Main()
        {
          int one = 1;
          int zero = 0;
          Console.WriteLine(one / zero);
        }
    }
}
```

Running this code will result in a DivideByZeroException and the program will crash. This is an exception thrown by the system.

A list of most the common exception types can be found [here](https://blogs.msdn.microsoft.com/brada/2005/03/27/common-exception-types/)

Wouldn't it be nice to be able to handle this exception without the program crashing. This is where ```try...catch``` comes in.

## try block

If we have a piece of code where we think an exception could arise then we enclose it within a ```try``` block. It's almost as if we are saying `try running this code and see if it works`:

```csharp
//DivideByZeroExceptionCaught.cs

using System;

namespace DivideByZeroException {
    class Program
    {
        static void Main()
        {
          try {
            int one = 1;
            int zero = 0;
            Console.WriteLine(one / zero);
          }
        }
    }
}
```

If we were to compile this we would get an error. If an exception arises then we talk about the exception being 'thrown'. If we think an exception is going to be thrown, then we need to write code to handle it. We need to 'catch' the exception in order to deal with it

## Catching exceptions

When we want to catch an exception we create a ```catch``` block. This block takes an argument which is the type of exception to be caught, in our case a ```DivideByZeroException```

```
try {
  //code which may throw an exception
}
catch (<EXCEPTION TO BE CAUGHT>)
{
  //code to run when exception is caught
}


```

```csharp
//DivideByZeroExceptionCaught.cs

using System;

namespace DivideByZeroException {
    class Program
    {
        static void Main()
        {
          try {
            int one = 1;
            int zero = 0;
            Console.WriteLine(one / zero);
          }
          catch (System.DivideByZeroException ex)  //ADDED
          {
            Console.WriteLine("ERROR!: " + ex.Message);
          }
        }
    }
}
```

In our example the code in our catch block would only be run if the code in our try block throws a DivideByZeroException. If another type of exception was thrown then this would not be caught and the program would crash when running.

However, you can add multiple ```catch``` blocks, each for a different type of exception i.e:

```csharp
try
{
   // statements causing exception
}
catch( ExceptionName e1 )
{
   // error handling code
}
catch( ExceptionName e2 )
{
   // error handling code
}
catch( ExceptionName eN )
{
   // error handling code
}
 ```



## Creating custom exceptions

When we write C# classes that other developers are going to use, we might want to throw our own exceptions, to let them know when they're using our code incorrectly.

[i]: Give out start code

We've got a pet shop that stores Pet objects, Dogs, Cats or Fish, and can find them by looping through it's stock of Pets trying to find a Pet with a matching name.

What happens when we give our .FindPetByName method a null instead of "Meowingtons"?

If you change this search term to null and run the code, you should get a `NullReferenceException`.

This is a bit rubbish - it doesn't really give us enough information about what's gone wrong. 

> Ask students to take 10 minutes to think about how we could avoid this issue.

### Creating a custom Exception

`NullReferenceException` is pretty common, we're going to give more information about why our code might be failing, by instead throwing our own Exception, first we have to create it.

Create a new file called NullStringException.cs.

```csharp
// NullStringException.cs

using System;

public class NullStringException : Exception
{
  public NullStringException(string message) : base(message)
  {
  }
}
```


Our new Exception inherits from C#'s Exception class, which makes it able to behave like the C# Exceptions we've seen thrown by the language itself.

The constructor calls the superclass' constructor to create an exception with a given string as its "message".

Now we've got an exception, we can "throw" it using the throw keyword, and we'll do this in our `FindPetByName` method at the point where we know we can't complete the search we're trying to do. i.e. if it's given a null as its search String.

```csharp
// PetShop.cs

public Pet FindPetByName(string searchName){
  // NEW
  if (searchName == null) 
  {
    throw new NullStringException("Cannot search for a pet with null instead of a name string");
  }

  // SAME BELOW
}

```

Now let's try to compile our code with our new Exception being thrown.

We should get a compiler error, saying we must "declare" or "catch" our Exception before we're even allowed to throw it!

### catching our Exception

Our code still shouldn't compile. We've declared the Exception might be thrown, but we've still not caught it.

We do this using try-catch blocks.

We put our try-catch block where we call the method, not where the method is defined.

So in our ExampleTryCatch.java file, where we call our findPetByName function, we wrap that function call in a "try" block.

``` csharp
// ExampleTryCatch.cs

public class ExampleTryCatch {
  PetShop shop;

  public void run(){
    setup();

    try{ // NEW
      shop.findPetByName(null);
      System.Console.WriteLine("Found pet: " + found.GetName());
    }
  }
}
```

We also have to catch the Exception if it is thrown, we do this in a catch block, immediately following our try block.

catch blocks follow try blocks, kind of like else blocks follow if blocks.

```csharp
//ExampleTryCatch.cs

  try 
  {
    Pet found = shop.FindPetByName(null);
    System.Console.WriteLine("Found pet: " + found.GetName());
  }
  catch (NullStringException ex) {
    Console.WriteLine(ex.ToString());
    Console.WriteLine("Exception Message:");
    Console.WriteLine(ex.Message);
  }
// SAME BELOW
```

We can do whatever we like in our catch block, and we have access to the Exception object that was thrown, by convention I've named it `ex`.

Because our Exception class extends the official C# language's `Exception` class, we have access to some methods from that superclass. ex.ToString() is one of them, this will make your exception's output in the console look more familiar, printing every point where your exception was thrown traced back through the execution of the code.

We can print out whatever we like however.

### finally blocks

We use try blocks to wrap things that may fail to execute properly, and may throw exceptions.

Some common examples of things that may throw exceptions are things like accessing a remote server to get data, or accessing our database.

If a problem occurs when accessing our database, our program will thrown an exception and just crash. If that connection with the database is still open, we might be blocking other people from using the database. In a big program / database, this is really not good.

We can use the "finally" block to do things that we need to happen whether the code in our try block was successful, OR threw an exception. The "finally" code will always run either way. This is perfect for clearing up after ourselves, for example by closing any open database connections.

But like with catch blocks, we can do whatever we like in finally blocks, so I'm just going to log a message to the console so that we can see that it has run.

```csharp
//ExampleTryCatch.cs

  try 
  {
    Pet found = shop.FindPetByName(null);
    System.Console.WriteLine("Found pet: " + found.GetName());
  }
  catch (NullStringException ex) {
    Console.WriteLine(ex.ToString());
    Console.WriteLine("Exception Message:");
    Console.WriteLine(ex.Message);
  }
  // NEW
  finally
  {
    Console.WriteLine("and finally...");
    Console.WriteLine("I'm done.");
  }
```