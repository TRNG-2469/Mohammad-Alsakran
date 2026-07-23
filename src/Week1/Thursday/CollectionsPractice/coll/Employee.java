package Week1.Thursday.CollectionsPractice.coll;

public class Employee implements Comparable<Employee> {
    private int Id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        Id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return Id;
    }

    public void setEmployeeId(int employeeId) {
        this.Id = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }



    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.Id, o.Id);
    }


}
