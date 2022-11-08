package com.poccleanarch.utils

import com.poccleanarch.business.model.Category
import com.poccleanarch.inbound.graphql.dto.input.category.CreateCategoryInput

import static com.poccleanarch.utils.FieldConstants.*

class MockCategoryDTOUtils {

    static Category createCategory(id = CATEGORY_ID_01,
                                   name = CATEGORY_NAME,
                                   String description = CATEGORY_DESCRIPTION,
                                   String helpText = CATEGORY_HELP_TEXT,
                                   createdAt = CREATED_AT) {
        def category = new Category()

        category.setId(id)
        category.setName(name)
        category.setDescription(description)
        category.setHelpText(helpText)
        category.setCreatedAt(createdAt)

        return category
    }

    static CreateCategoryInput createCategoryInput(name = CATEGORY_NAME,
                                                         description = CATEGORY_DESCRIPTION,
                                                         helpText = CATEGORY_HELP_TEXT) {
        def categoryInput = new CreateCategoryInput()
        categoryInput.setName(name)
        categoryInput.setDescription(description)
        categoryInput.setHelpText(helpText)

        return categoryInput
    }

}
