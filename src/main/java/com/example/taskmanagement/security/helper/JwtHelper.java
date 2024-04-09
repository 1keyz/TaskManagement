package com.example.taskmanagement.security.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtHelper implements TokenHelper{
    @Value("${jwt.key}")
    private String SECRET;

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, email);
    }
    public boolean validateToken(String token , UserDetails userDetails){ // token ile kullanıcı bilgilerinin doğruluğunu kontrol eder
        String email = extractUser(token);
        Date expirationDate = extractExpiration(token);
        return userDetails.getUsername().equals(email) && !expirationDate.before(new Date());
    }
    public String extractUser(String token) { // parametredeki tokendan kullanıcı bilgilerini alarak username ya da email döner
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public Date extractExpiration(String token) { // Jwt nin içindeki son kullanım tarihini çıkarttığımız method
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token) // jwt'nin imzalanmış olduğunu doğrular ve içindeki bilgileri çıkartır
                .getBody();
        return claims.getExpiration();
    }
    public String createToken(Map<String,Object> claims , String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis())) // tokenın oluşturulduğu zaman
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2 )) // tokenin ne kadar kullanılabilir olacağı
                .signWith(getSignKey(), SignatureAlgorithm.HS256) // imza anahtarını belirlediğimiz kısım
                .compact(); // Jwt'yi string olarak döndürüyor
    }

    public Key getSignKey(){ // imza anahtarını hazırladığımız method
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
