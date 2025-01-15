package com.eccomerce.Ikhlas_eccomerce.Repository;

import com.eccomerce.Ikhlas_eccomerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
