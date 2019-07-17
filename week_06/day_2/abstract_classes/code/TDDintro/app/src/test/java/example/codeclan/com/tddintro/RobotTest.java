package example.codeclan.com.tddintro;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by tonygoncalves on 31/10/2017.
 */



public class RobotTest {

    Robot robot;

    @Before
    public void before(){
        robot = new Robot("C3P0", "Gold");
    }

    @Test
    public void testRobotSetUp(){
        Robot robot = new Robot("C3P0", "Gold");
        assertEquals("C3P0", robot.getName());
        assertEquals("Gold", robot.getColour());
    }
    @Test
    public void testBattery(){
       double battery = robot.checkBattery();
        assertEquals(100.0, battery, 0.01 );
    }
    @Test
    public void testRobotMakesDrink(){
        String message = robot.makeDrink("Tea");
        assertEquals("I am making Tea", message);
        assertEquals(90.00, robot.checkBattery(), 0.01 );
    }
    @Test
    public void testRobotWashDishes(){
        String message = robot.washDish("dishes");
        assertEquals("I am washing dishes", message);
        assertEquals(70.00, robot.checkBattery(), 0.01);
    }
    @Test
    public void testRobotDusting(){
        String message = robot.robotDusting();
        assertEquals("I am dusting", message);
        assertEquals(80.00, robot.checkBattery(), 0.01 );
    }
    @Test
    public void testRobotRecharge(){
        robot.robotDusting();
        assertEquals(80.00, robot.checkBattery(), 0.01 );
        robot.rechargeBattery();
        assertEquals(100.0, robot.checkBattery(), 0.01);

    }
}
