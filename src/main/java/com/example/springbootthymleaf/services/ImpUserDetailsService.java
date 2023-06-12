package com.example.springbootthymleaf.services;

import com.example.springbootthymleaf.entities.UserEntity;
import com.example.springbootthymleaf.repositories.AuthenticationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ImpUserDetailsService implements UserDetailsService {
    private final AuthenticationRepository authenticationRepository;
    public ImpUserDetailsService( AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.authenticationRepository.findById(username).orElse(null);
        return user;
    }

}
