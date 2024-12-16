package com.smartforce.project.api.Repository;

import com.smartforce.project.api.Model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
