package com.poccleanarch.business.controller;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.business.usecase.CreateProductUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CreateProductController {

  private final CreateProductUseCase createProductUseCase;

  public CreateProductController(
      CreateProductUseCase createProductUseCase) {
    this.createProductUseCase = createProductUseCase;
  }

  @PostMapping(
      path = "/product",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Product createProduct(Product product) {
    return createProductUseCase.execute(product);
  }
}
