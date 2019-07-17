abstract class Vehicle {

  private int numberOfWheels;

  public int NumberOfWheels
  {
    get { return this.numberOfWheels; }
    set { this.numberOfWheels = value; }
  }

  public Vehicle(int numberOfWheels)
  {
    this.numberOfWheels = numberOfWheels;
  }

  public string StartEngine()
  {
    return ("Vrrmmm");
  }

  public abstract string Drive();
}