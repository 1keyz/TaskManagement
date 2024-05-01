package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select email from User where User.email=:email order by  desc limit 1" , nativeQuery = true)
    String findEmailByEmail(String email);
    
    
    
    User findUserByEmail(String email);
}
