package example.codeclan.com.multiple_class_start;

/**
 * Created by user on 28/08/2017.
 */

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
