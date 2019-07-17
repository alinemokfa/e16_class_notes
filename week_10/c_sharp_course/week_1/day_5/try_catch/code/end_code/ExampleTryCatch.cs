using System;

public class ExampleTryCatch
{
  PetShop shop;

  public void Run()
  {
    this.Setup();
    try 
    {
      Pet found = shop.FindPetByName(null);
      Console.WriteLine("Found pet: " + found.GetName());
    }
    catch (NullStringException ex)
    {
      Console.WriteLine(ex.ToString());
      Console.WriteLine("Exception Message:");
      Console.WriteLine(ex.Message);
    }
    finally
    {
      Console.WriteLine("and finally...");
      Console.WriteLine("I'm done.");
    }
  }

  public void Setup()
  {
    shop = new PetShop();
    shop.AddPet(new Dog("Rover"));
    shop.AddPet(new Cat("MEOWingtons"));
    shop.AddPet(new Fish("FINlay"));
  }
}
