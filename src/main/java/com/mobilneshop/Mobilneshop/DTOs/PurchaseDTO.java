package com.mobilneshop.Mobilneshop.DTOs;

import com.mobilneshop.Mobilneshop.requests.PurchaseItemRequest;
import com.mobilneshop.Mobilneshop.requests.PurchaseRequest;
import com.mobilneshop.Mobilneshop.responses.PurchaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {

    private List<PurchaseItemDTO> items;

    private LocalDateTime purchaseDate;

    private Long userId;

}
