package com.smartforce.leave_management_api.Service;

import com.smartforce.leave_management_api.Model.Leave;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LeavingService {

    List<Leave> getAllLeaves();

    Leave addLeave(Leave leave);

    Leave updateLeave(Leave leave, String id);

    void deleteLeave(String id);

    List<Leave> getLeavesByEmployeeNameAndStatus(String employeeName, LocalDateTime startDate, LocalDateTime endDate, String status);

    Leave approveLeaveRequest(String id);
}
