package com.poccleanarch.business.gateway.validator

import com.poccleanarch.business.exception.BusinessValidationException
import com.poccleanarch.business.gateway.repository.CategoryRepository
import com.poccleanarch.business.model.Category
import groovy.transform.CompileDynamic
import spock.lang.Specification

@CompileDynamic
class DuplicatedCategoryValidatorTest extends Specification {

    CategoryRepository categoryRepository

    DuplicatedCategoryValidator duplicatedCategoryValidator

    void setup() {
        duplicatedCategoryValidator = new DuplicatedCategoryValidator(categoryRepository)
    }

    def "It should validate successfully when an attribute doesn't exist yet"() {
        given:
        def category = Mock(Category)

        when:
        duplicatedCategoryValidator.validate(category)

        then:
        1 * categoryRepository.hasDuplicated(category) >> false
    }

    def "It should throw exception when validating an attribute that already exists"() {
        given:
        def category = Mock(Category)
        def expectedMessage = "Category name already exists."
        def expectedResult = true

        when:
        duplicatedCategoryValidator.validate(category) >> category

        then:
        1 * categoryRepository.hasDuplicated(category) >> expectedResult
        def businessValidationException = thrown(BusinessValidationException)
        businessValidationException.getIssue().getMessage() == expectedMessage
    }
}
