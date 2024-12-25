package com.smartforce.task.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String projectTitle;
    private ArrayList<String> assignedEmployees;
    private String taskTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    private String details;
    private String status;

    public Task(String id, String projectTitle, ArrayList<String> assignedEmployees, String taskTitle, LocalDate startDate, LocalDate endDate, String details, String status) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.assignedEmployees = assignedEmployees;
        this.taskTitle = taskTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.details = details;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public ArrayList<String> getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(ArrayList<String> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
