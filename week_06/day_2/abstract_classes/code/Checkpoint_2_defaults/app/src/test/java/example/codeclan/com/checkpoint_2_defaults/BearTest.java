package example.codeclan.com.checkpoint_2_defaults;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 28/08/2017.
 */

public class BearTest {
    Bear bear;

    @Before
    public void before() {
        bear = new PolarBear();
    }

    @Test
    public void canGather(){
        assertEquals("Gone fishing", bear.gatherFood());
    }

    @Test
    public void canRoar(){
        assertEquals("roar!", bear.roar());
    }
}
