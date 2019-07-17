package example.codeclan.com.inheritance_start_point;

/**
 * Created by user on 28/08/2017.
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class VehicleTest {
    Car car;
    MotorBike motorbike;

    @Before
    public void before(){
        car = new Car();
        motorbike = new MotorBike();
    }

    @Test
    public void testCarHasFourWheels(){
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void testMotorbikeHasTwoWheels(){
        assertEquals(2, motorbike.getNumWheels());
    }
}
