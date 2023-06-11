package com.example.springbootthymleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.builder().username("user").password("{noop}123").authorities("USER").build(),
                User.builder().username("admin").password("{noop}123").authorities("ADMIN", "USER").build()

        );
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .failureForwardUrl("/login")
                        .defaultSuccessUrl("/home", true)

                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                )

                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("saveMsg", "formMsg","editMsg/**","deleteMsg/**")
                        .hasAnyAuthority("ADMIN")
                        .anyRequest()
                        .authenticated()


                )
        ;

        return httpSecurity.build();
    }


}
