package com.ecom.product.productservice.helper;

import com.ecom.common.dto.ProductResponse;
import com.ecom.product.productservice.model.Product;

public class ProductHelper {

    public static ProductResponse productToProductResponse(Product product){

        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getProductId());
        productResponse.setProductName(product.getProductName());
        productResponse.setProductDescription(product.getProductDescription());
        productResponse.setTitle(product.getTitle());
        productResponse.setProductPrice(product.getProductPrice());

        return productResponse;
    }
}
