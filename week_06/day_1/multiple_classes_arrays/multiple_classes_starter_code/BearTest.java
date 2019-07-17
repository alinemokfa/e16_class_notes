import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BearTest{
  Bear bear;

  @Before 
  public void before() {
    bear = new Bear("Baloo");
  }

  @Test
  public void hasName(){
    assertEquals("Baloo", bear.getName()); 
  }
}
