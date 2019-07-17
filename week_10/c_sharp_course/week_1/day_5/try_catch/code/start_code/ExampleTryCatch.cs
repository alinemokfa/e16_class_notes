using System;

public class ExampleTryCatch
{
  PetShop shop;

  public void Run()
  {
    this.Setup();
    Pet found = shop.FindPetByName("Meowingtons");
    Console.WriteLine("Found pet: " + found.GetName());
  }

  public void Setup()
  {
    shop = new PetShop();
    shop.AddPet(new Dog("Rover"));
    shop.AddPet(new Cat("MEOWingtons"));
    shop.AddPet(new Fish("FINlay"));
  }
}
