package com.smartforce.employee.api.Repository;

import com.smartforce.employee.api.Model.EmployeeDisciplinary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeDisciplinaryRepository extends MongoRepository<EmployeeDisciplinary, String> {
}
