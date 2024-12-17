package com.smartforce.leave_management_api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "leavings")
public class Leave {

    @Id
    private String id;
    private String employeeName;
    private int pin;
    private String leaveType;
    private LocalDateTime applyDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int duration;
    private String status;


    public Leave(String id, String employeeName, int pin, String leaveType, LocalDateTime applyDate, LocalDateTime startDate, LocalDateTime endDate, int duration, String status) {
        this.id = id;
        this.employeeName = employeeName;
        this.pin = pin;
        this.leaveType = leaveType;
        this.applyDate = applyDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = calculateDuration(startDate, endDate);
        this.status = status;
    }


    private int calculateDuration(LocalDateTime startDate, LocalDateTime endDate){
        Duration duration = Duration.between(startDate, endDate);
        return (int) duration.toDays() + 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDateTime getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(LocalDateTime applyDate) {
        this.applyDate = applyDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
