package com.example.springbootthymleaf.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Roles {
    @Id
    private Long id;
    String role;
}
