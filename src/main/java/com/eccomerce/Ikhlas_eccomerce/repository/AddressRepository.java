package com.eccomerce.Ikhlas_eccomerce.repository;

import com.eccomerce.Ikhlas_eccomerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
