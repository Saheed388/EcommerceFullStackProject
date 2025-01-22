package com.eccomerce.Ikhlas_eccomerce.Repository;

import com.eccomerce.Ikhlas_eccomerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findByUserName(String username);
}
