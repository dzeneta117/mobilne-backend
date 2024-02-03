package com.mobilneshop.Mobilneshop.mappers;

import com.mobilneshop.Mobilneshop.DTOMapper;
import com.mobilneshop.Mobilneshop.DTOs.UserDTO;
import com.mobilneshop.Mobilneshop.entity.User;

public enum UserDTOMapper implements DTOMapper<UserDTO, User> {
    INSTANCE;

    @Override
    public UserDTO apply(User item) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(item.getId());
        userDTO.setEmail(item.getEmail());
        userDTO.setAddress(item.getAddress());
        userDTO.setPassword(item.getPassword());
        userDTO.setFavoriteProductIds(item.getFavoriteProductIds());
        return userDTO;
    }
}
