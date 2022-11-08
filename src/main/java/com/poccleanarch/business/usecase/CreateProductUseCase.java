package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.business.gateway.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CreateProductUseCase.class);

  private final ProductRepository productRepository;

  public CreateProductUseCase(
      ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product execute(Product product) {
    LOGGER.debug("Started CreateProductUseCase.execute");
    return productRepository.createProduct(product);
  }
}
