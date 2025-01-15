package com.eccomerce.Ikhlas_eccomerce.implemwntation;

import com.eccomerce.Ikhlas_eccomerce.Repository.CategoryRepository;
import com.eccomerce.Ikhlas_eccomerce.Repository.ProductRepository;
import com.eccomerce.Ikhlas_eccomerce.exception.ResourceNotFoundException;
import com.eccomerce.Ikhlas_eccomerce.model.Category;
import com.eccomerce.Ikhlas_eccomerce.model.Product;
import com.eccomerce.Ikhlas_eccomerce.payload.ProductDTO;
import com.eccomerce.Ikhlas_eccomerce.payload.ProductResponse;
import com.eccomerce.Ikhlas_eccomerce.service.CategoryService;
import com.eccomerce.Ikhlas_eccomerce.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category","categoryId",categoryId));

        product.setImage("default.png");
        product.setCategory(category);
        double specialPrice = product.getPrice() -
                ((product.getDiscount() * 0.01) * product.getPrice());
        product.setSpecialPrice(specialPrice);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOs);
        return productResponse;

    }
    }
