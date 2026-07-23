package Week1.Thursday.CollectionsPractice.coll;

public class EmployeeNameComparator implements java.util.Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
