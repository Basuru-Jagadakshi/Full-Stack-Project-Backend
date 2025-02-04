package com.smartforce.project.api.Repository;

import com.smartforce.project.api.Model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {

    List<Project> getProjectsByStatus(String status);
}
