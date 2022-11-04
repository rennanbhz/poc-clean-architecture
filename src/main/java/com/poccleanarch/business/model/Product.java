package com.poccleanarch.business.model;

import java.time.OffsetDateTime;
import java.util.List;

public class Product {
    String id;
    String name;
    String description;
    String categoryId;
    List<Image> images;
    OffsetDateTime createdAt;
    OffsetDateTime updatedAt;

    public Product() {
    }

    public Product(String id,
        String name,
        String description,
        String categoryId,
        List<Image> images,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.images = images;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
