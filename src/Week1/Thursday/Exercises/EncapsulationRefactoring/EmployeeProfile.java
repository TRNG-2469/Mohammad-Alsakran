package Week1.Thursday.Exercises.EncapsulationRefactoring;

public class EmployeeProfile {
    private String employeeId;
    private String name;
    private double monthlySalary;

    public EmployeeProfile(String employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.monthlySalary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name!=null && name!=""){
            this.name = name;
        }
        else {
            System.out.println("Name cannot be empty or null");
        }
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if(monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        }
        else {
            System.out.println("Monthly salary must be a positive value");
        }
    }
}