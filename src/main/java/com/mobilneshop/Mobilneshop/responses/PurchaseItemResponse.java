package com.mobilneshop.Mobilneshop.responses;

import com.mobilneshop.Mobilneshop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItemResponse {

    private Long id;

    private Product product;

    private int quantity;
}
