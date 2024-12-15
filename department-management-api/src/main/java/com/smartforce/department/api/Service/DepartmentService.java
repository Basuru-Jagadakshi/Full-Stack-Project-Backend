package com.smartforce.department.api.Service;

import com.smartforce.department.api.Model.Department;

import java.util.List;

public interface DepartmentService {

    public Department addDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department updateDepartment(Department department, String id);

    public void deleteDepartment(String id);
}
