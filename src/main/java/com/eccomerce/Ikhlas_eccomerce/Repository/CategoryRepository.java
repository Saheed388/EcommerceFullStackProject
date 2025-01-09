package com.eccomerce.Ikhlas_eccomerce.Repository;

import com.eccomerce.Ikhlas_eccomerce.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(@NotBlank @Size(min = 5, message = "Category name must contain at least five characters") String categoryName);
}
