package Week2.CodeAlongExercise.DAO;

import week2.Wedensday.CodeAlongExercise.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);


    Employee findById(int id);
    List<Employee> findAll();
}
