namespace WizardManagement {
  public abstract class Carpet {

    private string colour;

    public string Colour 
    {
      get { return colour; }
      set { colour = value; }
    }

    public Carpet(string colour) {
      this.colour = colour;
    }
  }
}
