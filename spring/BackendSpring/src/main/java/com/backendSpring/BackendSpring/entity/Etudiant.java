package com.backendSpring.BackendSpring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "etudiants")
public class Etudiant extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String niveau;
    private String cin;
    private String email;
    private String password;
    private String domaine;
    private String typeStage;
    private String specialite;
    private String etablissement;
    private String image;


    @ManyToMany(mappedBy = "etudiants")
    List<Demande> demandes;

    @ManyToMany(mappedBy = "etudiants")
    List<Entreprise> entreprises;

    @ManyToMany(mappedBy = "etudiants")
    List<Offre> offres;



}

