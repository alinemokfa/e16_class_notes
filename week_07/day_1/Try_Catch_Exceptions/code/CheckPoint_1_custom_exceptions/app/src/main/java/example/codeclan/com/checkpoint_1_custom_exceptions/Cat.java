package example.codeclan.com.checkpoint_1_custom_exceptions;

/**
 * Created by user on 30/08/2017.
 */

public class Cat implements Pet{
    private String name;

    public Cat(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
