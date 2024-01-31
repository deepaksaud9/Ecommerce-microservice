package com.ecom.product.productservice.service;

import com.ecom.product.productservice.model.Product;

import java.util.List;


public interface ProductService {

    Product productById(Long productId);

    List<Product> getAllProducts();

    Product addProduct(Product product);

    Product updateProduct(Long productId, Product product);

    String deleteProduct(Long productId);
}
