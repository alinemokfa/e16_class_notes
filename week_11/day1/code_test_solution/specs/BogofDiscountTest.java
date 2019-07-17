import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
import discount.*;
import basket.*;

public class BogofDiscountTest{
  @Test
  public void shouldGiveZeroIfNoBogofItems(){
    Discount bogof = new BogofDiscount();
    ArrayList<Item> items = new ArrayList<Item>();
    assertEquals( 0.0, bogof.totalDiscount( items, 0.0 ), 0.001 );
  }

  @Test
  public void shouldGiveSavingIfTwoBogofItems(){
    BogofDiscount bogof = new BogofDiscount();
    bogof.addDiscountItem("Orange");
    ArrayList<Item> items = new ArrayList<Item>();

    Item orange1 = new Item("Orange", 5.00);
    Item orange2 = new Item("Orange", 5.00);
    items.add( orange1 );
    items.add( orange2 );
    assertEquals( 5.00, bogof.totalDiscount( items, 0.0  ), 0.001 );
  }

  @Test
  public void shouldNotGiveDiscountIfOnlyOneItem(){
    BogofDiscount bogof = new BogofDiscount();
    bogof.addDiscountItem("Orange");
    ArrayList<Item> items = new ArrayList<Item>();

    Item orange1 = new Item("Orange", 5.00);
    items.add( orange1 );
    assertEquals( 0.00, bogof.totalDiscount( items, 0.0  ), 0.001 );
  }
}
