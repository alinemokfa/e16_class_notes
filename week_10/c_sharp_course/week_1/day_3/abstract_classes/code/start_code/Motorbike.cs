class Motorbike : Vehicle {
  public Motorbike() : base(2)
  {
    
  }

  public string StartEngine()
  {
    string vehicleStart = base.StartEngine();
    return (vehicleStart + " (I'm a motorbike), HELL YEAH!");
  }
}