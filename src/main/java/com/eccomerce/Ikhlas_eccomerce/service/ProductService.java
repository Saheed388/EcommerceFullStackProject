package com.eccomerce.Ikhlas_eccomerce.service;

import com.eccomerce.Ikhlas_eccomerce.model.Product;
import com.eccomerce.Ikhlas_eccomerce.payload.ProductDTO;
import com.eccomerce.Ikhlas_eccomerce.payload.ProductResponse;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService {


    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();
}

