package com.smartforce.project.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "projects")
public class Project {

    @Id
    private String id;
    private String projectId;
    private String projectTitle;
    private String status;
    private String startDate;
    private String endDate;
    private String details;

    public Project(String id, String projectId, String projectTitle, String status, String startDate, String endDate, String details) {
        this.id = id;
        this.projectId = projectId;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
