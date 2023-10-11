package com.xebia.BloggingApplication.repositories;

import com.xebia.BloggingApplication.entites.Category;
import com.xebia.BloggingApplication.payloads.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
