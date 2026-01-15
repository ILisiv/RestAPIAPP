package com.Volkov.RestAPIAPP.product.support;

import com.Volkov.RestAPIAPP.product.api.request.ProductRequest;
import com.Volkov.RestAPIAPP.product.api.request.UpdateProductRequest;
import com.Volkov.RestAPIAPP.product.api.response.ProductResponse;
import com.Volkov.RestAPIAPP.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // Converts a Create Request into a new Product entity
    public Product toProduct(ProductRequest productRequest) {
        return new Product(productRequest.getName());
    }

    // UPDATED METHOD: Updates the state of an EXISTING Product entity
    // This allows the Service to maintain the same object reference
    public Product toProduct(Product product, UpdateProductRequest updateProductRequest) {
        product.setName(updateProductRequest.getName()); //
        return product; //
    }

    // Converts the Product entity into a Response DTO for the API
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName()); //
    }
}