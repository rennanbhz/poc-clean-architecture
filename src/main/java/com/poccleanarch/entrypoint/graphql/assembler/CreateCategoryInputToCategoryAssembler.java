package com.poccleanarch.entrypoint.graphql.assembler;

import com.poccleanarch.business.model.Category;
import com.poccleanarch.entrypoint.graphql.dto.input.category.CreateCategoryInput;
import com.poccleanarch.service.IdService;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryInputToCategoryAssembler {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CreateCategoryInputToCategoryAssembler.class);
  private final IdService idService;

  public CreateCategoryInputToCategoryAssembler(IdService idService) {
    this.idService = idService;
  }

  public Category assemble(final CreateCategoryInput createCategoryInput) {
    LOGGER.debug("Started CreateCategoryInputToTaxonomyNodeAssembler.assemble");
    Category category = new Category();
    category.setId(idService.generateId());
    category.setName(StringUtils.normalizeSpace(createCategoryInput.getName()));
    category.setDescription(createCategoryInput.getDescription());
    category.setHelpText(createCategoryInput.getHelpText());
    category.setCreatedAt(OffsetDateTime.now(ZoneId.of("Etc/UTC")));
    category.setUpdatedAt(OffsetDateTime.now(ZoneId.of("Etc/UTC")));

    LOGGER.debug("Finished CreateCategoryInputToCategoryAssembler.assemble");
    return category;
  }
}
