package com.example.taskmanagement.security;

import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.security.helper.TokenHelper;
import com.example.taskmanagement.service.abstracts.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private TokenHelper tokenHelper;
    private  UserDetailsService userDetailsService;
    private  UserService userService;

    public JwtAuthenticationFilter(TokenHelper tokenHelper, UserDetailsService userDetailsService, UserService userService) {
        this.tokenHelper = tokenHelper;
        this.userDetailsService = userDetailsService;
        this.userService = userService;

  
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        final String autHeader = request.getHeader("Authorization");
        String token = null;
        String email  = null;

        if (autHeader != null){
            token = autHeader.substring(7);
        }


        if (token != null){
            email = tokenHelper.extractUser(token);
            if (email != null){
                User user = userService.getByUserWithEmail(email);
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        user.getEmail(),user.getPassword(),userDetails.getAuthorities()
                );
                authentication.setDetails(userDetails);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);
    }
}
