package com.trendyol.axon.product.api.query.repository;

import com.trendyol.axon.product.api.core.domain.Product;
import com.trendyol.axon.product.api.query.rest.ProductResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("select new com.trendyol.axon.product.api.query.rest.ProductResponseModel(p.id, p.barcode, p.title, p.brand, p.category, p.description, p.price, p.quantity) " +
            "from Product p")
    List<ProductResponseModel> findAllProduct();

}