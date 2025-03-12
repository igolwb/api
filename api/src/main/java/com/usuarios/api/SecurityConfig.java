package com.usuarios.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa CSRF para permitir POST, PUT e DELETE
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) // Todos os endpoints exigem autenticação
                .httpBasic(); // Habilita autenticação básica (Postman)

        return http.build();
    }
}