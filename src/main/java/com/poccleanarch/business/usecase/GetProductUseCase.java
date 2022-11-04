package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.business.gateway.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProductUseCase {

  private final ProductRepository productRepository;

  public GetProductUseCase(
      ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product execute(String id) {
    return productRepository.findIProductById(id);
  }
}
