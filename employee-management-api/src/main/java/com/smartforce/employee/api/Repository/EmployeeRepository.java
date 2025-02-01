package com.smartforce.employee.api.Repository;

import com.smartforce.employee.api.Model.Employee;
import com.smartforce.employee.api.ResponseDTO.EmployeeResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByUserType(String userType);

    List<Employee> findByDepartment(String department);

    Optional<Employee> findByPin(String pin);
}
