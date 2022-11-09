package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.business.gateway.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class QueryProductByIdUseCase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(QueryProductByIdUseCase.class);

  private final ProductRepository productRepository;

  public QueryProductByIdUseCase(
      ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product execute(String id) {
    LOGGER.debug("Started GetProductUseCase.execute");
    return productRepository.findIProductById(id);
  }
}
