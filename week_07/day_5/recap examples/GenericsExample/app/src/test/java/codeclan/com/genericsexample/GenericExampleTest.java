package codeclan.com.genericsexample;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by user on 10/11/2017.
 */

public class GenericExampleTest {
    @Test
    public void testAddItem() {

        //Never do this as it means you accept of type object
        //which is anything. Which means you dont know what your getting
        HashMap anything = new HashMap();

        //for example
        //        anything.put(1, "d");
        //        anything.put("g", 5);
        //        anything.put(true, "d");
    }
}
