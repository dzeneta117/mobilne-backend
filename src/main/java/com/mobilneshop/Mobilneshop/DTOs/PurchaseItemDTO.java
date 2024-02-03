package com.mobilneshop.Mobilneshop.DTOs;

import com.mobilneshop.Mobilneshop.entity.Product;
import com.mobilneshop.Mobilneshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItemDTO {

    private Long productId;
    private int quantity;


}
