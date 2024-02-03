package com.mobilneshop.Mobilneshop.services;

import com.mobilneshop.Mobilneshop.DTOs.PurchaseDTO;
import com.mobilneshop.Mobilneshop.entity.Purchase;
import com.mobilneshop.Mobilneshop.responses.PurchaseResponse;

import java.util.List;

public interface PurchaseService {
    public Purchase createPurchase(PurchaseDTO purchaseDTO);

   public PurchaseResponse getPurchaseById(Long id);

  public   List<PurchaseResponse> getAllPurchases();
    public List<Purchase> getPurchaseHistoryForUser(Long userId);
}
