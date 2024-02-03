package com.mobilneshop.Mobilneshop.repository;

import com.mobilneshop.Mobilneshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String username);


    Boolean existsByEmail(String email);
}
