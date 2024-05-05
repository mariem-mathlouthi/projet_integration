package com.backendSpring.BackendSpring.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offres")
@JsonIgnoreProperties({"entreprise"})

public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEntreprise",nullable = false)
    private Entreprise entreprise;

    @OneToMany(mappedBy = "offreDeStage", cascade = CascadeType.ALL)
    private List<Demande> demandes;

    @ManyToMany
    @JoinTable(
            name = "offre_etudiant",
            joinColumns = @JoinColumn(name = "idOffre"),
            inverseJoinColumns = @JoinColumn(name = "idEtudiant")
    )
    private List<Etudiant> etudiants;

    private String status;
    private String titre;
    private String description;
    private String domaine;
    private Date dateDebut;
    private Date dateFin;
    private String typeOffre;
    private String cahierCharge;


}

