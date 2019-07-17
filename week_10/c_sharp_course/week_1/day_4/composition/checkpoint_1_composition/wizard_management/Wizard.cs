using Behaviours;

namespace WizardManagement
{
  public class Wizard
  {
    private string name;
    private IFly ride;

    public string Name 
    {
      get { return name; }
      set { name = value; }
    }

    public IFly Ride
    {
      get { return ride; }
      set { ride = value; }
    }
    
    public Wizard(string name, IFly ride)
    {
      this.name = name;
      this.ride = ride;
    }

    public string Fly()
    {
      return this.ride.Fly();
    }
  }
}