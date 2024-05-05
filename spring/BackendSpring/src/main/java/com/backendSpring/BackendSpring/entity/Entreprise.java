package com.backendSpring.BackendSpring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "entreprises")
public class Entreprise extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroSIRET;
    private String email;
    private String password;
    private String name;
    private String secteur;
    private String logo;
    private String description;
    private String link;


    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    private List<Offre> offres;

    @ManyToMany
    @JoinTable(name = "Notifications",
            joinColumns =@JoinColumn(name = "idEntreprise"),
            inverseJoinColumns = @JoinColumn(name = "idEtudiant"))
    List<Etudiant> etudiants;





}
