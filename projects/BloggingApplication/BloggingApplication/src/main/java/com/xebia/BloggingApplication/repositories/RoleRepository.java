package com.xebia.BloggingApplication.repositories;

import com.xebia.BloggingApplication.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
