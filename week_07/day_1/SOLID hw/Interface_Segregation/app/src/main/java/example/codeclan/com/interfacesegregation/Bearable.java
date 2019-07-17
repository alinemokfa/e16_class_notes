package example.codeclan.com.interfacesegregation;

/**
 * Created by user on 27/06/2017.
 */

public interface Bearable{

    // This interface is trying to be all Bears to all people.
    // It really needs broken up into multiple smaller interfaces, otherwise it's not much use.
    // and it certainly breaks the interface segregation principle, by forcing the implementation of methods that are extremely unlikely to be used.

    public Salmon riverFish();
    public Seal iceFish();
    public Honey harvestHoney();
    public Bamboo harvestBamboo();
    public String sleep();
    public String climbRock();
    public String climbTree();
    public String climbIceberg();
    public void eat(Edible food);

}