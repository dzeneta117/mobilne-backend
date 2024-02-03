package com.mobilneshop.Mobilneshop.services;

import com.mobilneshop.Mobilneshop.DTOs.UserDTO;

import java.util.Optional;

public interface UserService {

    public UserDTO getUserById(Long id) throws Exception;

}
