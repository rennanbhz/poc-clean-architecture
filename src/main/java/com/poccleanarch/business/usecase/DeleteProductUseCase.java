package com.poccleanarch.business.usecase;

import com.poccleanarch.business.gateway.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(DeleteProductUseCase.class);

  private final ProductRepository productRepository;

  public DeleteProductUseCase(
      ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void execute(String id) {
    LOGGER.debug("Started DeleteProductUseCase.execute");
    productRepository.deleteProduct(id);
  }
}
