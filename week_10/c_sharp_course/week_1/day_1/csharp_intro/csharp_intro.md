# C# Introduction

### Objectives

By the end of the lesson, students will be able to:

* compile and run a simple "Hello World" program in C#

### Duration

30 mins

# Intro

C# is an object-oriented programming language which was created by Microsoft for its .NET platform. The team which created C# was led by Anders Hejlsberg. C# is based on the programming languages C and C++, and also has features which are similar to those in Java (which is also based on C and C++) so if you have any experience of using these languages then a lot of the C# syntax should be familiar.

## Compiling C#

Normally C# code is compiled and run from within VisualStudio, Microsoft's development environment, but rather than having you try to learn both the development environment and the language at the same time, this week we are just going to concentrate on learning OO programming using C#, so we are going to compile and run our code from the command line.

___BUT___ remember that C# is Microsoft's language, and it is designed to run on Windows, not on MacOS,  so how do we compile and run our programs on our Macs? Luckily for us, a company called Xamarin (which is now incidentally owned by Microsoft) has a tool called [Mono](http://www.mono-project.com/) which allows us to build/compile C# code on a Mac.

## Creating our first C# Program 
So let's create our first C# program, the famous "Hello World" program:

```zsh
#terminal

touch HelloWorld.cs
```

> Mention that the ```.cs``` suffix is used to tell us that it is a C# source file.

```csharp
//HelloWorld.cs
using System;

namespace MyFirstCSharpProgram {
    class Program
    {
        static void Main()
        {
            Console.WriteLine("Hello World");
        }
    }
}
```

So let's have a closer look at this code to see what it's doing?

```csharp
using System;
```

The ```using``` keyword says that we are using features from the ```System``` namespace. Namespaces are C# program elements which are used to help us organise our programs. We can group bits of related code in different files into the same namespace. The ```System``` namespace is already provided for us as part of the tools.

```csharp
namespace MyFirstCSharpProgram {
}
```

Here we are creating our own namespace ```MyFirstCSharpProgram``` and placing all our code within that namespace. 

> perhaps mention that namespaces are used to avoid name clashing

```csharp
class Program {

}
```

In C# everything is written inside a class (we'll go more into classes later) so we need to create a class so that we have somewhere to put all our code. A class can contain lots of things, variables, properties and methods, all of which we will cover later. All you need to know at the moment is that our ```Program``` class has only one method, called ```Main```:

```csharp
static void Main() {

}
```

Let's go through this line.  The first word is ```static```. The static keyword tells us we should be able to access this method without having to create an instance of our ```Program``` class(again more on this later) 

The next keyword is ```void```, and tells us what this method should return, or what we should be getting back from the method when we call it. For instance, it could be an integer or a string of text, but in this case, we don't want our method to return anything, or void, which is the same as no type. 

The next word is Main, which is simply the name of our method. This method is the so-called entry-point of our application, that is, the first piece of code to be executed. Every program needs to have a method called ```Main``` somewhere as the operating system looks for it when running the program.

```csharp
Console.WriteLine("Hello World");
```

This is the line which simply prints out "Hello World" to the screen. It calls a method called ```WriteLine``` which is a method supplied to us in the ```Console``` class which is part of the ```System``` namespace we said we are using at the top of the file.

> reiterate that we will cover all this again.

Now let's compile our code. To do this we call the ```csc``` program (short for C Sharp Compiler) and pass it our ```HelloWorld.cs``` source file.

```zsh
#terminal

csc HelloWorld.cs
```

Note: ```csc``` is actually an alias to the command ```mcs -reference:nunit.framework.dll -out:Program.exe```

If you do an ```ls``` in your directory then you should see a file called ```Program.exe```. This is the executable produced. The ```.exe``` suffix shows that the file is an executable file so we should be able to just run that file by simply typing the filename at the command line. ___BUT___ the ```.exe``` says that it's a .NET executable file, which we can't directly run on a Mac. To run our program we need to use another program from 'Mono', ironically called ```mono``` and use that to run our program:

```zsh
#terminal

mono Program.exe
```

What do you see? You have just compiled and run your first C# program.

> show that changing the code does not automatically change the output when you run it - the code needs to be re-compiled
> perhaps talk about how C# is a compiled language and maybe show how compiler can generate error messages