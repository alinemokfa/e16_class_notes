package example.codeclan.com.godzilla;
import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class GodzillaTest {

    Kaiju godzilla;
    Vehicle tank;
    Building empireStates;

    @Before
    public void before(){
        godzilla = new Godzilla("Gary", 100, 50);
        tank = new Tank(100, 40);
        empireStates = new Skyscraper("Skyscraper", 400);
    }

    @Test
    public void hasName(){
        assertEquals("Gary", godzilla.getName());
    }

    @Test
    public void canRoar(){
        assertEquals("Roooooaooooaaaaaaaaar!!!", godzilla.roar());
    }

    @Test
    public void canGetHealthValue(){
        assertEquals(100, godzilla.getHealthValue());
    }

    @Test
    public void canAttackVehicle(){
        godzilla.attackVehicle(tank);
        assertEquals(50, tank.getHealthValue());
    }

    @Test
    public void canAttackBuilding() {
        godzilla.attackBuilding(empireStates);
        assertEquals(350, empireStates.getHealthValue());
    }
}
