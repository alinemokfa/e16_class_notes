package example.codeclan.com.employeestartpoint;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class EmployeeTest {
    Employee employee;

    @Before
    public void before() {
        employee = new Employee(1, "Wilma", "AB123456C", 30000.00 );
    }

    @Test
    public void canGetEmployeeId() {
        assertEquals(1, employee.getId());
    }

    @Test
    public void canGetEmployeeName() {
        assertEquals("Wilma", employee.getName());
    }

    @Test
    public void canGetEmployeeSSn() {
        assertEquals("AB123456C", employee.getSocialSecurityNumber());
    }

    @Test
    public void canGetEmployeeSalary() {
        assertEquals(30000.00, employee.getSalary(), 0.01);
    }

    @Test
    public void canSetEmployeeName() {
        employee.setName("Betty");
        assertEquals("Betty", employee.getName());
    }

    @Test
    public void canRaiseSalary() {
        employee.raiseSalary(5000.00);
        assertEquals(35000.00, employee.getSalary(), 0.01);
    }

    @Test
    public void cannotRaiseSalaryByNegativeAmount() {
        employee.raiseSalary(-5000.00);
        assertEquals(30000.00, employee.getSalary(), 0.01);
    }

    @Test
    public void cannotSetEmployeeNameWithNull() {
        employee.setName(null);
        assertEquals("Wilma", employee.getName());
    }

    @Test
    public void cannotSetEmployeeNameWithEmptyString() {
        employee.setName("");
        assertEquals("Wilma", employee.getName());
    }
}
