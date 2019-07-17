import static org.junit.Assert.assertEquals;
import org.junit.Test;
import discount.*;
import basket.*;

public class IntegrationTest{
  @Test
  public void shouldConsiderBogofDiscount(){
    Basket myBasket = new Basket();
    Item cake1 = new Item("Cake", 5.00);
    Item cake2 = new Item("Cake", 5.00);
    Item orange1 = new Item("Orange", 1.00);
    Item orange2 = new Item("Orange", 1.00);

    myBasket.addItem( cake1 );
    myBasket.addItem( cake2 );
    myBasket.addItem( orange1 );
    myBasket.addItem( orange2 );

    BogofDiscount bogof = new BogofDiscount();
    bogof.addDiscountItem("Orange");

    myBasket.applyDiscount( bogof );

    assertEquals( 11.00, myBasket.total(), 0.001);
  }

  @Test
  public void shouldConsiderBogofAnd20PoundDiscount(){
    Basket myBasket = new Basket();
    Item cake1 = new Item("Cake", 5.00);
    Item cake2 = new Item("Cake", 5.00);

    Item avo = new Item("Avocado", 19.00);

    Item orange1 = new Item("Orange", 1.00);
    Item orange2 = new Item("Orange", 1.00);

    myBasket.addItem( cake1 );
    myBasket.addItem( cake2 );
    myBasket.addItem( orange1 );
    myBasket.addItem( orange2 );
    myBasket.addItem( avo );


    BogofDiscount bogof = new BogofDiscount();
    PercentageDiscount tenPercentDiscount = new PercentageDiscount(0.1, 20);

    bogof.addDiscountItem("Orange");

    myBasket.applyDiscount( bogof );
    myBasket.applyDiscount( tenPercentDiscount );
    //27 = 31 - 1(from bogof) - 3(ten percent)
    assertEquals( 27.00, myBasket.total(), 0.001);
  }
}
