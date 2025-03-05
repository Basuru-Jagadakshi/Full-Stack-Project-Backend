package com.smartforce.asset.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "assets")
public class Asset {

    @Id
    private String id;
    private String assetName;
    private int quantity;
    private String type;
    private String departmentName; // New field
    private String categoryName; // New field

    // Constructors
    public Asset() {}

    public Asset(String assetName, int quantity, String type, String departmentName, String categoryName) {
        this.assetName = assetName;
        this.quantity = quantity;
        this.type = type;
        this.departmentName = departmentName;
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getAssetName() { return assetName; }
    public int getQuantity() { return quantity; }
    public String getType() { return type; }
    public String getDepartmentName() { return departmentName; }
    public String getCategoryName() { return categoryName; }

    public void setId(String id) { this.id = id; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setType(String type) { this.type = type; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
