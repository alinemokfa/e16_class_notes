package example.codeclan.com.checkpoint_1_abstract_class;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 * Created by user on 28/08/2017.
 */

public class BearTest {
    PolarBear bear1;
    GrizzlyBear bear2;

    @Before
    public void before() {
        bear1 = new PolarBear();
        bear2 = new GrizzlyBear();
    }

    @Test
    public void polarCanGather(){
        assertEquals("Gathering food, breaking the ice", bear1.gatherFood());
    }

    @Test
    public void grizzlyCanGather(){
        assertEquals("Gathering food, fishing in the river", bear2.gatherFood());
    }

    @Test
    public void canHibernate() {
        assertEquals("Finding a nice Igloo to sleep", bear1.hibernate());
        assertEquals("Finding a nice cave to sleep", bear2.hibernate());
    }

    @Test
    public void canRoar(){
        assertEquals("roar!", bear1.roar());
        assertEquals("roar!", bear2.roar());
    }
}
