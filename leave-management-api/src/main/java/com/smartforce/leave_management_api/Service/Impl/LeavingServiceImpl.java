package com.smartforce.leave_management_api.Service.Impl;

import com.smartforce.leave_management_api.Model.Leave;
import com.smartforce.leave_management_api.Repository.LeaveRepository;
import com.smartforce.leave_management_api.Service.LeavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LeavingServiceImpl implements LeavingService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Leave> getAllLeaves(){
        return leaveRepository.findAll();
    }

    public Leave addLeave(Leave leave){
        return leaveRepository.save(leave);
    }

    public Leave updateLeave(Leave leave, String id){
        Leave existingLeave = leaveRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingLeave.setEmployeeName(leave.getEmployeeName());
        existingLeave.setLeaveType(leave.getLeaveType());
        existingLeave.setPin(leave.getPin());
        existingLeave.setApplyDate(leave.getApplyDate());
        existingLeave.setStartDate(leave.getStartDate());
        existingLeave.setEndDate(leave.getEndDate());
        leaveRepository.save(existingLeave);
        return existingLeave;
    }

    public void deleteLeave(String id){
        leaveRepository.findById(id).orElseThrow(() -> new RuntimeException());
        leaveRepository.deleteById(id);
    }

    public List<Leave> getLeavesByEmployeeNameAndStatus(String employeeName, LocalDateTime startDate, LocalDateTime endDate, String status){
        return leaveRepository.findByEmployeeNameAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndStatus(employeeName,startDate,endDate,status);
    }


    public Leave approveLeaveRequest(String id){
        Leave leave = leaveRepository.findById(id).orElseThrow(() -> new RuntimeException());
        leave.setStatus("Approved");
        return leaveRepository.save(leave);
    }

    @Override
    public List<Leave> findByStatus(String status) {
        return leaveRepository.findByStatus(status);
    }

    @Override
    public List<Leave> findByPinAndYear(String pin, String year) {
        return leaveRepository.findByPinAndYear(pin, year);
    }
}
