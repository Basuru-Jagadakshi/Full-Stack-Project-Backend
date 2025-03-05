package com.smartforce.leave_management_api.Repository;

import com.smartforce.leave_management_api.Model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LeaveRepository extends MongoRepository<Leave, String> {

    List<Leave> findByEmployeeNameAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndStatus(
            String employeeName, LocalDateTime startDate, LocalDateTime endDate, String status
    );

    List<Leave> findByStatus(String status);

    List<Leave> findByPinAndYear(String pin, String year);
}
