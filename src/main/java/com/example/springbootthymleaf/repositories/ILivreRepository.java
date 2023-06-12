package com.example.springbootthymleaf.repositories;

import com.example.springbootthymleaf.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILivreRepository extends JpaRepository<Livre,Long> {
}
