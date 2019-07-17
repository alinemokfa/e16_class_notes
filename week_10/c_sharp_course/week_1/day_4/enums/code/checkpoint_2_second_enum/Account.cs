namespace EnumExample {
  public class Account {
  
    private AccountType type;
    private AccountStatus status;
  
    public AccountType Type
    {
      get { return this.type; }
      set { this.type = value; }
    }

    public AccountStatus Status
    {
      get { return this.status; }
      set { this.status = value; }
    }
  
    public Account(AccountType type, AccountStatus status)
    {
      this.type = type;
      this.status = status;
    }
  
  }
}