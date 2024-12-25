package com.smartforce.attendance.api.Service;

import com.smartforce.attendance.api.Model.Attendance;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceService {

    public Attendance saveCheckInTime(String employeeId);
    public Attendance saveCheckOutTime(String attendanceId);
    public List<Attendance> getAttendanceByEmployeeAndDate(String pin, LocalDateTime startDate, LocalDateTime endDate);

    List<Attendance> getAttendanceByEmployeeAndMonthAndYear(String pin, String monthString, String yearString);
}
