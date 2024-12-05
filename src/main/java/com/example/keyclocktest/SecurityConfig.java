package com.example.keyclocktest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/hello").authenticated() // Sadece kimlik doğrulaması yapılmış kullanıcıların erişmesine izin ver
                                .anyRequest().permitAll()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .authorizationEndpoint(authorizationEndpoint ->
                                        authorizationEndpoint.baseUri("/oauth2/authorization")
                                )
                                .redirectionEndpoint(redirectionEndpoint ->
                                        redirectionEndpoint.baseUri("/oauth2/callback/*")
                                )
                );

        return http.build();
    }
}
