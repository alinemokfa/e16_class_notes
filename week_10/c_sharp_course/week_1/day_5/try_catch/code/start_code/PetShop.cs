using System.Collections.Generic;

public class PetShop
{
  private List<Pet> stock;

  public PetShop(){
    stock = new List<Pet>();
  }

  public Pet FindPetByName(string searchName) 
  {    
    string searchLower = searchName.ToLower();
    foreach (var pet in stock)
    {
      string petName = pet.GetName().ToLower();
      if ( petName.Equals(searchLower) ) 
      {
        return pet;
      }
    }
    return null;
  }

  public void AddPet(Pet pet)
  {
    stock.Add(pet);
  }

}