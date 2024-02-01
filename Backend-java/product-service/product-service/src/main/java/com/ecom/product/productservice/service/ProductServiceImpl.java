package com.ecom.product.productservice.service;

import com.ecom.product.productservice.exception.AlreadyFoundException;
import com.ecom.product.productservice.exception.NotFoundException;
import com.ecom.product.productservice.model.Product;
import com.ecom.product.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.time.LocalDateTime;
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

        /*Optional<Product> getProductById = productRepository.findById(product.getProductId());
        if (!getProductById.isPresent()){
            throw new AlreadyFoundException("this Id is already present in the database");
        }*/
        Product product1 = new Product();

        product1.setCreatedDate(LocalDateTime.now());

                productRepository.save(product);


        return product1;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()){
            throw new NotFoundException("this productId is not present in the Database");
        }

        Product updateProduct = optionalProduct.get();
        updateProduct.setProductName(product.getProductName());
        updateProduct.setTitle(product.getTitle());
        updateProduct.setProductDescription(product.getProductDescription());
        updateProduct.setModifiedDate(LocalDateTime.now());
        updateProduct.setProductPrice(product.getProductPrice());

        Product updatedProduct = productRepository.save(updateProduct);
        return updatedProduct;
    }

    @Override
    public String deleteProduct(Long productId) {

        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()){
            throw new NotFoundException("this product Id is not found");
        }
         productRepository.deleteById(productId);

        return "deleted Successfully";
    }



}
