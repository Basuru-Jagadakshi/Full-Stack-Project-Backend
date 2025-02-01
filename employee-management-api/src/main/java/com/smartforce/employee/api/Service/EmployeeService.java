package com.smartforce.employee.api.Service;

import com.smartforce.employee.api.Model.Employee;
import com.smartforce.employee.api.ResponseDTO.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    List<Employee> findByUserType(String userType);

    Employee addEmployee(Employee employee);

    Employee getEmployeeById(String id);

    Employee updateEmployee(Employee employee, String id);

    void deleteEmployee(String id);

    Employee updateEmployeeType(String id, String userType);

    List<Employee> findByDepartment(String department);

    EmployeeResponse findByPin(String pin);
}
