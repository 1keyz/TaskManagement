package com.example.taskmanagement.security.serviceimpl;


import com.example.taskmanagement.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class Security {
    private JwtAuthenticationFilter JwtAuthenticationFilter;
    private DelegatedAuthenticationEntryPoint entryPoint;
    private CustomAccesDeniedHandler accesDeniedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
                .csrf(AbstractHttpConfigurer :: disable)
              .exceptionHandling(exc -> exc.authenticationEntryPoint(entryPoint).accessDeniedHandler(accesDeniedHandler))
               .authorizeHttpRequests(x ->
                        x
                                .requestMatchers("/auth/register","/auth/login")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
               .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
               .build();
    }
}
