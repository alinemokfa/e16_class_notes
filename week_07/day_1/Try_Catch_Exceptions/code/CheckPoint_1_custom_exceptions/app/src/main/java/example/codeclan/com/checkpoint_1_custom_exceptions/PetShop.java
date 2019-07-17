package example.codeclan.com.checkpoint_1_custom_exceptions;

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
        // add an if statement to catch a null String
        if (searchName == null){
            // and throw a new exception

                throw new NullStringException("Cannot search for a pet with null instead of a name String");

        }
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
