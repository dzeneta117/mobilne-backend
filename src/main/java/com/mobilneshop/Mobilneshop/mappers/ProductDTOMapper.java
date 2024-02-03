package com.mobilneshop.Mobilneshop.mappers;

import com.mobilneshop.Mobilneshop.DTOMapper;
import com.mobilneshop.Mobilneshop.DTOs.ProductDTO;
import com.mobilneshop.Mobilneshop.entity.Product;

public enum ProductDTOMapper implements DTOMapper<ProductDTO, Product> {
        INSTANCE;

        @Override
        public ProductDTO apply(Product item){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(item.getId());
            productDTO.setName(item.getName());
            productDTO.setImageURL(item.getImageURL());
            productDTO.setPrice(item.getPrice());
            productDTO.setDescription(item.getDescription());
            productDTO.setCategory(item.getCategory());

            return productDTO;
        }
}
