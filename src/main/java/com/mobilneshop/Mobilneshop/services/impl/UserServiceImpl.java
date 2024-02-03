package com.mobilneshop.Mobilneshop.services.impl;


import com.mobilneshop.Mobilneshop.DTOs.UserDTO;
import com.mobilneshop.Mobilneshop.entity.User;
import com.mobilneshop.Mobilneshop.mappers.UserDTOMapper;
import com.mobilneshop.Mobilneshop.repository.UserRepository;
import com.mobilneshop.Mobilneshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;


    @Override
    public UserDTO getUserById(Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(()->new Exception("User with this id not found"));
        return UserDTOMapper.INSTANCE.apply(user);
    }



}
