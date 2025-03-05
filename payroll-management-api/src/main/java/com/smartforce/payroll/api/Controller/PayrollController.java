package com.smartforce.payroll.api.Controller;

import com.smartforce.payroll.api.Model.Payroll;
import com.smartforce.payroll.api.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "/api/payrolls")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;


    @PostMapping
    public ResponseEntity<Payroll> addPayroll(@RequestBody Payroll payroll){
        return new ResponseEntity<Payroll>(payrollService.addPayroll(payroll), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{pin}")
    public List<Payroll> getPayrollByPin(@PathVariable String pin){
        return payrollService.getPayrollByPin(pin);
    }

    @GetMapping(value = "/{month}")
    public List<Payroll> getPayrollByMonth(@PathVariable String month){
        return payrollService.getPayrollByMonth(month);
    }

    @GetMapping(value = "/month/{month}/year/{year}/employee-department/{department}")
    public List<Payroll> getPayrollByMonthAndYearAndDepartment(@PathVariable String month, @PathVariable String year, @PathVariable String department){
        return payrollService.getPayrollByMonthAndYearAndDepartment(month, year, department);
    }

    @PostMapping(value = "/month/{month}/year/{year}/department/{department}")
    public ResponseEntity<List<Payroll>> createPayroll(@PathVariable String month, @PathVariable String year, @PathVariable String department){
        return new ResponseEntity<List<Payroll>>(payrollService.createPayroll(month, year, department), HttpStatus.CREATED);
    }

    @PutMapping(value = "update-status/month/{month}/year/{year}/department/{department}")
    public ResponseEntity<List<Payroll>> confirmPayment(@PathVariable String month, @PathVariable String year, @PathVariable String department){
        return new ResponseEntity<List<Payroll>>(payrollService.confirmPayment(month, year, department), HttpStatus.OK);
    }
}
