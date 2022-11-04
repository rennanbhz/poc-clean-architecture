package com.poccleanarch.business.model;

import java.time.OffsetDateTime;

public class Category {

    private String id;
    private String name;
    private String description;
    private String helpText;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Category() {
    }

    public Category(String id,
        String name,
        String description,
        String helpText,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.helpText = helpText;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
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
