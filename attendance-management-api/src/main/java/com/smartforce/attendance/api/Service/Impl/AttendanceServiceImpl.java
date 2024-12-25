package com.smartforce.attendance.api.Service.Impl;

import com.smartforce.attendance.api.Model.Attendance;
import com.smartforce.attendance.api.Repository.AttendanceRepository;
import com.smartforce.attendance.api.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.Locale;
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

    public List<Attendance> getAttendanceByEmployeeAndDate(String pin, LocalDateTime startDate, LocalDateTime endDate){
        return attendanceRepository.findByPinAndCheckInTimeBetween(pin, startDate, endDate);
    }

    @Override
    public List<Attendance> getAttendanceByEmployeeAndMonthAndYear(String pin, String monthString, String yearString) {
        int year = Integer.parseInt(yearString);

        Month month = Month.valueOf(monthString.toUpperCase(Locale.ENGLISH));

        LocalDateTime startOfMonth = YearMonth.of(year, month.getValue()).atDay(1).atStartOfDay();
        LocalDateTime endOfMonth = YearMonth.of(year, month.getValue()).atEndOfMonth().atTime(23, 59, 59);

        return attendanceRepository.findByPinAndCheckInTimeBetween(pin, startOfMonth, endOfMonth);
    }
}
