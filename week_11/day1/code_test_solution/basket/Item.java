package basket;

public class Item{
  private String name;
  private double value;

  public Item(String name, double value){
    this.name = name;
    this.value = value;
  }

  public String getName(){
    return this.name;
  }

  public double getValue(){
    return this.value;
  }
}
