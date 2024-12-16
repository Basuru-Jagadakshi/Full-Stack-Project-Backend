package com.smartforce.project.api.Service.Impl;

import com.smartforce.project.api.Model.Project;
import com.smartforce.project.api.Repository.ProjectRepository;
import com.smartforce.project.api.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project){
        return projectRepository.save(project);
    }

    public List<Project> getAllProject(){
        return projectRepository.findAll();
    }

    public Project updateProject(String id, Project project){
        Project existingProject = projectRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingProject.setProjectTitle(project.getProjectTitle());
        existingProject.setStartDate(project.getStartDate());
        existingProject.setEndDate(project.getEndDate());
        existingProject.setStatus(project.getStatus());
        existingProject.setDetails(project.getDetails());
        projectRepository.save(existingProject);
        return existingProject;
    }

    public void deleteProject(String id){
        projectRepository.findById(id).orElseThrow(() -> new RuntimeException());
        projectRepository.deleteById(id);
    }
}
