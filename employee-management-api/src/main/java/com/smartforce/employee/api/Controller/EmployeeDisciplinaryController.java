package com.smartforce.employee.api.Controller;

import com.smartforce.employee.api.Model.EmployeeDisciplinary;
import com.smartforce.employee.api.Service.EmployeeDisciplinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeDisciplinary")
@CrossOrigin("*")
public class EmployeeDisciplinaryController {

    @Autowired
    private EmployeeDisciplinaryService employeeDisciplinaryService;

    @PostMapping
    public ResponseEntity<EmployeeDisciplinary> saveEmployeeDisciplinary(@RequestBody EmployeeDisciplinary employeeDisciplinary){
        return new ResponseEntity<EmployeeDisciplinary>(employeeDisciplinaryService.saveEmployeeDisciplinary(employeeDisciplinary), HttpStatus.CREATED);
    }

    @GetMapping
    public List<EmployeeDisciplinary> getAllEmployeeDisciplinary(){
        return employeeDisciplinaryService.getAllEmployeeDisciplinary();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDisciplinary> updateEmployeeDisciplinary(@RequestBody EmployeeDisciplinary employeeDisciplinary, @PathVariable("id") String id){
        return new ResponseEntity<EmployeeDisciplinary>(employeeDisciplinaryService.updateEmployeeDisciplinary(employeeDisciplinary, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeDisciplinary(@PathVariable String id){
        employeeDisciplinaryService.deleteEmployeeDisciplinary(id);
        return new ResponseEntity<String>("Employee disciplinary is deleted", HttpStatus.OK);
    }
}
