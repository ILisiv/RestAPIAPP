package com.Volkov.RestAPIAPP.product.service;

import com.Volkov.RestAPIAPP.product.api.request.ProductRequest;
import com.Volkov.RestAPIAPP.product.api.request.UpdateProductRequest;
import com.Volkov.RestAPIAPP.product.api.response.ProductResponse;
import com.Volkov.RestAPIAPP.product.domain.Product;
import com.Volkov.RestAPIAPP.product.repository.ProductRepository;
import com.Volkov.RestAPIAPP.product.support.ProductMapper;
import com.Volkov.RestAPIAPP.product.support.exception.ProductExceptionSupplier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    @Transactional
    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productMapper.toProduct(product, updateProductRequest);
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.delete(product);
    }
}