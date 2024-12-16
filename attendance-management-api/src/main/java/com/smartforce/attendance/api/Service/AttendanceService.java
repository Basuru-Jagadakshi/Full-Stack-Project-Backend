package com.smartforce.attendance.api.Service;

import com.smartforce.attendance.api.Model.Attendance;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceService {

    public Attendance saveCheckInTime(String employeeId);
    public Attendance saveCheckOutTime(String attendanceId);
    public List<Attendance> getAttendanceByEmployeeAndDate(String employeeId, LocalDateTime startDate, LocalDateTime endDate);
}
