package com.example.taskmanagement.security.helper;

import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public interface TokenHelper {
    String generateToken(String email);
    boolean validateToken(String token , UserDetails userDetails);
    String extractUser(String token);
    Date extractExpiration(String token);
    String createToken(Map<String,Object> claims , String userName);
    Key getSignKey();

}
