package com.smartforce.attendance.api.Service.Impl;

import com.smartforce.attendance.api.Model.Attendance;
import com.smartforce.attendance.api.Repository.AttendanceRepository;
import com.smartforce.attendance.api.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveCheckInTime(String employeeId){
        Attendance attendance = new Attendance(employeeId, LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }

    public Attendance saveCheckOutTime(String attendanceId){
        Attendance attendance = attendanceRepository.findById(attendanceId).orElseThrow(() -> new RuntimeException("Attendance record not found"));
        attendance.setCheckOutTime(LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByEmployeeAndDate(String employeeId, LocalDateTime startDate, LocalDateTime endDate){
        return attendanceRepository.findByEmployeeIdAndCheckInTimeBetween(employeeId, startDate, endDate);
    }
}
