package com.poccleanarch.business.usecase

import com.poccleanarch.business.exception.BusinessValidationException
import com.poccleanarch.business.gateway.repository.CategoryRepository
import com.poccleanarch.business.model.Category
import com.poccleanarch.inbound.graphql.exception.ErrorType
import com.poccleanarch.inbound.graphql.exception.IssueEnum
import groovy.transform.CompileDynamic
import spock.lang.Specification

@CompileDynamic
class GetCategoryUseCaseTest extends Specification {

    GetCategoryUseCase getCategoryUseCase
    CategoryRepository categoryRepository = Mock()

    void setup() {
        getCategoryUseCase = new GetCategoryUseCase(categoryRepository)
    }

    void "It should return the AbstractAttribute when getting by Id"() {
        given:
        def id = "Id1"
        def expectedResult = Mock(Category)

        when:
        Category categoryResult = getCategoryUseCase.execute(id)

        then:
        1 * categoryRepository.findCategoryById(id) >> expectedResult
        assert expectedResult == categoryResult
    }

    void "It should throw an exception when the Category does not exist"() {
        given:
        def nonExistingId = "XX"
        def expectedMessage = "This Category doesn't exist"

        when:
        getCategoryUseCase.execute(nonExistingId)

        then:
        1 * categoryRepository.findCategoryById(nonExistingId) >> {
            throw BusinessValidationException.businessException(
                    ErrorType.CONTENT_NOT_FOUND_ERROR, IssueEnum.CATEGORY_NOT_FOUND);
        }

        and: 'make sure the exception was thrown'
        def notFoundException = thrown(BusinessValidationException)
        notFoundException.getIssue().getMessage() == expectedMessage
        notFoundException.getIssue().getCode() == 5
    }
}
