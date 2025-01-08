package com.eccomerce.Ikhlas_eccomerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "CategoryTable")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long categoryId;
    private  String categoryName;

}
