package com.poccleanarch.arch;

import com.tngtech.archunit.library.Architectures;
import com.tngtech.archunit.library.Architectures.LayeredArchitecture;

public class ArchUnitHelper {

  public static final String ALL_CLASSES_PACKAGE = "com.poccleanarch.arch";

  public static final String USE_CASE_LAYER_PATH = "com.poccleanarch.arch.business.usecase..";

  public static final String ASSEMBLER_LAYER_PATH = "com.poccleanarch.arch.graphql.assembler..";

  public static final String GRAPHQL_LAYER_PATH = "com.poccleanarch.arch.graphql..";

  public static final String GRAPHQL_RESOLVER_LAYER_PATH = "com.poccleanarch.arch.graphql.resolver..";

  public static final String SERVICES_LAYER_PATH = "com.poccleanarch.arch.business.service..";

  public static final String DATABASE_LAYER_PATH = "com.poccleanarch.arch.external.db..";

  public static final String DATABASE_REPOSITORY_LAYER_PATH =
      "com.poccleanarch.arch.db.external.repository..";

  public static final String VALIDATOR_LAYER_PATH = "com.poccleanarch.arch.business.validator..";

  public static final String USE_CASE_SUFFIX = "UseCase";

  public static final String VALIDATOR_SUFFIX = "Validator";

  public static final String REPOSITORY_SUFFIX = "Repository";

  public static final String SERVICE_SUFFIX = "Service";

  public static final String RESOLVER_SUFFIX = "Resolver";

  public static final String EXCEPTION_SUFFIX = "Exception";

  public static final String USE_CASE_LAYER_NAME = "UseCases";

  public static final String ASSEMBLER_LAYER_NAME = "Assembler";

  public static final String GRAPHQL_LAYER_NAME = "Graphql";

  public static final String DATABASE_LAYER_NAME = "Database";

  public static final String SERVICES_LAYER_NAME = "Service";

  public static LayeredArchitecture returnCleanCodeLayeredArchitecture() {
    return Architectures.layeredArchitecture()
        .layer(USE_CASE_LAYER_NAME)
        .definedBy(USE_CASE_LAYER_PATH)
        .layer(ASSEMBLER_LAYER_NAME)
        .definedBy(ASSEMBLER_LAYER_PATH)
        .layer(GRAPHQL_LAYER_NAME)
        .definedBy(GRAPHQL_LAYER_PATH)
        .layer(DATABASE_LAYER_NAME)
        .definedBy(DATABASE_LAYER_PATH)
        .layer(SERVICES_LAYER_NAME)
        .definedBy(SERVICES_LAYER_PATH)
        .layer(VALIDATOR_SUFFIX)
        .definedBy(VALIDATOR_LAYER_PATH);
  }
}
