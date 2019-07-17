package example.codeclan.com.task_solution;

/**
 * Created by user on 28/08/2017.
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


public class InheritanceTest {
    Human tarzan;
    Chimpanzee cheeta;

    @Before
    public void before(){
        tarzan = new Human();
        cheeta = new Chimpanzee();
    }

    @Test
    public void testHumanCanEat(){
        assertEquals("Mmmmm!", tarzan.eat());
    }

    @Test
    public void testHumanCanBreathe(){
        assertEquals("Huff, puff", tarzan.breathe());
    }

    @Test
    public void testHumanCanBrushHair(){
        assertEquals("I look so goooood!", tarzan.brushHair());
    }

    @Test
    public void testHumanCanSpeak(){
        assertEquals("What what, pip pip old boy!", tarzan.speak());
    }

    @Test
    public void testChimpCanSpeak(){
        assertEquals("Oo-oo! Ah-ah!", cheeta.speak());
    }

    @Test
    public void testChimpCanEat(){
        assertEquals("Mmmmm!", cheeta.eat());
    }

    @Test
    public void testChimpCanBreathe(){
        assertEquals("Huff, puff", cheeta.breathe());
    }

    @Test
    public void testChimpCanBrushHair(){
        assertEquals("I look so goooood!", cheeta.brushHair());
    }

}