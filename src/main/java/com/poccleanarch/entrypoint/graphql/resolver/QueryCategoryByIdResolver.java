package com.poccleanarch.entrypoint.graphql.resolver;

import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.usecase.QueryCategoryByIdUseCase;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueryCategoryByIdResolver implements GraphQLQueryResolver {

  private final QueryCategoryByIdUseCase queryCategoryByIdUseCase;

  private static final Logger LOGGER = LoggerFactory.getLogger(QueryCategoryByIdResolver.class);

  public QueryCategoryByIdResolver(
      QueryCategoryByIdUseCase queryCategoryByIdUseCase) {
    this.queryCategoryByIdUseCase = queryCategoryByIdUseCase;
  }

  public Category category(String id) {
    LOGGER.debug("Started QueryCategoryByIdResolver.category");
    return queryCategoryByIdUseCase.execute(id);
  }
}
