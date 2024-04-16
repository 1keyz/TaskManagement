package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.entity.UserVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserVerificationRepository extends JpaRepository<UserVerification,Long> {

    @Query(value = "select * from user_verifications where user_verifications.user_id = :userId" +
            " and user_verifications.code = :code" , nativeQuery = true)
    Optional<UserVerification> userVerificationIsExist(@Param(value = "userId") int userId ,@Param(value = "code") String code);


}
