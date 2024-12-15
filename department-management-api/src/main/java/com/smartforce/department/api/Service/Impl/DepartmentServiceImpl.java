package com.smartforce.department.api.Service.Impl;

import com.smartforce.department.api.Model.Department;
import com.smartforce.department.api.Repository.DepartmentRepository;
import com.smartforce.department.api.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Department department, String id){
        Department exisitingDepartment = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        exisitingDepartment.setName(department.getName());
        departmentRepository.save(exisitingDepartment);
        return exisitingDepartment;
    }

    public void deleteDepartment(String id){
        departmentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        departmentRepository.deleteById(id);
    }

}
