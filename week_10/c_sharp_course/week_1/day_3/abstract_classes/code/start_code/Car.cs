class Car : Vehicle {
  private string model;

  public string Model
  {
    get { return this.model; }
    set { this.model = value; }
  }

  public Car(string model) : base(4)
  {
    this.model = model;
  }
}