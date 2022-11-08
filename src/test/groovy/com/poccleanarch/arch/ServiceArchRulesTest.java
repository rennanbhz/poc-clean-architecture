package com.poccleanarch.arch;

import static com.poccleanarch.arch.ArchUnitHelper.ALL_CLASSES_PACKAGE;
import static com.poccleanarch.arch.ArchUnitHelper.ASSEMBLER_LAYER_NAME;
import static com.poccleanarch.arch.ArchUnitHelper.SERVICES_LAYER_NAME;
import static com.poccleanarch.arch.ArchUnitHelper.SERVICES_LAYER_PATH;
import static com.poccleanarch.arch.ArchUnitHelper.SERVICE_SUFFIX;
import static com.poccleanarch.arch.ArchUnitHelper.USE_CASE_LAYER_NAME;
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

public class ServiceArchRulesTest {

  private JavaClasses allClasses;

  @Before
  public void init() {
    allClasses =
        new ClassFileImporter()
            .withImportOption(new DoNotIncludeTests())
            .importPackages(ALL_CLASSES_PACKAGE);
  }

  @Test
  @DisplayName("Service classes in service package should be suffixed as Service")
  public void businessClassesInUseCasePackageShouldBeSuffixedAsUseCase() {

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAPackage(SERVICES_LAYER_PATH)
            .should()
            .haveSimpleNameEndingWith(SERVICE_SUFFIX);
    rule.check(allClasses);
  }

  @Test
  @DisplayName("Service classes in service package should be annotated as Service")
  public void businessClassesInUseCasePackageShouldBeAnnotatedAsComponent() {

    JavaClasses allExceptUseCases = allClasses.that(doNot(simpleNameEndingWith(VALIDATOR_SUFFIX)));

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAPackage(SERVICES_LAYER_PATH)
            .should()
            .beAnnotatedWith(Service.class)
            .andShould()
            .notBeAnnotatedWith(Repository.class)
            .andShould()
            .notBeAnnotatedWith(Configuration.class)
            .andShould()
            .notBeAnnotatedWith(Component.class);

    rule.check(allExceptUseCases);
  }

  @Test
  @DisplayName("Service layer should be accessed only for UseCase layer")
  public void serviceLayerValidation() {
    ArchRule rule =
        ArchUnitHelper.returnCleanCodeLayeredArchitecture()
            .whereLayer(SERVICES_LAYER_NAME)
            .mayOnlyBeAccessedByLayers(
                USE_CASE_LAYER_NAME, ASSEMBLER_LAYER_NAME);
    rule.check(allClasses);
  }
}
