package com.mobilneshop.Mobilneshop.controllers;

import com.mobilneshop.Mobilneshop.DTOs.ProductDTO;
import com.mobilneshop.Mobilneshop.DTOs.UserDTO;
import com.mobilneshop.Mobilneshop.entity.Product;
import com.mobilneshop.Mobilneshop.entity.User;
import com.mobilneshop.Mobilneshop.enums.ProductCategory;
import com.mobilneshop.Mobilneshop.mappers.ProductDTOMapper;
import com.mobilneshop.Mobilneshop.mappers.ProductMapper;
import com.mobilneshop.Mobilneshop.services.ProductService;
import com.mobilneshop.Mobilneshop.services.impl.UserServiceImpl;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> fetchProducts(){
        try {
            List<ProductDTO> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        }

        @PostMapping("/{productId}/{userId}/{isFavorite}")
        public ResponseEntity<String> makeFavorite(@PathVariable Long userId, @PathVariable Long productId, @PathVariable boolean isFavorite) throws Exception {
        boolean success = productService.makeFavorite(productId,userId,isFavorite);

        if(success){
            return ResponseEntity.ok("Favorite updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid product od user ID");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ProductDTO>> getFavoriteProducts(@PathVariable Long userId)  {

        List<ProductDTO> favoriteProducts = productService.getFavoriteProductsForUser(userId);
        List<ProductDTO> favoriteProductDTOs = favoriteProducts.stream()
                .map(item -> ProductDTOMapper.INSTANCE.apply(ProductMapper.INSTANCE.apply(item)))
                .collect(Collectors.toList());
        return ResponseEntity.ok(favoriteProductDTOs);

    }

   @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> getProductByCategory(@PathVariable String category){
    List<ProductDTO> productDTOList = productService.getProductByCategory(category);

    if(productDTOList.isEmpty()){
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(productDTOList);
    }
}
