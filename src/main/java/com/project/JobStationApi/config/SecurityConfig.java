package com.project.JobStationApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",        // for Swagger UI static files
                                "/v3/api-docs/**",       // for OpenAPI spec
                                "/swagger-ui.html"       // for main Swagger UI page (legacy URL)
                        ).permitAll()                // allow without auth
                        .anyRequest().authenticated() // everything else requires Basic Auth
                )
                .httpBasic(Customizer.withDefaults()); // enable Basic Auth

        return http.build();
    }

}
