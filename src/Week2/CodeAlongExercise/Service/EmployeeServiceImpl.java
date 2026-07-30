package Week2.CodeAlongExercise.Service;

import week2.Wedensday.CodeAlongExercise.DAO.EmployeeDAO;
import week2.Wedensday.CodeAlongExercise.DAO.EmployeeDAOImpl;
import week2.Wedensday.CodeAlongExercise.Service.EmployeeService;
import week2.Wedensday.CodeAlongExercise.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void createEmployee(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        if (employee.getName() == null ||
                employee.getName().isEmpty() ||
                employee.getSalary() < 0) {

            throw new IllegalArgumentException("Invalid employee data");
        }

        employeeDAO.createEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        if (employee.getName() == null || employee.getName().isEmpty() || employee.getSalary() < 0) {
            throw new IllegalArgumentException("Invalid employee data");
        }
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public Employee findById(int id) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        return employeeDAO.findAll();
    }
}

