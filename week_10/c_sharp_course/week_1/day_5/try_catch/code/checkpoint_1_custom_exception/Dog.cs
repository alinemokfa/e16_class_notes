public class Dog : Pet
{
  private string name;

  public Dog(string name)
  {
    this.name = name;
  }  

  public string GetName()
  {
    return this.name;
  }
}