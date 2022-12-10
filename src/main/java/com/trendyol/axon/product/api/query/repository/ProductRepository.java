package com.trendyol.axon.product.api.query.repository;

import com.trendyol.axon.product.api.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByIdOrTitle(String id, String title);
}