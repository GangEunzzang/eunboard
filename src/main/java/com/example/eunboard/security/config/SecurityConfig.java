package com.example.eunboard.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

import com.example.eunboard.security.JwtAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers("/**")
                .permitAll()
                .anyRequest().authenticated();

        http.addFilterAfter(
                jwtAuthenticationFilter,
                CorsFilter.class);

        return http.build();
    }

}
