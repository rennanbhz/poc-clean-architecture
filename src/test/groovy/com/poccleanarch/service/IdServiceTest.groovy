package com.poccleanarch.service

import groovy.transform.CompileDynamic
import spock.lang.Specification

@CompileDynamic
class IdServiceTest extends Specification {
    IdService idService

    def setup() {
        idService = new IdService()
    }

    def "It should return a valid UUID"() {
        given:
        def regexOfUUID = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}\$"

        when:
        String result = idService.generateId()

        then: 'check if the generated id has the expected format and it is valid'
        assert result.matches(regexOfUUID)
        assert UUID.fromString(result)
    }
}
