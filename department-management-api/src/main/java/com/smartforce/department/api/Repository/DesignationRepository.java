package com.smartforce.department.api.Repository;

import com.smartforce.department.api.Model.Designation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends MongoRepository<Designation, String> {
}
