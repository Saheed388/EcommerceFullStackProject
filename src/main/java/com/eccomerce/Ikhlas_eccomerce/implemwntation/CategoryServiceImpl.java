package com.eccomerce.Ikhlas_eccomerce.implemwntation;

import com.eccomerce.Ikhlas_eccomerce.Repository.CategoryRepository;
import com.eccomerce.Ikhlas_eccomerce.model.Category;
import com.eccomerce.Ikhlas_eccomerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        try {
            categoryRepository.delete(category);
            return "Category with categoryId: " + categoryId + " is deleted successfully";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete category");
        }
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
       Optional<Category>  saveCategoryOptional = categoryRepository.findById(categoryId);
       Category savedCategory = saveCategoryOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

       category.setCategoryId(categoryId);
       savedCategory = categoryRepository.save(category);
       return savedCategory;


    }
}
