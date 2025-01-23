package com.eccomerce.Ikhlas_eccomerce.repository;

import com.eccomerce.Ikhlas_eccomerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
