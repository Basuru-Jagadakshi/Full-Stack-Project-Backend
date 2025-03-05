package com.smartforce.leave_management_api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Document(collection = "leavings")
public class Leave {

    @Id
    private String id;
    private String employeeName;
    private String pin;
    private String leaveType;
    private LocalDate applyDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private int duration;
    private String status;

    private String year;


    public Leave(String id, String employeeName, String pin, String leaveType, LocalDate applyDate, LocalDate startDate, LocalDate endDate, String status, int duration, String year) {
        this.id = id;
        this.employeeName = employeeName;
        this.pin = pin;
        this.leaveType = leaveType;
        this.applyDate = LocalDate.now();
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = calculateDuration(startDate, endDate);
        this.status = "Pending";
        this.year=findYear(startDate);
    }


    private int calculateDuration(LocalDate startDate, LocalDate endDate){
        Period period = Period.between(startDate, endDate);
        return period.getDays() + 1;
    }

    private String findYear(LocalDate startDate){
        int year = startDate.getYear();
        return String.valueOf(year);
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(LocalDate applyDate) {
        this.applyDate = applyDate;
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
