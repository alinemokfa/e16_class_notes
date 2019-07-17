# A World Without Polymorphism

### Learning Objectives

- Understand method overloading
- Understand the need for polymorphism

## Intro

Let's extend our library so it contains not just books, but also is going to let people borrow computer game software. 

Our Game is going to be a bit boring and can do nothing but be borrowed.

```bash
# terminal

touch Game.cs
```

```csharp
//Game.cs 

public class Game {

  public string Borrow()
  {
    return "being borrowed";
  }
}
```

## Method overloading

Now, we have a bit of a problem. Our items list can only hold Books, and we want it to include Games. Also, our add method can only take a Book.

> Task:  Have a go at finding a solution to the problem.

Cool, so let's have a look at a really crude solution to this problem.

```csharp
//LibraryTest.cs

using System;
using NUnit.Framework;

namespace Library
{
    [TestFixture]
    public class LibraryTest
    {
        Library library;
        Book book;
        Game game; //ADDED

        [SetUp]
        public void Init()
        {
            library = new Library("CC Library", 10);
            book = new Book();
            game = new Game(); //ADDED
        }

        [Test]
        public void TestHasName()
        {
            Assert.AreEqual( "CC Library", library.Name );
        }

        [Test]
        public void TestHasCapacity()
        {
            Assert.AreEqual(10, library.Capacity);
        }

        [Test]
        public void TestLibraryStartsEmpty()
        {
            Assert.AreEqual(0, library.ItemCount());
        }

        [Test]
        public void TestCanAddBookToLibrary()
        {
            library.AddItem(book);
            Assert.AreEqual(1, library.ItemCount());
        }

        [Test] //ADDED
        public void TestCanAddGameToLibrary()
        {
            library.AddItem(game);
            Assert.AreEqual(1, library.ItemCount());
        }

        [Test]
        public void TestCanEmptyShelves()
        {
          library.AddItem(book);
          library.ClearShelves();
          Assert.AreEqual(0, library.ItemCount());
        }
    }
}
```

So we currently have a compiler error, since we can't pass a Game type to a method which is expecting a Book. The easiest way to fix this is `method overloading`. This is where we can define a method with the same name, but different parameters.

```csharp
//Library.cs

public void AddItem(Game game)
{
  this.items.Add(game);
}
```

We have a new problem, since our items list only accepts Books! The easiest way to fix this is to declare a new List to hold games and to change our old List's name to reflect that it is, indeed, an items list for Games.

We'll have to change all our references to items to bookItems in order for it to compile.

```csharp
//Library.cs

namespace Library {
  class Library {
    private string name;
    private int capacity;
    private List<Book> bookItems; //UPDATED
    private List<Game> gameItems; //ADDED

    public string Name
    {
        get { return this.name; }
        set { this.name = value; }
    }
    
    public int Capacity
    {
        get { return this.capacity; }
        set { this.capacity = value; }
    }

    public Library (string name, int capacity)
    {
      this.name = name;
      this.capacity = capacity;
      this.bookItems = new List<Book>(); //UPDATED
      this.gameItems = new List<Game>(); //ADDED
    }

    public int ItemCount()
    {
      return this.items.Count;
    }

    public void AddItem(Book book)
    {
      this.bookItems.Add(book);
    }

    public void AddItem(Game game)
    {
      this.gameItems.Add(game);
    }

    public void ClearShelves()
    {
      this.bookItems.Clear(); //UPDATED
    }
  }
}
```


In order to make all our test pass, we have to change our itemCount method, so it adds up the amount of items in the bookItems list and the gameItems list.

```csharp
public int itemCount(){
  return this.bookItems.Count + this.gameItems.Count; //UPDATE
}
```

Now our test should pass. If we slightly modify our test for emptying the shelves, we have a wee problem to fix.

```csharp
//LibraryTest.cs

[Test]
public void TestCanEmptyShelves()
{
  library.AddItem(book);
  library.AddItem(game);
  library.ClearShelves();
  Assert.AreEqual(0, library.ItemCount());
}
```

The items list still has 1 item in it! Let's go fix this.
Lastly, we need to fix the EmptyShelves method.

```csharp
//Library.cs

public void ClearShelves()
{
  this.bookItems.Clear();
  this.gameItems.Clear();
}
```

Now our tests should pass. Phew! That was a LOT of work.

## It's a bit stinky

So this has indeed solved our problem. But now we have 2 separate collections for different types. What happens if we decide to add Magazines to our library, or newspapers, or CDs/DVDs?? Are we going to make new collections and new method overloads every time?

Luckily, there is a better way. Polymorphism to the rescue!!
