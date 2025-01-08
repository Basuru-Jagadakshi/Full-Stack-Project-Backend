package com.smartforce.task.api.Service.Impl;

import com.smartforce.task.api.Model.Task;
import com.smartforce.task.api.Repository.TaskRepository;
import com.smartforce.task.api.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task updateTask(String id, Task task){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingTask.setProjectTitle(task.getProjectTitle());
        existingTask.setAssignedEmployees(task.getAssignedEmployees());
        existingTask.setTaskTitle(task.getTaskTitle());
        existingTask.setStartDate(task.getStartDate());
        existingTask.setEndDate(task.getEndDate());
        existingTask.setDetails(task.getDetails());
        existingTask.setStatus(task.getStatus());

        taskRepository.save(existingTask);
        return existingTask;
    }

    public void deleteTask(String id){
        taskRepository.findById(id).orElseThrow(() -> new RuntimeException());
        taskRepository.deleteById(id);
    }

    public Task changeStatus(String id, String status){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingTask.setStatus(status);
        taskRepository.save(existingTask);
        return existingTask;
    }

    @Override
    public List<Task> findByProjectTitle(String projectTitle) {
        return taskRepository.findByProjectTitle(projectTitle);
    }
}
