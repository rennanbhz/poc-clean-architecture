package com.poccleanarch.business.controller;

import com.poccleanarch.business.usecase.DeleteProductUseCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DeleteProductController {

  private final DeleteProductUseCase deleteProductUseCase;

  public DeleteProductController(
      DeleteProductUseCase deleteProductUseCase) {
    this.deleteProductUseCase = deleteProductUseCase;
  }

  @DeleteMapping(path = "/{product_id}")
  public void deleteProduct(String id) {
    deleteProductUseCase.execute(id);
  }
}
