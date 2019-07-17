package example.codeclan.com.liskov;

/**
 * Created by user on 27/06/2017.
 */

class Artist {
  /*
    A liskov violation takes place when a function takes in an superclass as a parameter - it should be able to take in any of the superclass' subclasses without breaking.
    In this example, we can create a subclass of shape - say, triangle - that when passed to drawShape, returns null rather than "I'm drawing a triangle!".
    Change the code so that it will work regardless of the type of shape that is passed in.
    Hint - you can get the name of an object's class by doing something like:
    this.getClass().getSimpleName();
  */

    public String drawShape(Shape shape) {
        if(shape instanceof Square){
            return "I'm drawing a square!";
        } else if(shape instanceof Circle) {
            return "I'm drawing a circle!";
        }

        return null;
    }
}
