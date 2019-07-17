namespace WizardManagement {
  public abstract class CleaningImplement {
    
    string brand;

    public string Brand
    {
        get { return brand; }
        set { brand = value; }
    }
  
    public CleaningImplement() {

    }
    
    public CleaningImplement(string brand) {
      this.brand = brand;
    }
    
  }
}