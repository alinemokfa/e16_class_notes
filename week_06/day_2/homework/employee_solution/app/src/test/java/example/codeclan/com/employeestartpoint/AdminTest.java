package example.codeclan.com.employeestartpoint;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdminTest {

    Admin admin;

    @Before
    public void before() {
        admin = new Admin(1, "Fred", "AB123456C", 20000.00);
    }

    @Test
    public void canGetEmployeeId() {
        assertEquals(1, admin.getId());
    }

    @Test
    public void canGetEmployeeName() {
        assertEquals("Fred", admin.getName());
    }

    @Test
    public void canGetEmployeeSSn() {
        assertEquals("AB123456C", admin.getSocialSecurityNumber());
    }

    @Test
    public void canGetEmployeeSalary() {
        assertEquals(20000.00, admin.getSalary(), 0.01);
    }

    @Test
    public void canSetEmployeeName() {
        admin.setName("Barney");
        assertEquals("Barney", admin.getName());
    }

    @Test
    public void canRaiseSalary() {
        admin.raiseSalary(5000.00);
        assertEquals(25000.00, admin.getSalary(), 0.01);
    }
}
