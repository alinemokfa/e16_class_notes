package example.codeclan.com.composition_lesson_end;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_lesson_end.wizard_management.*;


public class WizardTest {

    Wizard wizard;
    Broomstick broomstick;

    @Before
    public void before(){
        broomstick = new Broomstick("Nimbus", 10);
        wizard = new Wizard("Toby", broomstick);
    }

    @Test
    public void hasName(){
        assertEquals("Toby", wizard.getName());
    }

    @Test
    public void hasRide(){
        assertNotNull(wizard.getRide());
    }

    @Test
    public void canSetRide(){
        Dragon dragon = new Dragon("Erik");
        wizard.setRide(dragon);
        assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());
    }

    @Test
    public void canFlyBroomstick(){
        assertEquals("mounting broom, running, skipping, flying!", wizard.fly());
    }

    @Test
    public void canFlyDragon(){
        Dragon dragon = new Dragon("Tilly");
        wizard = new Wizard("Toby", dragon);
        assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());
    }

    @Test
    public void canFlyMagicCarpet(){
        MagicCarpet carpet = new MagicCarpet("Purple");
        wizard = new Wizard("Toby", carpet);
        assertEquals("Hovering up, straightening out, flying off!", wizard.fly());
    }
}
