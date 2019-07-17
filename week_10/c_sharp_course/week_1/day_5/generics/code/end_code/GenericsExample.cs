using System;

namespace GenericsExample {
  class Account<T> {
    private T id;
    private string name;

    public T Id
    {
        get { return this.id; }
    }

    public string Name
    {
        get { return this.name; }
        set { this.name = value; }
    }

    public Account(T id, string name)
    {
      this.id = id;
      this.name = name;
    }

    public string ToString()
    {
      return this.id +"(" + typeof(T).ToString() + ") : " + this.name;
    }

  }

  class Program
  {
      static void Main()
      {
          Account<int> account1 = new Account<int>(1234, "Jack Jarvis");
          Account<string> account2 = new Account<string>("CC99XX", "Victor McDade");
          Console.WriteLine(account1.ToString());
          Console.WriteLine(account2.ToString()); 
      }
  }
}