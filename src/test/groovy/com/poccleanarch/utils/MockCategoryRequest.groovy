package com.poccleanarch.utils

import com.poccleanarch.business.model.Category

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

class MockCategoryRequest {

    private String id;
    private String name;
    private String description;
    private String helpText;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    static Category createCategory(String objectId = "614bbd168d2adc6db4118ef5",
                                      String id = "8f713f92-c798-4eb9-9cca-445e66f8561f",
                                      String name = "name",
                                      String description = "description",
                                      String helpText = "help-text",
                                      OffsetDateTime createdAt = OffsetDateTime.of(LocalDateTime.of(2021, 11,
                                              11, 17, 22, 30), ZoneOffset.UTC)) {
        def category = new Category()
        category.setId(objectId)
        category.setId(id)
        category.setName(name)
        category.setDescription(description)
        category.setHelpText(helpText)
        category.setCreatedAt(createdAt)

        return category
    }
}
