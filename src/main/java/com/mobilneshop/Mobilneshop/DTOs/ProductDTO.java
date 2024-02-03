package com.mobilneshop.Mobilneshop.DTOs;

import com.mobilneshop.Mobilneshop.enums.ProductCategory;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    private String name;

    private String imageURL;


    private double price;

    private String description;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;


}

