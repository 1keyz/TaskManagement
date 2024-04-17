package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.entity.UserVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserVerificationRepository extends JpaRepository<UserVerification,Long> {

    @Query(value = "select * from user_verifications where user_verifications.user_id = :userId" +
            " and user_verifications.code = :code" , nativeQuery = true)
    Optional<UserVerification> getUserVerificationByCodeAndUserId(@Param(value = "userId") int userId , @Param(value = "code") String code);


    @Query(value = "SELECT code FROM user_verifications WHERE user_verifications.user_id = :userId" , nativeQuery = true)
    List<String> getUserVerificationAllCodeWithUserId(@Param(value = "userId") int userId);
}
