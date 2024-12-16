package com.smartforce.employee.api.Service.Impl;

import com.smartforce.employee.api.Model.Employee;
import com.smartforce.employee.api.Model.EmployeeDisciplinary;
import com.smartforce.employee.api.Repository.EmployeeDisciplinaryRepository;
import com.smartforce.employee.api.Repository.EmployeeRepository;
import com.smartforce.employee.api.Service.EmployeeDisciplinaryService;
import com.smartforce.employee.api.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService, EmployeeDisciplinaryService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDisciplinaryRepository employeeDisciplinaryRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> findByUserType(String userType){
        List<Employee> employees = employeeRepository.findByUserType(userType);
        if(!employees.isEmpty()){
            return employees;
        }
        else {
            throw new RuntimeException();
        }
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(String id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else {
            throw new RuntimeException();
        }
    }

    public Employee updateEmployee(Employee employee, String id){
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPin(employee.getPin());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    public void deleteEmployee(String id){
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException());
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeType(String id, String userType){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setUserType(userType);
            return employeeRepository.save(employee);
        }
        else {
            throw new RuntimeException();
        }
    }

    //Employee disciplinary

    public EmployeeDisciplinary saveEmployeeDisciplinary(EmployeeDisciplinary employeeDisciplinary){
        return employeeDisciplinaryRepository.save(employeeDisciplinary);
    }

    public List<EmployeeDisciplinary> getAllEmployeeDisciplinary(){
        return employeeDisciplinaryRepository.findAll();
    }

    public EmployeeDisciplinary updateEmployeeDisciplinary(EmployeeDisciplinary employeeDisciplinary, String id){
        EmployeeDisciplinary existingEmployeeDisciplinary = employeeDisciplinaryRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingEmployeeDisciplinary.setName(employeeDisciplinary.getName());
        existingEmployeeDisciplinary.setPin(employeeDisciplinary.getPin());
        existingEmployeeDisciplinary.setTitle(employeeDisciplinary.getTitle());
        existingEmployeeDisciplinary.setDescription(employeeDisciplinary.getDescription());
        existingEmployeeDisciplinary.setStatus(employeeDisciplinary.getStatus());
        employeeDisciplinaryRepository.save(existingEmployeeDisciplinary);
        return existingEmployeeDisciplinary;
    }

    public void deleteEmployeeDisciplinary(String id){
        employeeDisciplinaryRepository.findById(id).orElseThrow(() -> new RuntimeException());
        employeeDisciplinaryRepository.deleteById(id);
    }
}
