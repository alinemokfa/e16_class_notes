namespace EnumExample {
  public class Account {
  
    private AccountType type;
  
    public AccountType Type
    {
      get { return this.type; }
      set { this.type = value; }
    }
  
    public Account(AccountType type)
    {
      this.type = type;
    }
  
  }
}