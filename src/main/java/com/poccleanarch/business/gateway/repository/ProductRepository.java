package com.poccleanarch.business.gateway.repository;

import com.poccleanarch.business.model.Product;

public interface ProductRepository {

  Product createProduct(Product product);

  Product findIProductById(String Id);

  void deleteProduct(String id);

}
