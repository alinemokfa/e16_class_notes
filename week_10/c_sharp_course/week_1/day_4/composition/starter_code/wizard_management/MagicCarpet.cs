namespace WizardManagement {
  public  class MagicCarpet : Carpet 
  {
    public MagicCarpet(string colour) : base(colour)
    {

    }

    public string Fly()
    {
      return "Hovering up, straightening out, flying off!";
    }
  }
}