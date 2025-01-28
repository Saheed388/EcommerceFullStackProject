package com.eccomerce.Ikhlas_eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eccomerce.Ikhlas_eccomerce.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}