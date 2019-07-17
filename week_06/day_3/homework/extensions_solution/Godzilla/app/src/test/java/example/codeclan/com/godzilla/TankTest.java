package example.codeclan.com.godzilla;
import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class TankTest {

    Godzilla godzilla;
    Tank tank;

    @Before
    public void before(){
        godzilla = new Godzilla("Gary", 100, 50);
        tank = new Tank(100, 40);
    }

    @Test
    public void canGetHealthValue(){
        assertEquals(100, tank.getHealthValue());
    }

    @Test
    public void canAttackKaijuWithType1Attack(){
        tank.attack(godzilla);
        assertEquals(60, godzilla.getHealthValue());
    }

    @Test
    public void canAttackKaijuWithType2Attack(){
        tank.superAttack(godzilla);
        assertEquals(20, godzilla.getHealthValue());
    }
}
