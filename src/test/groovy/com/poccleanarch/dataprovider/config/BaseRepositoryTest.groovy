package com.poccleanarch.dataprovider.config

import com.poccleanarch.business.model.Category
import com.poccleanarch.business.model.Product
import groovy.transform.CompileDynamic
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.utility.DockerImageName

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = [Initializer.class])
@CompileDynamic
abstract class BaseRepositoryTest {

    public static final String CATEGORY_COLLECTION = "Category"
    public static final String PRODUCT_COLLECTION = "Product"

    @Autowired
    private MongoTemplate mongoTemplate

    public static MongoDBContainer mongoDBContainer =
            new MongoDBContainer(DockerImageName.parse("mongo:4"))

    static {
        mongoDBContainer.start()
    }
//
//    @Value('http://localhost:${local.server.port}')
//    String baseUrl

//    @Before
//    void setUp() {
//        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
//        RestAssured.defaultParser = Parser.fromContentType("application/json")
//        RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig()
//
//                .defaultContentCharset("UTF-8")
//                .defaultCharsetForContentType("UTF-8", "application/json"))
//                .decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8")
//                        .defaultCharsetForContentType("UTF-8", "application/json"))
//    }

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.data.mongodb.url=" + mongoDBContainer.getReplicaSetUrl()
            )
                    .applyTo(configurableApplicationContext.getEnvironment())
        }
    }

    void mongoCleanUp() {
        mongoTemplate.dropCollection(CATEGORY_COLLECTION)
        mongoTemplate.dropCollection(PRODUCT_COLLECTION)
    }

    private static String encode(byte[] bytes) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes)
    }


    void createCategoryRequest(String objectId = "614bbd168d2adc6db4118ef5",
                               String id = "8f713f92-c798-4eb9-9cca-445e66f8561f",
                               String name = "name",
                               String description = "description",
                               String helpText = "help-text",
                               OffsetDateTime createdAt = OffsetDateTime.of(
                                       LocalDateTime.of(2021, 11,
                                   11, 17, 22, 30), ZoneOffset.UTC)) {

        Category categoryRequest = new Category()
        categoryRequest.setObjectId(objectId)
        categoryRequest.setId(id)
        categoryRequest.setName(name)
        categoryRequest.setDescription(description)
        categoryRequest.setHelpText(helpText)
        categoryRequest.setCreatedAt(createdAt)

        mongoTemplate.save(categoryRequest, CATEGORY_COLLECTION)
    }

    void createProductRequest(String objectId = "614bbd168d2adc6db4118ef6",
                              String id = "e9a8ffbd-a99a-4147-8695-009ece84f30e",
                              String name = "name",
                              String description = "description",
                              String categoryId = "8f713f92-c798-4eb9-9cca-445e66f8561f",
                              List<String> images = List.of(
                                      "http://test-1.com.br",
                                      "http://test-2.com.br"),
                              OffsetDateTime createdAt = OffsetDateTime.of(
                                      LocalDateTime.of(2021, 11,
                                      11, 17, 22, 30), ZoneOffset.UTC)) {

        Product productRequest = new Product()
        productRequest.setObjectId(objectId)
        productRequest.setId(id)
        productRequest.setName(name)
        productRequest.setDescription(description)
        productRequest.setCategoryId(categoryId)
        productRequest.setImages(images)
        productRequest.setCreatedAt(createdAt)

        mongoTemplate.save(productRequest, PRODUCT_COLLECTION)
    }

}
