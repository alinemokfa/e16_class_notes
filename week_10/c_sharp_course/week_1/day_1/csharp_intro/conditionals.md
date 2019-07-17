# C# Control Flow

## Learning Objectives
- Demonstrate using:
  - if statement
  - else
  - else if
  - switch
  - ternary

# Control Flow

Sometimes we need to make decision in our code, there are language constructs allowing us to do this.

## IF statements

```csharp

int counter = 0;

if (counter == 0) {
  Console.WriteLine("The counter is 0");
}
```

```csharp
using System;

namespace Conditionals {
    class Program
    {
        static void Main()
        {
          int counter = 0;

          if (counter == 0) {
            Console.WriteLine("The counter is 0");
          }
        }
    }
}
```


Note the '==' for checking the condition. A ___single___ = is for __assignment___.

We can add an else condition:

```csharp
int counter = 1;

if (counter > 0) 
{
  Console.WriteLine("The counter is greater than 0");
} 
else 
{
  Console.WriteLine("The counter is less than or equal to 0");
}
```

```csharp
using System;

namespace Conditionals {
    class Program
    {
        static void Main()
        {
          int counter = 1;

          if (counter > 0) 
          {
            Console.WriteLine("The counter is greater than 0");
          } 
          else 
          {
            Console.WriteLine("The counter is less than or equal to 0");
          }
        }
    }
}


```

Then there is the dreaded ```else if```.

```csharp
int counter = -1;

if (counter > 0)
{
  Console.WriteLine("The counter is greater than 0");
} 
else if (counter < 0) 
{
  Console.WriteLine("The counter is less than 0");
} 
else 
{
  Console.WriteLine("The counter is 0");
}
```

This quickly gets unwieldy and leads us nicely onto switch statements.

## Switch Statement

Switch statements can be used when we have multiple decisions to make in our code.

```csharp
using System;

namespace Conditionals {
    class Program
    {
        static void Main()
        {
            int score = 10;

            switch (score)
            { 
              case 10:
                Console.WriteLine("Genius");
                break;
              case 9:
                Console.WriteLine("Merit");
                break;
              case 8:
                Console.WriteLine("Pass");
                break;
              default:
                Console.WriteLine("Fail");
                break;
            }
        }
    }
}

```

## Ternary Operator

We can also use a construct called a ternary. It's really nice when you only have a simple choice to make that only have 2 outcomes.

```csharp
1 + 1 == 2 ? "yay, maths!" : "noes, maths is broken.";
```

You can see it takes three arguments, hence why it's ternary. The first is the condition to check, the second (after the ? ) is the action to take when true the third (after the :) is the action to take if false.

> if students are struggling with this it might be worth pointing out that this is the same as writing an if...else statement.

```csharp
using System;

namespace Conditionals {
    class Program
    {
        static void Main()
        {
            string result = 1 + 1 == 2 ? "yay, maths!" : "noes, maths is broken.";
            Console.WriteLine(result);
        }
    }
}
```

## One last thing...

Sometimes we want to check if one or more conditons are true. To do this we need to use something special.

```csharp

using System;

namespace Conditionals {
    class Program
    {
        static void Main()
        {
          bool isTired = true;
          bool isHungry = true;

          if (isTired && isHungry)
          {
            Console.WriteLine("Hangry!");
          }
          isTired = false;

          if (isTired || isHungry)
          {
            Console.WriteLine("Grumpy!");
          }

        }
    }
}


```

We use `&&` for AND and `||` for OR.
