package com.smartforce.department.api.Controller;

import com.smartforce.department.api.Model.Department;
import com.smartforce.department.api.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin("*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.addDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable("id") String id){
        return new ResponseEntity<Department>(departmentService.updateDepartment(department, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") String id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<String>("Department is deleted successfully", HttpStatus.OK);
    }
}
