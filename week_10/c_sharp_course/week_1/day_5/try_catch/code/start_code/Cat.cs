public class Cat : Pet
{
  private string name;

  public Cat(string name)
  {
    this.name = name;
  }

  public string GetName()
  {
    return this.name;
  }
  
}