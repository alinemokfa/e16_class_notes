using System.Collections.Generic;

namespace Library {
  class Library {
    private string name;
    private int capacity;
    private List<Book> bookItems;
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
      this.bookItems = new List<Book>();
      this.gameItems = new List<Game>();
    }

    public int ItemCount()
    {
      return this.bookItems.Count + this.gameItems.Count;
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
      this.bookItems.Clear();
      this.gameItems.Clear();
    }
  }
}