package com.poccleanarch.entrypoint.graphql.resolver;

import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.usecase.CreateCategoryUseCase;
import com.poccleanarch.entrypoint.graphql.assembler.CreateCategoryInputToCategoryAssembler;
import com.poccleanarch.entrypoint.graphql.dto.input.category.CreateCategoryInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class CreateCategoryResolver implements GraphQLMutationResolver{

  private static final Logger LOGGER = LoggerFactory.getLogger(CreateCategoryResolver.class);

  private final CreateCategoryUseCase createCategoryUseCase;
  private final CreateCategoryInputToCategoryAssembler assembler;

  public CreateCategoryResolver(
      CreateCategoryUseCase createCategoryUseCase,
      CreateCategoryInputToCategoryAssembler assembler) {
    this.createCategoryUseCase = createCategoryUseCase;
    this.assembler = assembler;
  }

  public Category createCategory(@Valid CreateCategoryInput input) {

    LOGGER.debug("Started CreateCategoryResolver.createCategory");
    return createCategoryUseCase.execute(assembler.assemble(input));
  }
}
