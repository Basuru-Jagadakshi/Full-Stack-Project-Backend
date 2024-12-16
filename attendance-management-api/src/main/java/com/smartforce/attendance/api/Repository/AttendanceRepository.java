package com.smartforce.attendance.api.Repository;

import com.smartforce.attendance.api.Model.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {

    List<Attendance> findByEmployeeIdAndCheckInTimeBetween(String employeeId, LocalDateTime startDate, LocalDateTime endDate);
}
