package example.codeclan.com.employeestartpoint;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DirectorTest {

    Director director;

    @Before
    public void before() {
        director = new Director(1, "Wilma", "AB123456C", 90000.00, "IT", 1000000.00 );
    }

    @Test
    public void canGetDirectorDepartmentName() {
        assertEquals("IT", director.getDepartmentName());
    }

    @Test
    public void canGetDirectorId() {
        assertEquals(1, director.getId());
    }

    @Test
    public void canGetDirectorName() {
        assertEquals("Wilma", director.getName());
    }

    @Test
    public void canGetDirectorSSn() {
        assertEquals("AB123456C", director.getSocialSecurityNumber());
    }

    @Test
    public void canGetDirectorSalary() {
        assertEquals(90000.00, director.getSalary(), 0.01);
    }

    @Test
    public void canSetDirectorName() {
        director.setName("Betty");
        assertEquals("Betty", director.getName());
    }

    @Test
    public void canRaiseSalary() {
        director.raiseSalary(10000.00);
        assertEquals(100000.00, director.getSalary(), 0.01);
    }
}
