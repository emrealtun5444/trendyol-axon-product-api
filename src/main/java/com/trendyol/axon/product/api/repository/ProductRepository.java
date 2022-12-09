package com.trendyol.axon.product.api.repository;

import com.trendyol.axon.product.api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByIdOrTitle(String id, String title);

}