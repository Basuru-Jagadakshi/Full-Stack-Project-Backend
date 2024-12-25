package com.smartforce.payroll.api.Service;

import com.smartforce.payroll.api.Model.Payroll;
import com.smartforce.payroll.api.Response.AttendanceResponse;
import com.smartforce.payroll.api.Response.EmployeeResponse;

import java.util.List;

public interface PayrollService {

    Payroll addPayroll(Payroll payroll);

    List<Payroll> getPayrollByPin(String pin);

    List<Payroll> getPayrollByMonth(String month);

    List<Payroll> getPayrollByMonthAndYear(String month, String year);

    List<Payroll> getPayrollByMonthAndYearAndDepartment(String month, String year, String department);

    List<Payroll> createPayroll(String month, String year, String department);

    List<Payroll> confirmPayment(String month, String year, String department);
}
