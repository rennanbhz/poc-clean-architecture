package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.business.gateway.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {

  private final ProductRepository productRepository;

  public CreateProductUseCase(
      ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product execute(Product product) {
    return productRepository.createProduct(product);
  }
}
