# C# Functions

## Learning Objectives
 * Learn about C# functions

### Intro

## What is a function?

A 'function' is a reusable chunk of code that can be called (invoked) by name to perform a specific task. We can think of it as a little machine that takes in some information and returns something.

## Why Do We Use Functions?

* It's much easier to find and fix bugs if you've organised your program well.
* Separation of concerns makes our code less redundant
* We can 'abstract' our programs into individual parts.
* We can 'encapsulate' data so that no other part of the program can interfere with it

### Defining a Function
Here is the general form of a function definition in C#:

```
return_type function_name( parameter list ) {
   body of the function
}
```

A function definition in C# programming consists of a function header and a function body. Here are all the parts of a function:

#### Return Type
A function may return a value. The return_type is the data type of the value the function returns. Some functions perform the desired operations without returning a value. In this case, the return_type is the keyword ```void```.

#### Function Name
This is the actual name of the function. The function name and the parameter list together constitute the function signature.

#### Parameter List
A parameter is like a placeholder. When a function is called, you pass a value to the parameter. This value is referred to as actual parameter or argument. The parameter list refers to the type, order, and number of the parameters of a function. Parameters are optional; that is, a function may contain no parameters.

#### Function Body
The function body contains a collection of statements that define what the function does. The code in the function body is contained within a set of curly braces ({}). The section of code within the braces is known as a code block. You can have nested code blocks within a function.

## Scope

A function has it's own internal world and doesn't share it's variables that another function has. We call this little world the _scope_ of the function.

So here is a simple function which returns the highest of two numbers:

```csharp

static int Max (int firstNum, int secondNum)
{
  if (secondNum > firstNum)
  {
    return secondNum;
  }
  return firstNum;
}
```

To use this in a program we would have something like:

```csharp
using System;

namespace Functions {
    class Program
    {
        static int Max (int firstNum, int secondNum)
        {
          if (secondNum > firstNum)
          {
            return secondNum;
          }
          return firstNum;
        }

        static void Main()
        {
            int result = Max(1, 2); 
            Console.WriteLine("Max(1,2) returns " + result);
        }
    }
}
```

When we call/invoke the function 

## Passing variables to functions

We can give functions the information they need using arguments which we pass into the function.  The behaviour of our function will now depend on what we pass in.  This is a very powerful concept.

When we define what we need in our functions world, we call these _parameters_. When we provide what a function has asked for, we call these _arguments_.

We will see lots more examples of functions as we go along.