import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
import discount.*;
import basket.*;

public class PercentageDiscountTest{
  @Test
  public void givesPercentageOfTotal(){
    PercentageDiscount tenPercentDiscount = new PercentageDiscount( 0.1, 0.0 );
    assertEquals( 10.0, tenPercentDiscount.totalDiscount(new ArrayList<Item>(), 100), 0.001 );
  }

  @Test
  public void doesntGiveDiscountIfBelowThreshold(){
    PercentageDiscount tenPercentDiscount = new PercentageDiscount( 0.1, 100.00 );
    assertEquals( 0.0, tenPercentDiscount.totalDiscount(new ArrayList<Item>(), 50), 0.001 );
  }
}
