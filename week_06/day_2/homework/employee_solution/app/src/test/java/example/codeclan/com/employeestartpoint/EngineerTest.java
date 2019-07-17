package example.codeclan.com.employeestartpoint;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EngineerTest {
    Engineer engineer;

    @Before
    public void before() {
        engineer = new Engineer(1, "Ada", "AB123456C", 40000.00);
    }

    @Test
    public void canGetEmployeeId() {
        assertEquals(1, engineer.getId());
    }

    @Test
    public void canGetEmployeeName() {
        assertEquals("Ada", engineer.getName());
    }

    @Test
    public void canGetEmployeeSSn() {
        assertEquals("AB123456C", engineer.getSocialSecurityNumber());
    }

    @Test
    public void canGetEmployeeSalary() {
        assertEquals(40000.00, engineer.getSalary(), 0.01);
    }

    @Test
    public void canSetEmployeeName() {
        engineer.setName("Betty");
        assertEquals("Betty", engineer.getName());
    }

    @Test
    public void canRaiseSalary() {
        engineer.raiseSalary(5000.00);
        assertEquals(45000.00, engineer.getSalary(), 0.01);
    }
}
