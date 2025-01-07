package com.smartforce.project.api.Service;

import com.smartforce.project.api.Model.Project;

import java.util.List;

public interface ProjectService {

    Project addProject(Project project);

    List<Project> getAllProject();

    List<String> getAllProjectNames();

    Project updateProject(String id, Project project);

    void deleteProject(String id);
}
