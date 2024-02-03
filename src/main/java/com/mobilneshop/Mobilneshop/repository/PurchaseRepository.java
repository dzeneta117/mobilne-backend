package com.mobilneshop.Mobilneshop.repository;

import com.mobilneshop.Mobilneshop.entity.Purchase;
import com.mobilneshop.Mobilneshop.entity.PurchaseItem;
import com.mobilneshop.Mobilneshop.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByUserId(Long userId);

    List<Purchase> findAllByUser(User user);
}
