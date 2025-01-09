package com.eccomerce.Ikhlas_eccomerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 5, message = "Category name must contain atleast five characters")
    private  String categoryName;

}
