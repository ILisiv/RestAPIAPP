package com.Volkov.RestAPIAPP.product.repository;

import com.Volkov.RestAPIAPP.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // No manual code needed!
    // It already has save(), findById(), findAll(), and deleteById().
}