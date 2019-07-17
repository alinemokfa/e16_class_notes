 # Casting

### Learning Objectives

- Understand how to cast a variable

# Intro

Phew! We are nearly there on our magical journey through the lands of polymorphism, but we still have one thing to consider.

## Original Types

Let's imagine that our Library can now give us one of its items. We're not going to ask for a specific item as our librarian is a but grumpy and just gives us the first thing in the list

```csharp
//LibraryTest.cs

[Test]
public void TestCanGetItemFromLibrary()
{
  library.AddItem(book);
  ICanBorrow item = library.BorrowItem();
  Assert.IsNotNull(item);
}
```

```csharp
//Library.cs

public ICanBorrow BorrowItem()
{
  ICanBorrow item = this.items[0];
  this.items.RemoveAt(0);
  return item;
}
```

This is cool. But what if we did this?

```csharp
//LibraryTest.cs

[Test]
public void TestCanGetItemFromLibrary()
{
    library.AddItem(game);
    ICanBorrow item = library.BorrowItem();
    Assert.AreEqual("being borrowed", item.Borrow()); //MODIFIED
}
```

We get a compilation error! Why? We know that we gave the library a game, so why can't we make it be borrowed?

When we use an interface type, the object only has access to the methods on the interface. So if the compiler thinks it's an ICanBorrow, it can only do what an ICanBorrow can do. It cannot be borrowed. In fact our interface does nothing except give our class it's type as a big warm blanket to hide in.

What do we do if we want to get the original item back?

## Casting

We can use "casting" to get our original object back. This is just way of saying "hey, I know I gave you a Game I'd like it back". The Game is just being an ICanBorrow for the moment, but at the end of the day it is `still a game` and we can always get it back.

```csharp
//LibraryTest.cs

[Test]
public void TestCanGetItemFromLibrary()
{
    library.AddItem(game);
    ICanBorrow item = library.BorrowItem();
    Game original = (Game)item; //ADDED
    Assert.AreEqual("being borrowed", original.Borrow());  //MODIFIED
}

```

After doing the cast, we have access to all of the methods on the original type.

## Defining a contract

So interfaces also have another super power that we haven't seen yet.

```csharp
//LibraryTest.cs

[Test]
public void TestICanBorrowItemCanPlay()
{
    library.AddItem(game);
    ICanBorrow item = library.BorrowItem();
    Assert.AreEqual("being borrowed", item.Borrow());
}
```

We can actually make this code work, by defining the method on the ICanBorrow interface.

```csharp
//Library.cs

public interface ICanBorrow {
  string Borrow();
}

```

This defines a *contract* which says that everything that implements ICanBorrow *must* have a method Borrow() that returns a String.

We need to add a Borrow() method to our Book.

```csharp
//Book.cs

public class Book : ICanBorrow {
  string Borrow() 
  {
    return "being borrowed";
  }
}
```