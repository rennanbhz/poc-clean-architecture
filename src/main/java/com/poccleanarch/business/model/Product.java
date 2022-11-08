package com.poccleanarch.business.model;

import java.time.OffsetDateTime;
import java.util.List;
import javax.persistence.Id;

public class Product {
    @Id
    private String objectId;
    private String id;
    private String name;
    private String description;
    private String categoryId;
    private List<String> images;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Product() {
    }

    public Product(String objectId, String id, String name, String description,
        String categoryId, List<String> images, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.objectId = objectId;
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.images = images;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
