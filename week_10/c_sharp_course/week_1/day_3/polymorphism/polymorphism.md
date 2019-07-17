# Polymorphism to the rescue

### Learning Objectives

- Understand the power of polymorphism
- Use polymorphic methods and collections

# Intro

So we saw a solution to let us add both a Book and a Game to our Library. However, we weren't very happy with it since it wasn't very DRY and or scaleable. 

We can solve all of our problems with "polymorphism". This isn't as scary as it sounds, it justs means we can wrap our objects up in an enclosing type that defines a contract between them all. 

Huh?

I know... let's just look at an example.

## Interfaces

Now, the natural thing to do might be to pull out a superclass. We are not going to do that. Inheritance is fraught with problems and we can quickly get into a mess. Luckily, statically typed languages offer us another construct we can use - interfaces.

An interface allows us to give a super power to our class. It gains the type of the interface without having a horrible inheritance chain. We can have as many interfaces as we like, too. Rather than just one super class.

Let's have an interface that both of our ICanBorrow types implement from. Both a Book and a Game are edible.

```bash
# terminal

touch ICanBorrow.cs
```

```csharp
//ICanBorrow.cs

public interface ICanBorrow {
  
}
```

We use this interface in the same way we inherit from a base class, i.e. by using a colon:

```csharp
//Book.cs

public class Book : ICanBorrow {

}
```

Let's do the same thing to the Game class.

[i:] Give the students 2 mins to try it themselves

```csharp
//Game.cs

public class Game : ICanBorrow {

  public string Borrow()
  {
    return "being borrowed";
  }
}
```

Great. Now, in some languages, like Ruby, this doesn't really mean much since we can pass anything to any method, and put anything we want into Arrays. In C# (and Java), however, this concept is extremely important. Our Book is both a Book AND an ICanBorrow. Our Game is both a Game AND an ICanBorrow.

What does this mean for us though? Let's revist our library's items list.

## Polymorphic collections

We can now delete some of our stinky code!

```csharp
//Library.cs

using System.Collections.Generic;

namespace Library {
  class Library {
    private string name;
    private int capacity;
    private List<Book> bookItems; //DELETED
    private List<Game> gameItems;

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
      this.bookItems = new List<Book>(); //DELETED
      this.gameItems = new List<Game>();
    }

    public int ItemCount()
    {
      return this.bookItems.Count + this.gameItems.Count; //DELETED
    }

    public void AddItem(Book book) //DELETE FULL METHOD
    {
      this.bookItems.Add(book);
    }

    public void AddItem(Game game)
    {
      this.gameItems.Add(game);
    }

    public void ClearShelves()
    {
      this.bookItems.Clear(); //DELETED
      this.gameItems.Clear();
    }
  }
}
```

After deletion:

```csharp
//Library.cs

using System.Collections.Generic;

namespace Library {
  class Library {
    private string name;
    private int capacity;
    private List<Game> gameItems;

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
      this.gameItems = new List<Game>();
    }

    public int ItemCount()
    {
      
    }

    public void AddItem(Game game)
    {
      this.gameItems.Add(game);
    }

    public void ClearShelves()
    {
      this.gameItems.Clear();
    }
  }
}
```

Didn't that feel good?? Now we can fix our code to be nice and polymorphic. Our List can just be a "items" again.

```csharp
//Library.cs

using System.Collections.Generic;

namespace Library {
  class Library {
    private string name;
    private int capacity;
    private List<Game> items;

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
      this.items = new List<Game>();
    }

    public int ItemCount()
    {
      
    }

    public void AddItem(Game game)
    {
      this.items.Add(game);
    }

    public void ClearShelves()
    {
      this.items.Clear();
    }
  }
}
```

Our ItemCount() method can go back to just returning the size of the items List.

```csharp
//Library.cs

  public int ItemCount()
  {
    return this.items.Count;
  }
```

We are going to do something controversial - we are going to make our items List contain ICanBorrow, NOT Books or Games.

```csharp
class Library {
  private string name;
  private int capacity;
  private List<ICanBorrow> items; //UPDATED

  ...

  public Library (string name, int capacity)
  {
    this.name = name;
    this.capacity = capacity;
    this.items = new List<ICanBorrow>(); //UPDATED
  }

  ...
}
```

Similarly, our AddItem() method is going to accept ICanBorrow.

```csharp
//Library.cs

public void AddItem(ICanBorrow item)  //UPDATED
{
  this.items.Add(item);  //UPDATED
}
```

Believe or not, all of our tests still pass!!!!

How can this be?

## Magic

The beauty of "polymorphism" is that any type can behave as if it is any of it's super class types as well as it own. Our Book can be both a Book and an ICanBorrow, like we mentioned earlier. So anything accepting ICanBorrow can accept a Book. 

However, it does NOT apply the other way round. Anything accepting a Book does NOT accept an ICanBorrow. Not every ICanBorrow is a Book! But every Book is an ICanBorrow.