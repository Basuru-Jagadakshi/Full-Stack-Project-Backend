package com.smartforce.department.api.Repository;

import com.smartforce.department.api.Model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    Department findAllById(String id);
}
