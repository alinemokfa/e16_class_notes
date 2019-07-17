# Lambda Expressions - Basics

## Learning Objectives
  * Understand the basics of Lambda expressions
  * Create a simple lambda expression

## Intro

The simplest way to describe a lambda expression is as a method that does not have a declaration i.e. it does ___not___ have an access modifier (public, private etc), a return value declaration, or a name.

In C#, lambda expressions are mostly used in connection with something called LINQ (Language Integrated Query). LINQ will be covered in a later .NET course.

We are only going to cover very simple lambda expressions here. 

The convenience of lambda expressions is that it is a shorthand which lets you write a method in the same place you are going to use it. 

This is especially useful in places where a method is being used only once, and the method definition is short. It saves you the effort of declaring and writing a separate method in the containing class..

## Defining a simple lambda expression

> give out 

Lets just say we have a List of numbers, and we want to create another List containing only the odd values in the list:

```csharp
List<int> numbers = new List<int>{5, 8, 11, 14, 18, 23, 29, 30, };
```

So we could create another list, and iterate over the original list adding any odd items to our new list:

```csharp
//LambdaExample.cs
using System;
using System.Collections.Generic;


namespace LambdaExample {
  class Program
  {
      static void Main()
      {
        List<int> numbers = new List<int>{5, 8, 11, 14, 18, 23, 29, 30, };
        List<int> oddNumbers = new List<int>();
        foreach (var num in numbers)
        {
          if ((num % 2) == 1)
          {
            oddNumbers.Add(num);
          }
        }
        foreach (var num in oddNumbers)
        {
          Console.WriteLine(num);
        }
      }
    }
}

```

We can do this a lot quicker using a lambda expression.

The lambda expression we are going to use looks like this:

```
n => n % 2 == 1 
```

Where:

  * n is the input parameter
  * n % 2 == 1 is the expression

You can read n => n % 2 == 1 as: "input parameter named n goes to anonymous function which returns true if the input is odd".

First of all, to use our lambda expression in our code we need to add the following at the top of the file:

```
using System.Linq;
```

This allows use to call a .Where method on our List. We then pass our Lambda expression as an argument to the Where method i.e.:

```csharp
List<int> oddNumbers = numbers.Where(n => n % 2 == 1).ToList();
```

> we need to get the results back as a List, hence the .ToList() at the end.

```csharp
//LambdaExample.cs

using System;
using System.Linq;
using System.Collections.Generic;

namespace LambdaExample {
    class Program
    {
        static void Main()
        {
          List<int> numbers = new List<int>{5, 8, 11, 14, 18, 23, 29, 30, };
          List<int> oddNumbers = numbers.Where(n => n % 2 == 1).ToList();

          foreach (var num in oddNumbers)
          {
            Console.WriteLine(num);
          }
        }
    }
}
```