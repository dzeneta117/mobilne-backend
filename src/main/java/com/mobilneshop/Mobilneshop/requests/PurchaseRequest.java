package com.mobilneshop.Mobilneshop.requests;

import com.mobilneshop.Mobilneshop.DTOs.PurchaseItemDTO;
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
public class PurchaseRequest {

        private List<PurchaseItemRequest> items;

        private LocalDateTime purchaseDate;

        private Long userId;

}
