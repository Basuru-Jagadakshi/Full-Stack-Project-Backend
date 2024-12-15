package com.smartforce.department.api.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "designation")
public class Designation {

    @Id
    private String id;
    private String name;
}
