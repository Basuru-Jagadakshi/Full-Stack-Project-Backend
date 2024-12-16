package com.smartforce.project.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "projects")
public class Project {

    @Id
    private String id;
    private String projectTitle;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String details;

    public Project(String id, String projectTitle, String status, LocalDate startDate, LocalDate endDate, String details) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.details = details;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
