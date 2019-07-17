using System.Collections.Generic;

namespace Library {
  class Library {
    private string name;
    private int capacity;
    private List<ICanBorrow> items;

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
      this.items = new List<ICanBorrow>();
    }

    public int ItemCount()
    {
      return this.items.Count;
    }

    public void AddItem(ICanBorrow item)
    {
      this.items.Add(item);
    }

    public void ClearShelves()
    {
      this.items.Clear();
    }

    public ICanBorrow BorrowItem()
    {
      if (this.ItemCount() > 0)
      {
        ICanBorrow item = this.items[0];
        this.items.RemoveAt(0);
        return item;
      }
      return null;
    }
  }
}