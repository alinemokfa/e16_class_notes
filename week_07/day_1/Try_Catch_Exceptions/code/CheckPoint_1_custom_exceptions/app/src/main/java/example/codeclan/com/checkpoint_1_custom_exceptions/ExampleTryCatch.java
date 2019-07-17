package example.codeclan.com.checkpoint_1_custom_exceptions;

/**
 * Created by user on 30/08/2017.
 */

public class ExampleTryCatch{
    PetShop shop;

    public void run(){
        setup();
        Pet found = shop.findPetByName("Meowingtons");
        System.out.println("Found pet: " + found.getName());
    }

    public void setup(){
        shop = new PetShop();
        shop.addPet(new Dog("RoveR"));
        shop.addPet(new Cat("meowingtons"));
        shop.addPet(new Fish("FINlay"));
    }
}
