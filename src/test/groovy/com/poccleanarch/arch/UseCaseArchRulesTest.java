package com.poccleanarch.arch;

import static com.poccleanarch.arch.ArchUnitHelper.ALL_CLASSES_PACKAGE;
import static com.poccleanarch.arch.ArchUnitHelper.EXCEPTION_SUFFIX;
import static com.poccleanarch.arch.ArchUnitHelper.GRAPHQL_LAYER_NAME;
import static com.poccleanarch.arch.ArchUnitHelper.USE_CASE_LAYER_NAME;
import static com.poccleanarch.arch.ArchUnitHelper.USE_CASE_LAYER_PATH;
import static com.poccleanarch.arch.ArchUnitHelper.USE_CASE_SUFFIX;
import static com.poccleanarch.arch.ArchUnitHelper.VALIDATOR_SUFFIX;
import static com.tngtech.archunit.base.DescribedPredicate.doNot;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.simpleNameEndingWith;

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

public class UseCaseArchRulesTest {

  private JavaClasses allClasses;

  @Before
  public void init() {
    allClasses =
        new ClassFileImporter()
            .withImportOption(new DoNotIncludeTests())
            .importPackages(ALL_CLASSES_PACKAGE);
  }

  @Test
  @DisplayName("Business classes in use case should be suffixed as UseCase")
  public void businessClassesInUseCasePackageShouldBeSuffixedAsUseCase() {

    JavaClasses allExceptValidators =
        allClasses.that(
            doNot(
                simpleNameEndingWith(VALIDATOR_SUFFIX).or(simpleNameEndingWith(EXCEPTION_SUFFIX))));

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAPackage(USE_CASE_LAYER_PATH)
            .should()
            .haveSimpleNameEndingWith(USE_CASE_SUFFIX);
    rule.check(allExceptValidators);
  }

  @Test
  @DisplayName("Business Validator classes in use case should be suffixed as Validator")
  public void businessValidatorClassesInUseCasePackageShouldBeSuffixedAsValidator() {

    JavaClasses allExceptUseCases =
        allClasses.that(
            doNot(
                simpleNameEndingWith(USE_CASE_SUFFIX).or(simpleNameEndingWith(EXCEPTION_SUFFIX))));

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAPackage(USE_CASE_LAYER_PATH)
            .should()
            .haveSimpleNameEndingWith(VALIDATOR_SUFFIX);
    rule.check(allExceptUseCases);
  }

  @Test
  @DisplayName("Exception classes in use case should be suffixed as Exception")
  public void exceptionClassesInUseCasePackageShouldBeSuffixedAsException() {

    JavaClasses allExceptUseCases =
        allClasses.that(
            doNot(
                simpleNameEndingWith(USE_CASE_SUFFIX).or(simpleNameEndingWith(VALIDATOR_SUFFIX))));

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAPackage(USE_CASE_LAYER_PATH)
            .should()
            .haveSimpleNameEndingWith(EXCEPTION_SUFFIX);
    rule.check(allExceptUseCases);
  }

  @Test
  @DisplayName("Business classes in use case should be annotated as Service")
  public void businessClassesInUseCasePackageShouldBeAnnotatedAsService() {

    JavaClasses allExceptUseCases =
        allClasses.that(
            doNot(
                simpleNameEndingWith(VALIDATOR_SUFFIX).or(simpleNameEndingWith(EXCEPTION_SUFFIX))));

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAPackage(USE_CASE_LAYER_PATH)
            .should()
            .notBeAnnotatedWith(Component.class)
            .andShould()
            .notBeAnnotatedWith(Repository.class)
            .andShould()
            .notBeAnnotatedWith(Configuration.class)
            .andShould()
            .beAnnotatedWith(Service.class);

    rule.check(allExceptUseCases);
  }

  @Test
  @DisplayName(
      "UseCase layer should be accessed only for GraphQL, RepositoryOrchestrator and Builder layer")
  public void useCaseLayerValidation() {
    ArchRule rule =
        ArchUnitHelper.returnCleanCodeLayeredArchitecture()
            .whereLayer(USE_CASE_LAYER_NAME)
            .mayOnlyBeAccessedByLayers(
                GRAPHQL_LAYER_NAME,
                VALIDATOR_SUFFIX);
    rule.check(allClasses);
  }
}
