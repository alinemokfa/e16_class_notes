namespace EnumExample {
  public class Account {
  
    private string type;
  
    public string Type
    {
      get { return this.type; }
      set { this.type = value; }
    }
  
    public Account(string type)
    {
      this.type = type;
    }
  
  }
}