using System.Collections.Generic;

namespace Library {
  class Library {
    private string name;
    private int capacity;
    private List<Book> items;

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
      this.items = new List<Book>();
    }

    public int ItemCount()
    {
      return this.items.Count;
    }

    public void AddItem(Book book)
    {
      this.items.Add(book);
    }

    public void ClearShelves()
    {
      this.items.Clear();
    }
  }
}