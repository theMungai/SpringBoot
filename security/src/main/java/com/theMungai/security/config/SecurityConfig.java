package com.theMungai.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final  JWTAuthenticationFilter jWTAuthenticationFilter;
    private final ApplicationConfig applicationConfig;

    // The bean that is responsible for configuring all HTTP security of our application
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**", "/actuator/health").permitAll()  // WHITELIST -> Endpoints that do not require any authentication
                        .anyRequest().authenticated()) // This means that any other request should be authenticated.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Session should be stateless which helps us ensure that each request is authenticated
                .authenticationProvider(applicationConfig.authenticationProvider())
                .addFilterBefore(jWTAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
