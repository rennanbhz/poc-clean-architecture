package com.poccleanarch.business.usecase;

import com.poccleanarch.business.gateway.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCase {

  private final ProductRepository productRepository;

  public DeleteProductUseCase(
      ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void execute(String id) {
    productRepository.deleteProduct(id);
  }
}
