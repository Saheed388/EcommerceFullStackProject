package com.eccomerce.Ikhlas_eccomerce.implemwntation;

import com.eccomerce.Ikhlas_eccomerce.Repository.CategoryRepository;
import com.eccomerce.Ikhlas_eccomerce.model.Category;
import com.eccomerce.Ikhlas_eccomerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
//    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll() ;
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        if(category == null)
            return "Category not found";

        categoryRepository.delete(category);
        return "Category with categoryId : "+ categoryId + " is deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        List<Category> categories = categoryRepository.findAll() ;

        Optional< Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();
        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            categoryRepository.save(existingCategory);
            return existingCategory;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }

    }
}
