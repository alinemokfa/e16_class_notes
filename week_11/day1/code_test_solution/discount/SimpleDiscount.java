package discount;
import java.util.*;
import basket.*;

public class SimpleDiscount implements Discount{
  private double saving;
  public SimpleDiscount(double saving){
    this.saving = saving;
  }

  public double totalDiscount( ArrayList<Item> items, double total ){
    return this.saving;
  }

}
