namespace WizardManagement {
  public class Broomstick : CleaningImplement {
    private int speed;

    public int Speed
    {
        get { return speed; }
        set { speed = value; }
    }

    public Broomstick(string brand, int speed) : base(brand)
    {
      this.speed = speed;
    }

    public int GetSpeed(){
      return this.speed;
    }

    public string Fly(){
      return "mounting broom, running, skipping, flying!";
    }
  }

}