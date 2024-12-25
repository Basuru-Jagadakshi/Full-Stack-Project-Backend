package com.smartforce.payroll.api.Response;

public class EmployeeResponse {

    private String id;
    private String name;
    private String pin;
    private String email;
    private String department;
    private String designation;
    private String userType;

    public EmployeeResponse(String id, String name, String pin, String email, String department, String designation, String userType) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
