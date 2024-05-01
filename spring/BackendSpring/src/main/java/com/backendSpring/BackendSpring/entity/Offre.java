package com.backendSpring.BackendSpring.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "offres")
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private Entreprise entreprise;


    private String status;
    private String titre;
    private String description;
    private String domaine;
    private Date dateDebut;
    private Date dateFin;
    private String typeOffre;
    private String cahierCharge;

}

