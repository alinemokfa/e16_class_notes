package example.codeclan.com.composition_lab_solution;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_lab_solution.wizard_management.*;


public class WizardTest {

    Wizard wizard;
    Broomstick broomstick;
    Ogre ogre;

    @Before
    public void before(){
        broomstick = new Broomstick("Nimbus", 10);
        ogre = new Ogre("Herbert");
        wizard = new Wizard("Toby", broomstick, ogre);
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
    public void canFlyBroomstick(){
        assertEquals("mounting broom, running, skipping, flying!", wizard.fly());
    }

    @Test
    public void canFlyDragon(){
        Dragon dragon = new Dragon("Tilly");
        wizard = new Wizard("Toby", dragon, ogre);
        assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());
    }

    @Test
    public void canFlyMagicCarpet(){
        MagicCarpet carpet = new MagicCarpet("Purple");
        wizard = new Wizard("Toby", carpet, ogre);
        assertEquals("Hovering up, straightening out, flying off!", wizard.fly());
    }

    @Test
    public void canSetRide(){
        Dragon dragon = new Dragon("Erik");
        wizard.setRide(dragon);
        assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());
    }

    @Test
    public void canDefendUsingOgre(){
        assertEquals("Hitting with a massive mace", wizard.defend());
    }

    @Test
    public void canSetGuard(){
        Dragon dragon = new Dragon("Erik");
        wizard.setGuard(dragon);
        assertEquals("Biting with sharp teeth", wizard.defend());
    }
}

