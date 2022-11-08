package com.poccleanarch.graphql.resolver

import com.poccleanarch.business.model.Category
import com.poccleanarch.business.usecase.CreateCategoryUseCase
import com.poccleanarch.entrypoint.graphql.assembler.CreateCategoryInputToCategoryAssembler
import com.poccleanarch.entrypoint.graphql.dto.input.category.CreateCategoryInput
import com.poccleanarch.entrypoint.graphql.resolver.CreateCategoryResolver
import groovy.transform.CompileDynamic
import spock.lang.Specification

@CompileDynamic
class CreateCategoryResolverTest extends Specification {

    CreateCategoryResolver categoryResolver
    CreateCategoryUseCase createCategoryUseCase = Mock()
    CreateCategoryInputToCategoryAssembler categoryInputToCategoryAssembler = Mock()

    def setup() {
        categoryResolver = new CreateCategoryResolver(createCategoryUseCase, categoryInputToCategoryAssembler)
    }

    def "It should create a category successfully"() {
        given:
        def assemblerResult = Mock(Category)
        def useCaseResult = Mock(Category)
        CreateCategoryInput createCategoryInput = Mock(CreateCategoryInput)

        when:
        Category categoryResult = categoryResolver.createCategory(createCategoryInput)

        then:
        1 * categoryInputToCategoryAssembler.assemble(createCategoryInput) >> assemblerResult
        1 * createCategoryUseCase.execute(assemblerResult) >> useCaseResult
        assert categoryResult == useCaseResult
    }
}
