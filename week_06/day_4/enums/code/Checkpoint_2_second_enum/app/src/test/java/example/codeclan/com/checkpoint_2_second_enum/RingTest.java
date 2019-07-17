package example.codeclan.com.checkpoint_2_second_enum;

/**
 * Created by user on 29/08/2017.
 */
import static org.junit.Assert.*;
import org.junit.*;

public class RingTest {

    Ring ring;

    @Before
    public void before(){
        ring = new Ring(MetalType.GOLD, GemType.SAPPHIRE);
    }

    @Test
    public void canGetMetal(){
        assertEquals(MetalType.GOLD,ring.getMetal());
    }


    @Test
    public void canGetGem(){
        assertEquals(GemType.SAPPHIRE, ring.getGem());
    }

}
