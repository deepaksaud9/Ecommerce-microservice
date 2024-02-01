package com.ecom.product.productservice.controller;

import com.ecom.product.productservice.exception.NotFoundException;
import com.ecom.product.productservice.model.Product;
import com.ecom.product.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){

        Product product = productService.productById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> products = productService.getAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){

        productService.addProduct(product);

        return new ResponseEntity<>("Product Successfully Created",HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId,@RequestBody Product product){

        Product updateProduct = productService.updateProduct(productId,product);

        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId){

        productService.deleteProduct(productId);

        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

}
