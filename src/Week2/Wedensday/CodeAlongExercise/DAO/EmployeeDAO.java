package Week2.Wedensday.CodeAlongExercise.DAO;

import Week2.Wedensday.CodeAlongExercise.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);


    Employee findById(int id);
    List<Employee> findAll();
}
