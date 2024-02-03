package com.mobilneshop.Mobilneshop.services;

import com.mobilneshop.Mobilneshop.DTOs.ProductDTO;
import com.mobilneshop.Mobilneshop.enums.ProductCategory;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> getAllProducts();

    public ProductDTO getProductById(Long id) throws Exception;

    public boolean makeFavorite(Long productId, Long userId, boolean isFavorite);

    public List<ProductDTO> getFavoriteProductsForUser(Long userId);
    public List<ProductDTO> getProductByCategory(String category);
      public ProductCategory getProductCategory(String categoryString);

}
