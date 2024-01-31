package com.ecom.product.productservice.service;

import com.ecom.product.productservice.exception.AlreadyFoundException;
import com.ecom.product.productservice.exception.NotFoundException;
import com.ecom.product.productservice.model.Product;
import com.ecom.product.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product productById(Long productId) {

        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()){
            throw new NotFoundException("data not found in database");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = productRepository.findAll();

        if (products.isEmpty()){
            throw new NotFoundException("no data found in database");
        }
        return products;
    }

    @Override
    public Product addProduct(Product product) {

        Optional<Product> getProductById = productRepository.findById(product.getProductId());
        if (getProductById.isPresent()){
            throw new AlreadyFoundException("this Id is present in the database");
        }

        Product product1 = productRepository.save(product);

        return product1;
    }
}
