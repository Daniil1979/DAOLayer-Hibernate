package com.example.daolayerhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class UserDetailsConfig {

    @Bean
    public UserDetailsManager userDetailsService() {
        UserDetails reader = User.builder()
                .username("reader")
                .password("{noop}read123")
                .roles("READ")
                .build();

        UserDetails writer = User.builder()
                .username("writer")
                .password("{noop}write123")
                .roles("WRITE")
                .build();

        UserDetails deleter = User.builder()
                .username("deleter")
                .password("{noop}delete123")
                .roles("DELETE")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123")
                .roles("READ", "WRITE", "DELETE")
                .build();

        return new InMemoryUserDetailsManager(reader, writer, deleter, admin);
    }
}