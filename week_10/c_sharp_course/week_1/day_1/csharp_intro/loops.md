# Loops

## Learning Objectives
- Write a for loop
- Use a while loop
- Break out of loops

## Intro

Loops are used to execute the same 'bit'/chunk of code a specified number of times. One of the principles of writing good code is Don't Repeat Yourself, or DRY. Writing loops is one way to help us write more DRY code. We have some options for looping in C#.

We're going to look at two types of loops: `while` and `for`. 

## Traditional For Loop

The traditional ```for``` loop uses a counter for it's exit condition.
This is seen in many programming languages

```csharp

for (int i = 0; i < 10; i++) {
  Console.WriteLine("i = " + i);
}
```

## While

A ```while``` loop executes code while a certain condition is true. Once the condition is not true the loop ends. 

```csharp
int i = 0;

while (i < 10) 
{
  Console.WriteLine("loop " + i);
  i = i + 1;
}
```
What would happen if we didn't increment the counter? The condition is always true... The code will loop forever, or eventually crash.

So beware of infinite loops.

We can use a special operator instead of x = x + 1

```csharp
x++;
```

## Exiting out of loops

What if we want to break out of a loop early. How do we do this.
```break``` - break out of loop totally

So for instance, if we want to loop asking the user for input for ever, *until* they type a particular character ('q'), we could use:

```csharp
using System;

namespace Loop {
    class Program
    {
        static void Main()
        {
            while (true)
            {
              Console.WriteLine("Type Something: ");
              string input = Console.ReadLine();
              if (input.ToLower().Equals("q"))
              {
                break;
              }
              Console.WriteLine("You typed: " + input);
            }
        }
    }
}
```

## Jumping to next iteration of a loop

If we are in a loop and for some reason we want to finish the current iteration of the loop and jump to the next iteration then we can use the ```continue``` keyword. We can modify the previous example so that if the user types 'skip', then then input is not displayed and the loop goes to the next iteration:

```csharp

namespace Loop {
    class Program
    {
        static void Main()
        {
            while (true)
            {
              Console.WriteLine("Type Something: ");
              string input = Console.ReadLine();
              if (input.ToLower().Equals("q"))
              {
                break;
              }
              if (input.ToLower().Equals("skip"))
              {
                continue;
              }
              Console.WriteLine("You typed: " + input);
            }
        }
    }
}
```