class Motorbike : Vehicle {
  public Motorbike() : base(2)
  {
    
  }

  public string StartEngine()
  {
    string vehicleStart = base.StartEngine();
    return (vehicleStart + " (I'm a motorbike), HELL YEAH!");
  }

  public override string Drive()
  {
    return "use handlebars";
  }
}