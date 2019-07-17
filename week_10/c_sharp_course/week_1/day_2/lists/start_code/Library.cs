namespace Library {
  class Library {
    private string name;
    private int capacity;
    private Book[] items;

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
      this.items = new Book[capacity];
    }

    public int ItemCount()
    {
      int count = 0;
      foreach(var item in items){
        if (item != null)
          count++;
      }
      return count;
    }

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

    public void ClearShelves()
    {
      for(int i = 0; i < items.Length; i++){
        items[i] = null;
      }
    }
  }
}