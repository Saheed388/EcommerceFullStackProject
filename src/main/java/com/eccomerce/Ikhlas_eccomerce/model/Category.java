package com.eccomerce.Ikhlas_eccomerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private  String categoryName;

}
