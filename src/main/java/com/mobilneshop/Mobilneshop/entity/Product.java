package com.mobilneshop.Mobilneshop.entity;

import com.mobilneshop.Mobilneshop.enums.ProductCategory;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String imageURL;

    @NotNull
    private double price;

    @NotNull
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProductCategory category;


}
