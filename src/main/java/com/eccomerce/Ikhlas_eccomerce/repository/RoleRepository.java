package com.eccomerce.Ikhlas_eccomerce.repository;

import com.eccomerce.Ikhlas_eccomerce.model.AppRole;
import com.eccomerce.Ikhlas_eccomerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
