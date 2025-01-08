package com.eccomerce.Ikhlas_eccomerce.model;

import jakarta.persistence.*;


@Entity
@Table(name = "CategoryTable")


public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long categoryId;
    private  String categoryName;

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {
    }
}
