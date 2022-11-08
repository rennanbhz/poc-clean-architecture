package com.poccleanarch.inbound.graphql.assembler;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.inbound.graphql.dto.input.product.CreateProductInput;
import com.poccleanarch.service.IdService;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateProductInputToProductAssembler {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CreateProductInputToProductAssembler.class);
  private final IdService idService;

  public CreateProductInputToProductAssembler(IdService idService) {
    this.idService = idService;
  }

  public Product assemble(final CreateProductInput createProductInput) {
    LOGGER.debug("Started CreateProductInputToProductAssembler.assemble");
    Product product = new Product();
    product.setId(idService.generateId());
    product.setCategoryId(createProductInput.getCategoryId());
    product.setName(StringUtils.normalizeSpace(createProductInput.getName()));
    product.setDescription(createProductInput.getDescription());
    product.setImages(createProductInput.getImages());
    product.setCreatedAt(OffsetDateTime.now(ZoneId.of("Etc/UTC")));
    product.setUpdatedAt(OffsetDateTime.now(ZoneId.of("Etc/UTC")));

    LOGGER.debug("Finished CreateProductInputToProductAssembler.assemble");
    return product;
  }
}
