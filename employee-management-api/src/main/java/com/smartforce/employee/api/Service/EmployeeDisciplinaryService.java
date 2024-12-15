package com.smartforce.employee.api.Service;

import com.smartforce.employee.api.Model.EmployeeDisciplinary;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeDisciplinaryService {

    EmployeeDisciplinary saveEmployeeDisciplinary(EmployeeDisciplinary employeeDisciplinary);

    List<EmployeeDisciplinary> getAllEmployeeDisciplinary();

    EmployeeDisciplinary updateEmployeeDisciplinary(EmployeeDisciplinary employeeDisciplinary, String id);

    void deleteEmployeeDisciplinary(String id);
}
