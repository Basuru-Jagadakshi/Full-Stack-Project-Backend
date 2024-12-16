package com.smartforce.employee.api.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    private String name;
    private short pin;
    private String email;
    private String userType;

    public Employee(String id, String name, short pin, String email, String userType) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.email = email;
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

    public short getPin() {
        return pin;
    }

    public void setPin(short pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
