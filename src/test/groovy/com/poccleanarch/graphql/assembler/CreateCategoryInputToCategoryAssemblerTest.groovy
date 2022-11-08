package com.poccleanarch.graphql.assembler

import com.poccleanarch.inbound.graphql.assembler.CreateCategoryInputToCategoryAssembler
import com.poccleanarch.service.IdService
import groovy.transform.CompileDynamic
import spock.lang.Specification

import static com.poccleanarch.utils.MockCategoryDTOUtils.createCategoryInput

@CompileDynamic
class CreateCategoryInputToCategoryAssemblerTest extends Specification {

    IdService idService = Mock()
    CreateCategoryInputToCategoryAssembler categoryInputToCategoryAssembler

    void setup() {
        categoryInputToCategoryAssembler = new CreateCategoryInputToCategoryAssembler(idService)
    }

    void "It should assemble CategoryInput to Category"() {

        given:
        def categoryInput = createCategoryInput()

        when:
        def categoryResult = categoryInputToCategoryAssembler.assemble(categoryInput)

        then:
        1 * idService.generateId() >> "ID"

        assert categoryResult.getName() == categoryInput.getName()
        assert categoryResult.getDescription() == categoryInput.getDescription()
        assert categoryResult.getHelpText() == categoryInput.getHelpText()
    }
}
