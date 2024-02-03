package com.mobilneshop.Mobilneshop.controllers;

import com.mobilneshop.Mobilneshop.DTOs.PurchaseDTO;
import com.mobilneshop.Mobilneshop.entity.Purchase;
import com.mobilneshop.Mobilneshop.requests.PurchaseRequest;
import com.mobilneshop.Mobilneshop.responses.PurchaseItemResponse;
import com.mobilneshop.Mobilneshop.responses.PurchaseResponse;
import com.mobilneshop.Mobilneshop.services.PurchaseService;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @PostMapping
    public ResponseEntity<?> createPurchase(@RequestBody PurchaseDTO purchaseDTO){
      try {
          Purchase purchase = purchaseService.createPurchase(purchaseDTO);
          return ResponseEntity.ok(purchase);
      } catch(InvalidPropertyException e){
          return ResponseEntity.badRequest().body(e.getMessage());
      } catch (Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseById(@PathVariable Long id){
        try {
            PurchaseResponse response = purchaseService.getPurchaseById(id);
            return ResponseEntity.ok(response);
        } catch (InvalidPropertyException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResponse>> getAllPurchases(){
        List<PurchaseResponse> responses = purchaseService.getAllPurchases();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Purchase>> getPurchaseHistoryForUser(@PathVariable Long userId){
        List<Purchase> purchases = purchaseService.getPurchaseHistoryForUser(userId);

        if(purchases.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(purchases);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
