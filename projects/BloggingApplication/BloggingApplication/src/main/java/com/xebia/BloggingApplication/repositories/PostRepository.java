package com.xebia.BloggingApplication.repositories;

import com.xebia.BloggingApplication.entites.Category;
import com.xebia.BloggingApplication.entites.Posts;
import com.xebia.BloggingApplication.entites.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {

    List<Posts> findAByCategory(Category category);
    List<Posts> findByUser(User user);

    @Query("select p from Posts p where p.title like :key")
    List<Posts> findByTitleContaining(@Param("key") String title);
}
