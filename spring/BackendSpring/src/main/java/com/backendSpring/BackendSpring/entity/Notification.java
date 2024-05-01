package com.backendSpring.BackendSpring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String destination;
    private String type;
    private String visibility;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "idEtudiant")
    private Etudiant etudiant;

}
