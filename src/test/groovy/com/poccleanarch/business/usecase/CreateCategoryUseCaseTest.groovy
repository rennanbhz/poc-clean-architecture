package com.poccleanarch.business.usecase

import com.poccleanarch.business.exception.BusinessValidationException
import com.poccleanarch.business.gateway.repository.CategoryRepository
import com.poccleanarch.business.gateway.validator.DuplicatedCategoryValidator
import com.poccleanarch.business.model.Category
import com.poccleanarch.entrypoint.graphql.exception.ErrorType
import com.poccleanarch.entrypoint.graphql.exception.IssueEnum
import groovy.transform.CompileDynamic
import spock.lang.Specification

import static com.poccleanarch.utils.MockCategoryRequest.createCategory

@CompileDynamic
class CreateCategoryUseCaseTest extends Specification {

    CategoryRepository categoryRepository = Mock()
    DuplicatedCategoryValidator duplicatedCategoryValidator = Mock()
    CreateCategoryUseCase createCategoryUseCase

    def setup() {
        createCategoryUseCase = new CreateCategoryUseCase(categoryRepository, duplicatedCategoryValidator)
    }

    def "It should create category successfully"() {
        given:
        Category category = createCategory()
        Category categoryCreated = createCategory()

        when:
        Category categoryResult = createCategoryUseCase.execute(category)

        then:
        1 * duplicatedCategoryValidator.validate(category)
        1 * categoryRepository.createCategory(category) >> categoryCreated

        assert categoryResult == categoryCreated
    }

    def "It should throw exception duplicated name when there is a Category with the same name"() {
        given:
        Category category = createCategory()
        Category categoryCreated = createCategory()
        def errorMessage = "Category name already exists."

        when:
        createCategoryUseCase.execute(category)

        then:
        duplicatedCategoryValidator.validate(category) >> {
            throw BusinessValidationException.businessException(
                    ErrorType.VALIDATION_ERROR, IssueEnum.CATEGORY_NAME_DUPLICATED)
        }

        def expectedError = thrown(BusinessValidationException)
        assert expectedError.getIssue().getMessage() == errorMessage
        assert expectedError.getIssue().getCode() == 4
    }
}
