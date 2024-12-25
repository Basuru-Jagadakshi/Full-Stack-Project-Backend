package com.smartforce.payroll.api.Service.Impl;

import com.smartforce.payroll.api.Model.Payroll;
import com.smartforce.payroll.api.Repository.PayrollRepository;
import com.smartforce.payroll.api.Response.AttendanceResponse;
import com.smartforce.payroll.api.Response.DesignationResponse;
import com.smartforce.payroll.api.Response.EmployeeResponse;
import com.smartforce.payroll.api.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PayrollRepository payrollRepository;

    private static final String EMPLOYEE_SERVICE_URL = "http://localhost:8080/api/employee/";
    private static final String ATTENDANCE_SERVICE_URL = "http://localhost:8082/api/attendance/";
    private static final String DESIGNATION_SERVICE_URL = "http://localhost:8083/api/designation/";


    public Payroll addPayroll(Payroll payroll){
        return payrollRepository.save(payroll);
    }

    public List<Payroll> getPayrollByPin(String pin){
        return payrollRepository.findByPin(pin);
    }

    @Override
    public List<Payroll> getPayrollByMonth(String month) {
        return payrollRepository.findByMonth(month);
    }

    @Override
    public List<Payroll> getPayrollByMonthAndYear(String month, String year) {
        return payrollRepository.findByMonthAndYear(month, year);
    }

    @Override
    public List<Payroll> getPayrollByMonthAndYearAndDepartment(String month, String year, String department) {

        EmployeeResponse[] employeeResponse = restTemplate.getForObject(EMPLOYEE_SERVICE_URL + "/department/"+department + "/employee", EmployeeResponse[].class);

        List<Payroll> payrollsAccordingToMonth = payrollRepository.findByMonthAndYear(month, year);

        ArrayList<Payroll> payrollsAccordingToMonthAndDepartment = new ArrayList<Payroll>();

        for(EmployeeResponse employee : employeeResponse){
            for (Payroll payroll : payrollsAccordingToMonth){
                if (employee.getPin().equals(payroll.getPin())){
                    payrollsAccordingToMonthAndDepartment.add(payroll);
                }
            }
        }

        if(payrollsAccordingToMonthAndDepartment.size() == 0){

        }
        return payrollsAccordingToMonthAndDepartment;
    }


    public List<Payroll> createPayroll(String month, String year, String department){

        ArrayList<Payroll> newPayrolls = new ArrayList<Payroll>();

        EmployeeResponse[] employeeResponse = restTemplate.getForObject(EMPLOYEE_SERVICE_URL + "department/"+department + "/employee", EmployeeResponse[].class);

        for (EmployeeResponse employee : employeeResponse){

            AttendanceResponse[] attendanceResponses = restTemplate.getForObject(ATTENDANCE_SERVICE_URL + "/employee-pin/" + employee.getPin() + "/month/" + month + "/year/" + year, AttendanceResponse[].class);

            DesignationResponse designationResponse = restTemplate.getForObject(DESIGNATION_SERVICE_URL + employee.getDesignation() + "/basic-salary", DesignationResponse.class);

            double totalSalary = designationResponse.getBasicSalary() + calculateOverTime(attendanceResponses);

            Payroll payroll = new Payroll();

            payroll.setPin(employee.getPin());
            payroll.setEmployeeName(employee.getName());
            payroll.setMonth(month);
            payroll.setYear(year);
            payroll.setBasicSalary(designationResponse.getBasicSalary());
            payroll.setOtRate(300);
            payroll.setTotalSalary(totalSalary);
            payroll.setPaidDate(LocalDate.now());
            payroll.setStatus("Pending");

            newPayrolls.add(payroll);
        }

        return payrollRepository.saveAll(newPayrolls);
    }

    private double calculateOverTime(AttendanceResponse[] attendanceResponses){
        double totalHours = 0;
        for (AttendanceResponse attendanceResponse : attendanceResponses){
            totalHours += Duration.between(attendanceResponse.getCheckInTime(), attendanceResponse.getCheckOutTime()).toHours();
        }

        double overTimeSalary = totalHours > 160 ? (totalHours - 160) * 300 : 0;

        return overTimeSalary;
    }


    public List<Payroll> confirmPayment(String month, String year, String department){

        List<Payroll> payrolls = getPayrollByMonthAndYearAndDepartment(month, year, department);

        for (Payroll payroll : payrolls){
            payroll.setStatus("Paid");
        }

        return payrollRepository.saveAll(payrolls);
    }
}
