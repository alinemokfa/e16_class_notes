package discount;
import java.util.*;
import basket.*;

public interface Discount{
  double totalDiscount( ArrayList<Item> items, double total );
}
