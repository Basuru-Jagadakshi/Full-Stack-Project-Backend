package com.smartforce.task.api.Service;

import com.smartforce.task.api.Model.Task;

import java.util.List;

public interface TaskService {

    Task addTask(Task task);

    List<Task> getAllTasks();

    Task updateTask(String id, Task task);

    void deleteTask(String id);

    Task changeStatus(String id, String status);

    List<Task> findByProjectTitle(String projectTitle);
}
