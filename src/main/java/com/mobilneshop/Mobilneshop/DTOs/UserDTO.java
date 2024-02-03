package com.mobilneshop.Mobilneshop.DTOs;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private String password;

    private List<Long> favoriteProductIds = new ArrayList<>();

}
