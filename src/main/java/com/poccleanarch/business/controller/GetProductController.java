package com.poccleanarch.business.controller;

import com.poccleanarch.business.model.Product;
import com.poccleanarch.business.usecase.GetProductUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GetProductController {

  private final GetProductUseCase getProductUseCase;

  public GetProductController(GetProductUseCase getProductUseCase) {
    this.getProductUseCase = getProductUseCase;
  }

  @GetMapping(path = "/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Product getProduct(@PathVariable(name = "product_id") String productId) {
    return getProductUseCase.execute(productId);
  }
}
