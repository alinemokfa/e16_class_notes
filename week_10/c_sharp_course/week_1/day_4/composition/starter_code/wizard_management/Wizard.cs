namespace WizardManagement
{
  public class Wizard
  {
    private string name;
    private Broomstick broomstick;

    public string Name 
    {
      get { return name; }
      set { name = value; }
    }

    public Broomstick Broomstick
    {
      get { return broomstick; }
    }
    
    public Wizard(string name, Broomstick broomstick)
    {
      this.name = name;
      this.broomstick = broomstick;
    }

    public string Fly()
    {
      return this.broomstick.Fly();
    }
  }
}