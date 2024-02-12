package com.ecommerce.order.orderservice.feign;

import com.ecom.common.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductService {

    @GetMapping("api/v1/product/getProductById/{productId}")
    ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId);
}
