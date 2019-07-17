# Array Lists

### Learning Objectives
- Know what an List is
- Understand the difference between a List and a basic array
- Be able to create Lists, and add and remove items from them

## Intro

We've look at basic arrays and let's be honest, they were a lot of work. 

Lists are much more similar to what we have seen before, complete with methods to help us out. They do have their own little quirks though, as always.

Let's rework our Library class and bask in the glory of Lists.

## Declaring an List

First we need to tell our code that we want to use this class. Remember how in our "HelloWorld" program we had ```using System;``` at the top. Well, we also want to use a class called Lists which is in the ```System.Collections.Generic``` namespace so we include it with:

```csharp
//Library.cs

using System.Collections.Generic; //ADDED AT TOP OF FILE
```

We can now update all of our code to use this shiny new collection.

When we declare a List, we have to tell it what kind of things our list will hold, just like when we declared an Array. We do this by saying what will be in the list within angle brackets (< >). We want our List of itmes to contain instances of our ```Book``` class so we would declare it with something like:

```csharp
List<Book> items;
```

```csharp
//Library.cs

using System.Collections.Generic;

namespace Library {
  class Library {
    private string name;
    private int capacity;
    private List<Book> items; //MODIFIED

    ...
    
    public Library (string name, int capacity)
    {
      this.name = name;
      this.capacity = capacity;
      this.items = new List<Book>(); //MODIFIED
    }

    ...
}
```

Notice we don't need to give it a size anymore. Which is good news for our library, since we can now add as many books as we want.

## Helpful methods

We now have to use a 'Count' property instead of 'Length' which is super useful:

```csharp
//Library.cs

public int ItemCount()
{
  return this.items.Count;
}
```

Our AddItem and ClearShelves methods are about to much nicer.

```csharp
//Library.cs

public void AddItem(Book book)
{
  this.items.Add(book);
}

public void ClearShelves()
{
  this.items.Clear();
}
```

Isn't it wonderful?? There are lots of other methods like `remove` you will find in the documentation which are worth having a little look at.

All of our unit tests should still pass, but we can remove the test for the shelves being full since it's not an issue anymore.

```csharp
//Library.cs

//DELETE
public bool ShelvesFull()
{
  return this.ItemCount() == this.items.Length;
}
```

```csharp
//LibraryTest.cs

//DELETE
[Test]
public void TestCannotAddBookWhenFull()
{
  for (int i = 0; i < 20; i++)
  {
    library.AddItem(book);;
  }
  Assert.AreEqual(10, library.ItemCount());

[Test]
public void TestLibraryFull()
{
  for (int i = 0; i < library.Capacity; i++)
  {
    library.AddItem(book);
  }
  Assert.AreEqual(true, library.ShelvesFull());
}

```