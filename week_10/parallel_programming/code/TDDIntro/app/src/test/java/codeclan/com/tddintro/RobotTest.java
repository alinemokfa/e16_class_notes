package codeclan.com.tddintro;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by user on 31/10/2017.
 */

public class RobotTest {

    Robot robot;

    @Before
    public void before() {
        this.robot = new Robot("C3PO", "Gold");
    }

    @Test
    public void testRobotSetUp() {
        assertEquals("C3PO", robot.getName());
        assertEquals("Gold", robot.getColour());
    }

    @Test
    public void testCheckBattery() {
        assertEquals(100.00, robot.checkBattery(), 0.01 );
    }

    @Test
    public void testRobotMakeDrink() {
        String message = robot.makeDrink("tea");
        assertEquals("I am making tea", message);
        assertEquals(90.00, robot.checkBattery(), 0.01);
    }

    @Test
    public void testRobotDusting() {
        String message = robot.doDusting();
        assertEquals("I am dusting", message);
        assertEquals(80.00, robot.checkBattery(), 0.01);
    }

    @Test
    public void testRobotRechargeBattery() {
        robot.doDusting();
        assertEquals(80.00, robot.checkBattery(), 0.01);
        robot.rechargeBattery();
        assertEquals(100.00, robot.checkBattery(), 0.01);
    }
}









