package com.mobilneshop.Mobilneshop.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PurchaseItemRequest {

    private Long productId;
    private int quantity;
}