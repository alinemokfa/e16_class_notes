import static org.junit.Assert.assertEquals;
import org.junit.Test;
import discount.*;
import basket.*;

public class BasketTest{
  @Test
  public void startsWithZeroTotal(){
    Basket myBasket = new Basket();
    assertEquals( 0.0, myBasket.total(), 0.001 );
  }

  @Test
  public void startsWithNoItems(){
    Basket myBasket = new Basket();
    assertEquals( 0, myBasket.numberOfItems());
  }

  @Test
  public void showsValueOfSingleItem(){
    Basket myBasket = new Basket();
    Item cake = new Item("Cake", 5.00);
    myBasket.addItem( cake );
    assertEquals( 5.00, myBasket.total(), 0.001);
  }

  @Test
  public void canRemoveItems(){
    Basket myBasket = new Basket();
    Item cake = new Item("Cake", 5.00);
    myBasket.addItem( cake );
    myBasket.removeItem(0);
    assertEquals( 0, myBasket.numberOfItems());
  }

  @Test
  public void canClearItems(){
    Basket myBasket = new Basket();
    Item cake = new Item("Cake", 5.00);
    Item orange = new Item("Orange", 1.00);
    myBasket.addItem( cake );
    myBasket.addItem( orange );
    myBasket.clearItems();
    assertEquals( 0, myBasket.numberOfItems());
  }



  @Test
  public void showsValueOfMultipleItes(){
    Basket myBasket = new Basket();
    Item cake = new Item("Cake", 5.00);
    Item orange = new Item("Orange", 1.00);
    myBasket.addItem( cake );
    myBasket.addItem( orange );
    assertEquals( 6.00, myBasket.total(), 0.001);
  }

  public void shouldConsiderDiscounts(){
    Basket myBasket = new Basket();
    Item cake = new Item("Cake", 5.00);
    myBasket.addItem( cake );

    Discount poundOff = new SimpleDiscount(1.00);
    myBasket.applyDiscount( poundOff );
    assertEquals( 4.00, myBasket.total(), 0.001);
  }
}
