package Week2.Wedensday.CodeAlongExercise.Service;

import Week2.Wedensday.CodeAlongExercise.model.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);


    Employee findById(int id);
    List<Employee> findAll();
}
