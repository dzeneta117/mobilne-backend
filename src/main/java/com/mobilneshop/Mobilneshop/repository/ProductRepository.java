package com.mobilneshop.Mobilneshop.repository;

import com.mobilneshop.Mobilneshop.DTOs.ProductDTO;
import com.mobilneshop.Mobilneshop.entity.Product;
import com.mobilneshop.Mobilneshop.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(ProductCategory category);
}
