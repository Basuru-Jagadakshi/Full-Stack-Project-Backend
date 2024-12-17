package com.smartforce.asset.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Assets")
public class Asset {

    @Id
    private String id;
    private String assetName;
    private Integer quantity;
    private String type;

    public Asset(String id, String assetName, Integer quantity, String type) {
        this.id = id;
        this.assetName = assetName;
        this.quantity = quantity;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
