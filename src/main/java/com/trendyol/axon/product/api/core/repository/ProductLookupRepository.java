package com.trendyol.axon.product.api.core.repository;

import com.trendyol.axon.product.api.core.domain.ProductLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLookupRepository extends JpaRepository<ProductLookup, String> {
    boolean existsProductByBarcode(String barcode);
}