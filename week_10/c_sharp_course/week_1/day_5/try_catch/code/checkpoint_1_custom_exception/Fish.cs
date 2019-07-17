public class Fish : Pet 
{
  private string name;

  public Fish(string name)
  {
    this.name = name;
  }

  public string GetName()
  {
    return this.name;
  }
  
}