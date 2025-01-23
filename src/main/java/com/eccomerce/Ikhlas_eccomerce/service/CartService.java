package com.eccomerce.Ikhlas_eccomerce.service;

import com.eccomerce.Ikhlas_eccomerce.payload.CartDTO;

public interface CartService  {
    CartDTO addProductToCart(Long productId, Integer quantity);
}
