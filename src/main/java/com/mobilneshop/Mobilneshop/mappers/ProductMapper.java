package com.mobilneshop.Mobilneshop.mappers;

import com.mobilneshop.Mobilneshop.DTOMapper;
import com.mobilneshop.Mobilneshop.DTOs.ProductDTO;
import com.mobilneshop.Mobilneshop.entity.Product;

public enum ProductMapper  implements DTOMapper<Product, ProductDTO> {
    INSTANCE;

    @Override
    public Product apply(ProductDTO item) {
        Product product = new Product();
        product.setId(item.getId());
        product.setName(item.getName());
        product.setDescription(item.getDescription());

        product.setPrice(item.getPrice());
        product.setImageURL(item.getImageURL());
        product.setCategory(item.getCategory());
        return product;
    }
}
