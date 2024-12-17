package com.smartforce.leave_management_api.Controller;

import com.smartforce.leave_management_api.Model.Leave;
import com.smartforce.leave_management_api.Service.LeavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/leave")
@CrossOrigin("*")
public class LeaveController {

    @Autowired
    private LeavingService leavingService;

    @GetMapping
    public List<Leave> getAllLeave(){
        return leavingService.getAllLeaves();
    }

    @PostMapping
    public ResponseEntity<Leave> addLeave(@RequestBody Leave leave){
        return new ResponseEntity<Leave>(leavingService.addLeave(leave), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Leave> updateLeave(@RequestBody Leave leave, @PathVariable("id") String id){
        return new ResponseEntity<Leave>(leavingService.updateLeave(leave,id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteLeave(@PathVariable("id") String id){
        leavingService.deleteLeave(id);
        return new ResponseEntity<String>("Leave record is successfully deleted.", HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public List<Leave> getLeavesByEmployeeNameAndStatus(@RequestParam String employeeName, @RequestParam String startDate, @RequestParam String endDate, @RequestParam(defaultValue = "Approved") String status){
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return leavingService.getLeavesByEmployeeNameAndStatus(employeeName, start, end, status);
    }

    @PutMapping(value = "/update-status/{id}")
    public Leave approveLeaveRequest(@PathVariable String id){
        return leavingService.approveLeaveRequest(id);
    }
}
