# Variables and Types

### Objectives

By the end of the lesson, students will be able to:

* declare variables in C#
* declare variables of different types

### Duration

15 mins

## Variables

When we are writing programs we often want to store pieces of information that we may want to use later. 
For example, a student might have a locker where they can put stuff in at the start of the day, and then go and retrieve it later on. 

A variable is used to set-aside a place in memory (like assigning a locker) where we can place data we will want to use later. However, this data may not always be constant, hence the name e.g. I might have different things in my locker on different days i.e. it is changeable(mutable)

C# is what is known as a statically-typed language. This means than whenever we declare a variable then we need to say what type of data that variable holds and that, from then on, the variable can only hold data of that type. So for example, I might say that my locker can only hold books, but on Monday I put my C# books in the locker, but on Tuesday I might take them out and put my Java books in the locker. The content is the same ___type___ in both cases but is different.

###Defining Variables

## Types

```csharp
  int myInt = 1;

  float myFloat = 1f;
  double myDouble = 1.75;
  
  bool myBoolean = true;

  string myName = "John";
  
  char myChar = 'a';
  
```


### int
The ```int``` type is used to refer to whole numbers(integers) 

```csharp
  int age = 21;
```

### double(float)

For non-integer numbers C# gives us the ```double``` type. Double stands for double precision float. They can contain twice the amount of data as a float. This allows for doubles to store larger numbers to more decimal points.

```csharp
  float myFloat = 1f;
  double myDouble = 1.75;
```

> Note that defining a floating point number requires an explicit 'f' letter after the number.

### boolean

The ```boolean``` type is used to handle ```true``` or ```false``` values, often referred to as ___truthiness___ and ___falsiness___

```csharp
  bool myBoolean = true;
```

### string

To deal with pieces of text e.g. someone's name, then C# gives us the ```string``` type. When we assign a string literal to a string variable then place the text we want to use inside ***double*** quotes:

```csharp
  string myName = "John";
```

### char
C# lets us deal with single characters with the ```char``` data type. When assigning a single character to a variable we use ***single*** quotes. If we use double quotes then C# will treat it as a string which just happens to contain only one character. This is an important distinction to remember

```csharp
  char myChar = 'a';
```





