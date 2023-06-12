package com.example.springbootthymleaf.repositories;

import com.example.springbootthymleaf.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthenticationRepository extends JpaRepository<UserEntity,String> {



}
