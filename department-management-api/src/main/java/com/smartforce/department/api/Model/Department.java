package com.smartforce.department.api.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "departments")
public class Department {

    @Id
    private String id;
    private String name;
}
