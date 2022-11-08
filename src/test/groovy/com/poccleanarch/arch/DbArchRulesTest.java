package com.poccleanarch.arch;

import static com.poccleanarch.arch.ArchUnitHelper.ALL_CLASSES_PACKAGE;
import static com.poccleanarch.arch.ArchUnitHelper.DATABASE_LAYER_NAME;
import static com.poccleanarch.arch.ArchUnitHelper.DATABASE_REPOSITORY_LAYER_PATH;
import static com.poccleanarch.arch.ArchUnitHelper.GRAPHQL_LAYER_NAME;
import static com.poccleanarch.arch.ArchUnitHelper.REPOSITORY_SUFFIX;
import static com.poccleanarch.arch.ArchUnitHelper.USE_CASE_LAYER_NAME;
import static com.poccleanarch.arch.ArchUnitHelper.VALIDATOR_SUFFIX;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class DbArchRulesTest {

  public static final String BASE_REPOSITORY = "/repository/BaseRepository";

  private JavaClasses allClasses;

  @Before
  public void init() {

    allClasses =
        new ClassFileImporter()
            .withImportOption(new DoNotIncludeTests())
            .importPackages(ALL_CLASSES_PACKAGE);
  }

  @Test
  @DisplayName("Repositories classes in DB package should be suffixed as Repository")
  public void repositoryClassesInDbPackageShouldBeSuffixedAsRepository() {
    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAPackage(DATABASE_REPOSITORY_LAYER_PATH)
            .and()
            .areNotInnerClasses()
            .should()
            .haveSimpleNameEndingWith(REPOSITORY_SUFFIX);
    rule.check(allClasses);
  }

  @Test
  @DisplayName("Repositories classes in DB package should be annotated as Repository")
  public void repositoryClassesInDbPackageShouldBeAnnotatedAsRepository() {

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAPackage(DATABASE_REPOSITORY_LAYER_PATH)
            .should()
            .beAnnotatedWith(Repository.class)
            .andShould()
            .notBeAnnotatedWith(Component.class)
            .andShould()
            .notBeAnnotatedWith(Configuration.class)
            .andShould()
            .notBeAnnotatedWith(Service.class);

    rule.check(allClasses);
  }

  // This validation need to be fix, because the graphql layer can access only the pojos
  @Test
  public void repositoryLayerValidation() {
    ArchRule rule =
        ArchUnitHelper.returnCleanCodeLayeredArchitecture()
            .whereLayer(DATABASE_LAYER_NAME)
            .mayOnlyBeAccessedByLayers(
                USE_CASE_LAYER_NAME,
                GRAPHQL_LAYER_NAME,
                VALIDATOR_SUFFIX);
    rule.check(allClasses);
  }
}
