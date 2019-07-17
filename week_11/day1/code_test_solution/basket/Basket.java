package basket;
import discount.*;

import java.util.*;

public class Basket{
  private ArrayList<Item> items = new ArrayList<Item>();
  private ArrayList<Discount> discounts = new ArrayList<Discount>();


  public double total(){
    double sum = 0.0;
    for (Item item : this.items) {
      sum = sum + item.getValue();
    }
    return sum - this.totalDiscount(sum);
  }

  private double totalDiscount( double totalWithoutDiscount ){
    double savings = 0.0;
    double totalToDiscount = totalWithoutDiscount;
    for (Discount discount: this.discounts){
      totalToDiscount = totalToDiscount - savings;
      savings = savings + discount.totalDiscount( this.items, totalToDiscount );
    }
    return savings;
  }


  public int numberOfItems(){
    return items.size();
  }

  public void addItem( Item item){
    items.add(item);
  }

  public void removeItem( int index){
    items.remove( index );
  }

  public void clearItems(){
    items.clear();
  }

  public void applyDiscount( Discount discount ){
    discounts.add(discount);
  }



}
