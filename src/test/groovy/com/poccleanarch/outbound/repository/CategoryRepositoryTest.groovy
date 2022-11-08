package com.poccleanarch.outbound.repository


import com.poccleanarch.business.gateway.repository.CategoryRepository
import com.poccleanarch.business.model.Category
import com.poccleanarch.outbound.config.BaseRepositoryTest
import groovy.transform.CompileDynamic
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import static com.poccleanarch.utils.FieldConstants.*

import static com.poccleanarch.utils.MockCategoryRequest.createCategory
import static java.util.Objects.nonNull

@CompileDynamic
class CategoryRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository

    @Autowired
    private MongoTemplate mongoTemplate

    @Before
    void setUp() {
        createCategoryRequest()
    }

    @After
    void after() {
        mongoCleanUp()
    }

    @Test
    void "It should Create Category with success"() {
        given:
        Category category = createCategory()

        when:
        Category categoryResult = categoryRepository.createCategory(category)

        then:
        mongoTemplate.save(category, "Category")
        assert category.getId() == categoryResult.getId()
        assert category.getName() == categoryResult.getName()
        assert category.getDescription() == categoryResult.getDescription()
        assert category.getHelpText() == categoryResult.getHelpText()
        assert category.getCreatedAt() == category.getCreatedAt()
    }

    @Test
    void "It should find Category by id with success"() {
        when:
        Category categoryResult = categoryRepository.findCategoryById(REQUEST_CATEGORY_ID_01)

        then:
        assert nonNull(categoryResult)
        assert categoryResult.getId() == REQUEST_CATEGORY_ID_01
    }
}
