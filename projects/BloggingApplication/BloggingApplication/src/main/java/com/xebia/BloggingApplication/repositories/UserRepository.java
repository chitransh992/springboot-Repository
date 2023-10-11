package com.xebia.BloggingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xebia.BloggingApplication.entites.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
