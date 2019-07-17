package codeclan.com.packagesexample.human;

import codeclan.com.packagesexample.animal.Dog;

public class Trainer {
    public void teach(Dog dog) {
        dog.name = "Pet";
        dog.bark();
    }
}
