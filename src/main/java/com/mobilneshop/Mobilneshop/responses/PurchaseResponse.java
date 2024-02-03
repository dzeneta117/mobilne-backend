package com.mobilneshop.Mobilneshop.responses;

import com.mobilneshop.Mobilneshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {

    private Long id;
    private LocalDateTime purchaseDate;

    private String email;

    private List<PurchaseItemResponse> items;

    private double total;
}
