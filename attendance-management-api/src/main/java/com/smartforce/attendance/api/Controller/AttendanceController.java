package com.smartforce.attendance.api.Controller;

import com.smartforce.attendance.api.Model.Attendance;
import com.smartforce.attendance.api.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(value = "*")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/check-in/{employeeId}")
    public Attendance checkIn(@PathVariable String employeeId){
        return attendanceService.saveCheckInTime(employeeId);
    }

    @PutMapping("/check-out/{attendanceId}")
    public Attendance checkOut(@PathVariable String attendanceId){
        return attendanceService.saveCheckOutTime(attendanceId);
    }


    @GetMapping("/records/{employeeId}")
    public List<Attendance> getAttendanceRecords(@PathVariable String employeeId, @RequestParam String startDate, @RequestParam String endDate){
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return attendanceService.getAttendanceByEmployeeAndDate(employeeId, start, end);
    }

    @GetMapping(value = "employee-pin/{pin}/month/{monthString}/year/{yearString}")
    public List<Attendance> getAttendanceByEmployeeAndMonthAndYear(@PathVariable String pin, @PathVariable String monthString, @PathVariable String yearString){
        return attendanceService.getAttendanceByEmployeeAndMonthAndYear(pin, monthString, yearString);
    }
}
