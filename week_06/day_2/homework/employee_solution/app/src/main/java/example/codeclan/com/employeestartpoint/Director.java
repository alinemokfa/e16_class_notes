package example.codeclan.com.employeestartpoint;


public class Director extends Manager {

    private double budget;

    public Director(int id, String name, String socialSecurityNumber, double salary, String departmentName, double budget) {
        super(id, name, socialSecurityNumber, salary, departmentName);
        this.budget = budget;
    }

    public double getBudget() {
        return this.budget;
    }
}
