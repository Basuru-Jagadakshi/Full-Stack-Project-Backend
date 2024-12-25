package com.smartforce.attendance.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
@Document(collection = "attendance")
public class Attendance {

    @Id
    private String id;

    private String pin;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public Attendance(String pin, LocalDateTime checkInTime){
        this.pin = pin;
        this.checkInTime = checkInTime;
    }

    public String getEmployeeId() {
        return pin;
    }

    public void setEmployeeId(String pin) {
        this.pin = pin;
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
