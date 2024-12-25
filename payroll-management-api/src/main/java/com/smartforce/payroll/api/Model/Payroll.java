package com.smartforce.payroll.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "payroll")
public class Payroll {

    @Id
    private String id;
    private String pin;
    private String employeeName;
    private String month;
    private String year;
    private double basicSalary;
    private double otRate;
    private double totalSalary;
    private LocalDate paidDate;
    private String status;

    public Payroll() {
    }

    public Payroll(String id, String pin, String employeeName, String month, String year, double basicSalary, double otRate, double totalSalary, LocalDate paidDate, String status) {
        this.id = id;
        this.pin = pin;
        this.employeeName = employeeName;
        this.month = month;
        this.year = year;
        this.basicSalary = basicSalary;
        this.otRate = otRate;
        this.totalSalary = totalSalary;
        this.paidDate = paidDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getOtRate() {
        return otRate;
    }

    public void setOtRate(double otRate) {
        this.otRate = otRate;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
