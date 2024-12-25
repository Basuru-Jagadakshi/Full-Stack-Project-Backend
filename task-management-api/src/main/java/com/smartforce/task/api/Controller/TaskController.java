package com.smartforce.task.api.Controller;

import com.smartforce.task.api.Model.Task;
import com.smartforce.task.api.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/task")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return new ResponseEntity<Task>(taskService.addTask(task), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping(value = "/update-task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task task){
        return new ResponseEntity<Task>(taskService.updateTask(id, task), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
        return new ResponseEntity<String>("Task is successfully deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/change-status/{id}")
    public ResponseEntity<Task> changeStatus(@PathVariable String id, @RequestParam String status){
        return new ResponseEntity<Task>(taskService.changeStatus(id, status), HttpStatus.OK);
    }
}
