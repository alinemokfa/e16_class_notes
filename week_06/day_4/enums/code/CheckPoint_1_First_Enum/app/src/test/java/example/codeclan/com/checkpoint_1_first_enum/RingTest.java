package example.codeclan.com.checkpoint_1_first_enum;

/**
 * Created by user on 29/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class RingTest {

    Ring ring;

    @Before
    public void before(){
        ring = new Ring(MetalType.GOLD);
    }

    @Test
    public void canGetMetal(){
        assertEquals(MetalType.GOLD, ring.getMetal());
    }

    // @Test
    // public void metalCanBeMispelled(){
    //   ring = new Ring("Golllld");
    //   assertEquals("Golllld", ring.getMetal());
    // }

    // @Test
    // public void metalCanBeBanana(){
    //   ring = new Ring("Banana");
    //   assertEquals("Banana", ring.getMetal());
    // }

}
