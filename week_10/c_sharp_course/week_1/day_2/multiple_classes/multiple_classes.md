# Multiple Classes - Basic Arrays

### Learning Objectives

- Understand two kinds of for loop
- Understand `null`
- Be able to use arrays in C#

## Intro

> Give out starter code

If you have a look at the code, we have one class - Library. This can have a name, and we have a little test to confirm this works.

Notice that we have a "Setup" method in our test class. This runs before each test to make sure we have instance of a library object for the test.

## Array Initialization

At some point, our Library is going to have some books. So let's make a ```Book``` class.

``` bash
# terminal
touch Book.cs
```

``` csharp
//Book.cs

public class Book {

}
```

Cool, we've got a Book. Now, our library is going to have more than one item for people to borrow, and to do this we're going to need to be able to contain some books i.e. items. What could we use to store our collection of books
? That's right, an array. 

``` csharp
//Library.cs

class Library {
    private string name;
    private int capacity;
    private Book[] items; //ADDED

  //same as before
}

```

We need to declare the type of things that go into the array, followed by square brackets then the name of the array variable. This means that Books and ONLY Books can be kept in this array.

We've declared the variable, but now we need to initialize it in the constructor. We need to give the array a size. We could just hard code a value, but since the library has a capacity, let's use that for the size of the array:

``` csharp
//Library.cs

public Library (string name, int capacity)
{
  this.name = name;
  this.capacity = capacity;
  this.items = new Book[capacity]; //ADDED
}
```

We need to give the array a size and it can only be of this length. If we try to add more items than we have stated for the size then we will get an error.

The array is not actually empty - it is already populated with null entries. This will become important later.

## Counting the items

We want to see how many items the library has - initially it should be zero.

Let's write the test

``` csharp
//LibraryTest.cs

[Test]
public void TestLibraryStartsEmpty()
{
    Assert.AreEqual(0, library.ItemCount());
}
```

Bearing in mind  that our array is not empty - it's full of null values, how can we count how many items are in the library's items array.

> Let the students have a think about it for 2 minutes

For loops over collections look a little strange in C#.

``` csharp
//Library.cs

  public int ItemCount()
  {
    foreach(var item in items){
      
    }
  }
```

Note that we are using the type```var```, rather than ```Book```. This means that the type of the local being declared, in this case 'item' will be inferred by the compiler. The ```var``` references a type in an implicit way. It aliases any type. It's basically syntactic sugar

We're going to need some kind of count so let's add that.

``` csharp
//Library.cs

  public int ItemCount()
  {
    int count = 0;
    foreach(var item in items){

    }
    return count;
  }
```


Lastly we only want to count those entries which are not null.

``` csharp
//Library.cs

  public int ItemCount()
  {
    int count = 0;
    foreach(var item in items){
      if (item != null)
      {
        count++;
      }
    }
    return count;
  }
```

Cool! We should now have a passing test.

## 

Let's try to add a book to our library. First, let's add a test book to our unit tests.

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
        Book book;  //ADDED

        [SetUp]
        public void Init()
        {
            library = new Library("CC Library", 10);
            book = new Book(); //ADDED
        }
        //same as before
    }
}

```

Cool, now we can use this Book in our tests.

``` csharp
//LibraryTest.cs

[Test]
public void TestCanAddBookToLibrary()
{
    library.AddItem(book);
    Assert.AreEqual(1, library.ItemCount());
}

```

Let's add the AddItem() method.

``` csharp
//Library.cs

public class Library {
  //same as before

  public void AddItem(Book book)
  {

  }
}
```

Now, there's is some bad news. We can't just add something to the end of an array. The only way to add an item is to set it explicitly by using an index position.

``` csharp
//Library.cs

public void AddItem(Book book)
{
  this.items[0] = book;
}
```
What would happen if we left it like this? Yep, we'd only ever have one Book in our library and the rest of the items would be null. How are we going to fix this?

> Let them think about it for a moment

One possible solution is to keep a counter everytime we add a Book, so that we know where the next Book should be added.

``` csharp
//Library.cs

public void AddItem(Book book))
{
  int itemCount = this.ItemCount();
  this.items[itemCount] = book;
}
```

## Index out of bounds

We do have a little problem, however. What happens if we try to add 20 books to the library? Let's write a little for loop that adds a book 20 times to our library.

> This  `for`-loop should have been covered, but feel free to go over it again.

``` csharp
//LibraryTest.cs

[Test]
public void TestCannotAddBookWhenFull()
{
  for (int i = 0; i < 20; i++)
  {
    library.AddItem(book);
  }
  Assert.AreEqual(10, library.ItemCount());
}
```

A dirty great big exception! Our Array can only have 10 items and no more. When we try to add another one, the compiler throws a hissy fit.

First, we need a new unit test. We'll comment out the TestCannotAddBookWhenFull etc one for now.

``` csharp
//LibraryTest.cs

//[Test]
//public void TestCannotAddBookWhenFull()
//{
//  for (int i = 0; i < 20; i++)
//  {
//    library.AddItem(book);;
//  }
//  Assert.AreEqual(10, library.ItemCount());
//}

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


Let's add a guard for when the library's book array is full.

``` csharp
//Library.cs

public bool ShelvesFull()
{
  return this.ItemCount() == this.items.Length;
}

public void AddItem(Book book)
{
  if (this.ShelvesFull())
  {
    return;
  }
  int itemCount = this.ItemCount();
  this.items[itemCount] = book;
}

```

Great now we can comment back in our test and it should be passing.

## Resetting the array

Lastly, let's add a way to clear all the books off the shelves.

``` csharp
//LibraryTest.cs

[Test] //ADDED
public void TestCanEmptyShelves()
{
  library.AddItem(book);
  library.ClearShelves();
  Assert.AreEqual(0, library.ItemCount());
}
```

How do you think we can do this?

> Give the students 2 mins to think it out

``` csharp
//Library.cs

public void ClearShelves()
{
  for(int i = 0; i < items.Length; i++){
    items[i] = null;
  }
}
```