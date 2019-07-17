package discount;
import java.util.*;
import basket.*;

public class BogofDiscount implements Discount{

  private ArrayList<String> bogofItemNames  = new ArrayList<String>();


  public void addDiscountItem( String itemName ){
    bogofItemNames.add( itemName );
  }

  private int numberOfItems( ArrayList<Item> items, String name ){
    int count = 0;
    for ( Item item : items ) {
      if( item.getName() == name ){
        count++;
      }
    }
    return count;
  }

  private double valueOfItem( ArrayList<Item> items, String name){
    for ( Item item : items ) {
      if( item.getName() == name ){
        return item.getValue();
      }
    }
    return 0.0;
  }

  private double discountForItemName( ArrayList<Item> items, String name ){
    double numberOfItems = this.numberOfItems(items, name);
    return Math.floor(numberOfItems/2)* this.valueOfItem(items, name);
  }

  public double totalDiscount( ArrayList<Item> items, double total ){
    double savings = 0.0;
    for ( String itemName : this.bogofItemNames ) {
      savings = savings + discountForItemName(items, itemName);
    }
    return savings;
  }

}
