package com.smartforce.leave_management_api.DTO.Request;

public class GetLeavesByPinAndYear {

    private String pin;
    private String year;

    public GetLeavesByPinAndYear(String pin, String year) {
        this.pin = pin;
        this.year = year;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
