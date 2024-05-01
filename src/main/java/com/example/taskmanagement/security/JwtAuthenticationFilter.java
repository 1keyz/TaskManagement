package com.example.taskmanagement.security;

import com.example.taskmanagement.core.utils.exception.types.CustomAuthenticationException;
import com.example.taskmanagement.model.entity.User;
import com.example.taskmanagement.security.helper.TokenHelper;
import com.example.taskmanagement.security.serviceimpl.DelegatedAuthenticationEntryPoint;
import com.example.taskmanagement.service.abstracts.UserService;
import io.jsonwebtoken.JwtException;
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
    private UserDetailsService userDetailsService;
    private UserService userService;
    private DelegatedAuthenticationEntryPoint entryPoint;
    public JwtAuthenticationFilter(TokenHelper tokenHelper, UserDetailsService userDetailsService, UserService userService, DelegatedAuthenticationEntryPoint entryPoint) {
        this.tokenHelper = tokenHelper;
        this.userDetailsService = userDetailsService;
        this.userService = userService;


        this.entryPoint = entryPoint;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String autHeader = request.getHeader("Authorization");

        String token = null;
        String email;

        if (autHeader != null){
            token = autHeader.substring(7);
        }

        if (token != null){
            try {
                email = tokenHelper.extractUser(token);
            }catch (JwtException ex){
                throw new CustomAuthenticationException("Acces denied");
            }
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            if (tokenHelper.validateToken(token,userDetails)){
                User user = userService.getByEmail(email);

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
