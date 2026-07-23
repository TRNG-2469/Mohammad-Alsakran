package Week1.Thursday.CollectionsPractice.coll;

public class EmployeeSalaryComparator implements java.util.Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}
