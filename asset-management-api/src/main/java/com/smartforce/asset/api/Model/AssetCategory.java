package com.smartforce.asset.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asset_categories")
public class AssetCategory {

    @Id
    private String id;
    private String categoryName;
    private String description; // Optional for user guidance

    // Constructors
    public AssetCategory() {}

    public AssetCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getCategoryName() { return categoryName; }
    public String getDescription() { return description; }

    public void setId(String id) { this.id = id; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setDescription(String description) { this.description = description; }
}
