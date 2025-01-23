package com.eccomerce.Ikhlas_eccomerce.repository;

import com.eccomerce.Ikhlas_eccomerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(String categoryName);
}
