package com.its.quiz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public DaoAuthenticationProvider authProvider(QuizUserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers("/", 
            						 "/login", 
            						 "/register", 
            						 "/css/**",
            						 "/flags/**",
            						 "/img/**",
            						 "/js/**").permitAll()
            		.anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .permitAll()
            )
            .logout(logout -> logout
                    .logoutUrl("/logout")         
                    .logoutSuccessUrl("/login")       
                    .invalidateHttpSession(true)                 
                    .clearAuthentication(true)                   
                    .deleteCookies("JSESSIONID")               
                )
            .build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
