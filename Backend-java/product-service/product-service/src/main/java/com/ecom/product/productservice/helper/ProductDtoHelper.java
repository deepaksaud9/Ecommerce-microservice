package com.ecom.product.productservice.helper;

import com.ecom.product.productservice.model.Product;

import java.util.Optional;

public class ProductDtoHelper {

    public static Product makeProductFromProduct(Optional<Product> productDatabase, Product newProduct){

      productDatabase.stream();
      productDatabase.get();
      productDatabase.toString();
      productDatabase.toString();

      return productDatabase.get();
    }
}
