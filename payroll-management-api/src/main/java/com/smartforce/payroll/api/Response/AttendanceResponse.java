package com.smartforce.payroll.api.Response;

import java.time.LocalDateTime;

public class AttendanceResponse {

    private String id;
    private String employeeId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public AttendanceResponse(String employeeId, LocalDateTime checkInTime){
        this.employeeId = employeeId;
        this.checkInTime = checkInTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
