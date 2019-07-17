package example.codeclan.com.employeestartpoint;

/**
 * Created by sandy on 13/10/2017.
 */

public class Manager extends Employee {

    private String departmentName;

    public Manager(int id, String name, String socialSecurityNumber, double salary, String departmentName) {
        super(id, name, socialSecurityNumber, salary);
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }
}
