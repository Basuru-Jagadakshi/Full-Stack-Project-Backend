package com.smartforce.project.api.Controller;

import com.smartforce.project.api.Model.Project;
import com.smartforce.project.api.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        return new ResponseEntity<Project>(projectService.addProject(project), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Project> getAllProject(){
        return projectService.getAllProject();
    }

    @PutMapping(value = "/update-project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable String id, @RequestBody Project project){
        return new ResponseEntity<Project>(projectService.updateProject(id, project), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-project/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable String id){
        projectService.deleteProject(id);
        return new ResponseEntity<String>("Project record is successfully deleted!", HttpStatus.OK);
    }
}