package com.example.springbootthymleaf.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "livres")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ISBN;
    private String titre;
    private String auteur;
    private String domaine;
    private String date;
    private int nbrExemplaire;
}
