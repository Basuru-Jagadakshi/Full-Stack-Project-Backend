package com.smartforce.payroll.api.Response;

import org.springframework.data.annotation.Id;

public class DesignationResponse {
    private String id;
    private String designationName;
    private Double basicSalary;

    public DesignationResponse(String id, String designationName, Double basicSalary) {
        this.id = id;
        this.designationName = designationName;
        this.basicSalary = basicSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }
}
