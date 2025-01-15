package com.eccomerce.Ikhlas_eccomerce.implemwntation;

import com.eccomerce.Ikhlas_eccomerce.Repository.CategoryRepository;
import com.eccomerce.Ikhlas_eccomerce.exception.ApiExceptions;
import com.eccomerce.Ikhlas_eccomerce.exception.ResourceNotFoundException;
import com.eccomerce.Ikhlas_eccomerce.model.Category;
import com.eccomerce.Ikhlas_eccomerce.payload.CategoryDTO;
import com.eccomerce.Ikhlas_eccomerce.payload.CategoryResponse;
import com.eccomerce.Ikhlas_eccomerce.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategory(Integer pageNumber, Integer pageSize,  String sortBy, String sortOrder) {

        Sort sortBYAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

// Pagination
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortBYAndOrder);
        Page<Category> categoryPage = categoryRepository.findAll(pageDetails);

// Checking if any category is present
        List<Category> categories = categoryPage.getContent();
        if(categories.isEmpty())
            throw new ApiExceptions("No Category created yet");
//        For every Category modelMapper will covert it to object of type category dto

        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);

//        Geting the page metedata
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setLastPage(categoryPage.isLast());

        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
//        This code handle if Category Name already exist
        Category CategoryFromDb = categoryRepository.findByCategoryName(category.getCategoryName());
        if(CategoryFromDb != null) {
            throw new ApiExceptions( "Category already exists " + CategoryFromDb.getCategoryName() + " already exist !!!");
        }
//        This part save the name
       Category savedCategory = categoryRepository.save(category);
        CategoryDTO savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId", categoryId));


            categoryRepository.delete(category);
            return modelMapper.map(category, CategoryDTO.class);

    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
       Category savedCategory = categoryRepository.findById(categoryId)
               .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId", categoryId));

      Category category = modelMapper.map(categoryDTO, Category.class);
       category.setCategoryId(categoryId);
       savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);


    }
}
