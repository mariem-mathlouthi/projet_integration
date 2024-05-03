package com.backendSpring.BackendSpring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offres")
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
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

