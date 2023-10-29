package com.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {
    // creating Basic Authorization using http security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http     .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/public/userlogin")
                                .permitAll()
                                .anyRequest().authenticated()
                )

                .formLogin(login -> login
                        .loginPage("/public/userlogin")
                        .loginProcessingUrl("/dologin")
                        .defaultSuccessUrl("/users"));
                        
        return http.build();
    }
    //in memory Authorization
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
    	UserDetails userDetails = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
    			.username("Akshay")
    			.password("789456")
    			.roles("user")
    			.build();
    	return new InMemoryUserDetailsManager(userDetails);
    }
    //page customization
  
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder(10);
    }

}
