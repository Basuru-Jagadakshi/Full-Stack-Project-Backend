package com.smartforce.employee.api.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    private String name;
    private short pin;
    private String email;
    private String userType;
}
