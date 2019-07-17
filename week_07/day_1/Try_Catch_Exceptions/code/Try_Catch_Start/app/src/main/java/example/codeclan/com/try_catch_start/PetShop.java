package example.codeclan.com.try_catch_start;

/**
 * Created by user on 30/08/2017.
 */

import java.util.ArrayList;

public class PetShop{

    private ArrayList<Pet> stock;

    public PetShop(){
        stock = new ArrayList<Pet>();
    }

    public Pet findPetByName(String searchName) {
        String searchLower = searchName.toLowerCase();
        for (Pet pet : stock){
            String petName = pet.getName().toLowerCase();
            if ( petName.equals(searchLower) ) return pet;
        }
        return null;
    }

    public void addPet(Pet pet){
        stock.add(pet);
    }

}
