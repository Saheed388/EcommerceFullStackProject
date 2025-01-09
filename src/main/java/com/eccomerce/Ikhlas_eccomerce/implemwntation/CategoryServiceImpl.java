package com.eccomerce.Ikhlas_eccomerce.implemwntation;

import com.eccomerce.Ikhlas_eccomerce.Repository.CategoryRepository;
import com.eccomerce.Ikhlas_eccomerce.exception.ApiExceptions;
import com.eccomerce.Ikhlas_eccomerce.exception.ResourceNotFoundException;
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
// Checking if any category is present
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty())
            throw new ApiExceptions("No Category created yet");
        return categories;
    }

    @Override
    public void createCategory(Category category) {
//        This code handle if Category Name already exist
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory != null) {
            throw new ApiExceptions( "Category already exists " + savedCategory.getCategoryName() + " already exist !!!");
        }
//        This part save the name
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId", categoryId));

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
       Category savedCategory = saveCategoryOptional.orElseThrow(() -> new ResourceNotFoundException("Category","categoryId", categoryId));

       category.setCategoryId(categoryId);
       savedCategory = categoryRepository.save(category);
       return savedCategory;


    }
}
