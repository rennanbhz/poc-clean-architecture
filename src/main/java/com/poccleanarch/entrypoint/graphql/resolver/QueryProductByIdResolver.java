package com.poccleanarch.entrypoint.graphql.resolver;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.business.usecase.QueryProductByIdUseCase;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueryProductByIdResolver implements GraphQLQueryResolver {

  private final QueryProductByIdUseCase queryProductByIdUseCase;

  private static final Logger LOGGER = LoggerFactory.getLogger(QueryProductByIdResolver.class);

  public QueryProductByIdResolver(
      QueryProductByIdUseCase queryProductByIdUseCase) {
    this.queryProductByIdUseCase = queryProductByIdUseCase;
  }


  public Product product(String id) {
    LOGGER.debug("Started QueryProductByIdResolver.product");
    return queryProductByIdUseCase.execute(id);
  }
}
