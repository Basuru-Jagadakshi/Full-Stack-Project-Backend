package com.smartforce.employee.api.Controller;

import com.smartforce.employee.api.Model.Employee;
import com.smartforce.employee.api.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/userType/{userType}")
    public List<Employee> findByUserType(@PathVariable("userType") String userType){
        return employeeService.findByUserType(userType);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") String id){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee record is deleted", HttpStatus.OK);
    }

    @PatchMapping("changeType/{id}")
    public ResponseEntity<String> changeEmployeeType(@PathVariable("id") String id, @RequestParam String userType){
        employeeService.updateEmployeeType(id, userType);
        return new ResponseEntity<String>("Changed type!!!", HttpStatus.OK);
    }

    @GetMapping(value = "/department/{department}/employee")
    public List<Employee> findByDepartment(@PathVariable String department){
        return employeeService.findByDepartment(department);
    }
}
