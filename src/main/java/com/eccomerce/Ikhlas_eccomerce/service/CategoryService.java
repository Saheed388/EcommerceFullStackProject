package com.eccomerce.Ikhlas_eccomerce.service;

import com.eccomerce.Ikhlas_eccomerce.model.Category;
import com.eccomerce.Ikhlas_eccomerce.payload.CategoryDTO;
import com.eccomerce.Ikhlas_eccomerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategory(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
