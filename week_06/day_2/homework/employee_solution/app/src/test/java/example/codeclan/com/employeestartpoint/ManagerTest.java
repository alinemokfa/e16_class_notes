package example.codeclan.com.employeestartpoint;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ManagerTest {
    Manager manager;

    @Before
    public void before() {
        manager = new Manager(1, "Wilma", "AB123456C", 30000.00, "IT" );
    }

    @Test
    public void canGetManagerDepartmentName() {
        assertEquals("IT", manager.getDepartmentName());
    }

    @Test
    public void canGetManagerId() {
        assertEquals(1, manager.getId());
    }

    @Test
    public void canGetManagerName() {
        assertEquals("Wilma", manager.getName());
    }

    @Test
    public void canGetManagerSSn() {
        assertEquals("AB123456C", manager.getSocialSecurityNumber());
    }

    @Test
    public void canGetManagerSalary() {
        assertEquals(30000.00, manager.getSalary(), 0.01);
    }

    @Test
    public void canSetManagerName() {
        manager.setName("Betty");
        assertEquals("Betty", manager.getName());
    }

    @Test
    public void canRaiseSalary() {
        manager.raiseSalary(5000.00);
        assertEquals(35000.00, manager.getSalary(), 0.01);
    }

}
