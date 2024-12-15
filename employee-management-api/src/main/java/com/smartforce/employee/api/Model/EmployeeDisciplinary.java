package com.smartforce.employee.api.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "employee_disciplinary")
public class EmployeeDisciplinary {

    @Id
    private String id;
    private String employeeId;

    private String name;
    private int pin;

    private String title;
    private String description;
    private String status;
}
