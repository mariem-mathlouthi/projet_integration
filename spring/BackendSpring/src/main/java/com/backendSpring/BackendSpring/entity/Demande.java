package com.backendSpring.BackendSpring.entity;

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
@Table(name = "demandes")
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Etudiant> etudiants;

    @ManyToOne
    @JoinColumn(name = "idOffre")
    private Offre offreDeStage;

    private String statut;
    private Date DateSoumission;
    private String cv;

    public void setStatus(String status) {
        this.statut=status;
    }
}
