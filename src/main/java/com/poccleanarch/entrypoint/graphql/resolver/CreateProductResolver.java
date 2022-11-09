package com.poccleanarch.entrypoint.graphql.resolver;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.business.usecase.CreateProductUseCase;
import com.poccleanarch.entrypoint.graphql.assembler.CreateProductInputToProductAssembler;
import com.poccleanarch.entrypoint.graphql.dto.input.product.CreateProductInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class CreateProductResolver implements GraphQLMutationResolver{

  private static final Logger LOGGER = LoggerFactory.getLogger(CreateProductResolver.class);

  private final CreateProductUseCase createProductUseCase;
  private final CreateProductInputToProductAssembler assembler;

  public CreateProductResolver(
      CreateProductUseCase createProductUseCase,
      CreateProductInputToProductAssembler assembler) {
    this.createProductUseCase = createProductUseCase;
    this.assembler = assembler;
  }


  public Product createProduct(@Valid CreateProductInput input) {

    LOGGER.debug("Started CreateProductResolver.createProduct");
    return createProductUseCase.execute(assembler.assemble(input));
  }
}
