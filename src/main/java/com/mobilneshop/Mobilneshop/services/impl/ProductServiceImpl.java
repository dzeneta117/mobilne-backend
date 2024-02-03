package com.mobilneshop.Mobilneshop.services.impl;

import com.mobilneshop.Mobilneshop.DTOs.ProductDTO;
import com.mobilneshop.Mobilneshop.DTOs.UserDTO;
import com.mobilneshop.Mobilneshop.entity.Product;
import com.mobilneshop.Mobilneshop.entity.User;
import com.mobilneshop.Mobilneshop.enums.ProductCategory;
import com.mobilneshop.Mobilneshop.mappers.ProductDTOMapper;
import com.mobilneshop.Mobilneshop.mappers.ProductMapper;
import com.mobilneshop.Mobilneshop.repository.ProductRepository;
import com.mobilneshop.Mobilneshop.repository.UserRepository;
import com.mobilneshop.Mobilneshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(ProductDTOMapper.INSTANCE::apply).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Id product not found"));

        return ProductDTOMapper.INSTANCE.apply(product);
    }

    public boolean makeFavorite(Long productId, Long userId, boolean isFavorite) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalProduct.isPresent() && optionalUser.isPresent()) {
            Product product = optionalProduct.get();
            User user = optionalUser.get();

            if (isFavorite) {
                List<Long> favoriteProductIds = user.getFavoriteProductIds();
                favoriteProductIds.add(productId);
                user.setFavoriteProductIds(favoriteProductIds);

                userRepository.save(user);

                return true;
            } else {
                List<Long> favoriteProductsIds = user.getFavoriteProductIds();
                favoriteProductsIds.remove(productId);
                user.setFavoriteProductIds(favoriteProductsIds);

                userRepository.save(user);

                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<ProductDTO> getFavoriteProductsForUser(Long userId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Long> favoriteProductIds = user.getFavoriteProductIds();
            return productRepository.findAll().stream()
                    .filter(product -> favoriteProductIds.contains(product.getId()))
                    .map(item -> ProductDTOMapper.INSTANCE.apply(item))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProductDTO> getProductByCategory(String category) {
        ProductCategory productCategory = getProductCategory(category);

        if(productCategory == null) {
            return null;
        }

        List<Product> productList = productRepository.findByCategory(productCategory);
        return productList.stream().map(item->ProductDTOMapper.INSTANCE.apply(item)).collect(Collectors.toList());
    }

    public ProductCategory getProductCategory(String categoryString) {
        try{
            return ProductCategory.valueOf(categoryString.toUpperCase());
        } catch (IllegalArgumentException ex){
            return null;
        }

    }
}


