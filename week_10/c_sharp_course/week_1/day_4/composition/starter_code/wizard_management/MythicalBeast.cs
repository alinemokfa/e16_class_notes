namespace WizardManagement {
   public abstract class MythicalBeast {

    private string name;

    public string Name 
    {
      get { return name; }
      set { name = value; }
    }

    public MythicalBeast(string name)
    {
      this.name = name;
    }
  }
}