package com.Volkov.RestAPIAPP.product.api;

import com.Volkov.RestAPIAPP.product.api.request.ProductRequest;
import com.Volkov.RestAPIAPP.product.api.request.UpdateProductRequest;
import com.Volkov.RestAPIAPP.product.api.response.ProductResponse;
import com.Volkov.RestAPIAPP.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product Controller")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Create product")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.create(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find product by id")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
        ProductResponse productResponse = productService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest) {
        ProductResponse productResponse = productService.update(id, updateProductRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping
    @Operation(summary = "Find all products")
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> productResponses = productService.findAll(); //
        return ResponseEntity.status(HttpStatus.OK).body(productResponses); //
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete item")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id); //
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //
    }
}