package com.mobilneshop.Mobilneshop.services.impl;

import com.mobilneshop.Mobilneshop.DTOs.PurchaseDTO;
import com.mobilneshop.Mobilneshop.DTOs.PurchaseItemDTO;
import com.mobilneshop.Mobilneshop.entity.Product;
import com.mobilneshop.Mobilneshop.entity.Purchase;
import com.mobilneshop.Mobilneshop.entity.PurchaseItem;
import com.mobilneshop.Mobilneshop.entity.User;
import com.mobilneshop.Mobilneshop.repository.ProductRepository;
import com.mobilneshop.Mobilneshop.repository.PurchaseRepository;
import com.mobilneshop.Mobilneshop.repository.UserRepository;
import com.mobilneshop.Mobilneshop.responses.PurchaseItemResponse;
import com.mobilneshop.Mobilneshop.responses.PurchaseResponse;
import com.mobilneshop.Mobilneshop.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;


    @Override
    public Purchase createPurchase(PurchaseDTO purchaseDTO) {

        User user = userRepository.findById(purchaseDTO.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));

        List<PurchaseItem> items = new ArrayList<>();
        Purchase purchase = new Purchase();
        for (PurchaseItemDTO itemDTO : purchaseDTO.getItems()){
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(()->new RuntimeException("Product not found"));


            PurchaseItem item = new PurchaseItem();
            item.setProduct(product);
            item.setQuantity(itemDTO.getQuantity());
            item.setPurchase(purchase);
            items.add(item);
        }


        purchase.setItems(items);
        LocalDateTime lt = LocalDateTime.now();
        purchase.setPurchaseDate(lt);
        purchase.setUser(user);

        double totalPrice = items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();
        purchase.setTotal(totalPrice);
        return purchaseRepository.save(purchase);
    }



    @Override
    public PurchaseResponse getPurchaseById(Long id){
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Purchase not found"));

        List<PurchaseItemResponse> itemResponses = purchase.getItems()
                .stream()
                .map(item -> new PurchaseItemResponse(item.getId(), item.getProduct(), item.getQuantity()))
                .collect(Collectors.toList());

        return new PurchaseResponse(purchase.getId(), purchase.getPurchaseDate(),purchase.getUser().getEmail(), itemResponses, purchase.getTotal());
    }

    public List<Purchase> getPurchaseHistoryForUser(Long userId){
        return purchaseRepository.findByUserId(userId);
    }
    @Override
    public List<PurchaseResponse> getAllPurchases(){
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private PurchaseResponse mapToResponse(Purchase purchase) {
        List<PurchaseItemResponse> itemResponses = purchase.getItems()
                .stream()
                .map(item -> new PurchaseItemResponse(item.getId(), item.getProduct(), item.getQuantity()))
                .collect(Collectors.toList());

        return new PurchaseResponse(purchase.getId(), purchase.getPurchaseDate(), purchase.getUser().getEmail(), itemResponses, purchase.getTotal());
    }
}
