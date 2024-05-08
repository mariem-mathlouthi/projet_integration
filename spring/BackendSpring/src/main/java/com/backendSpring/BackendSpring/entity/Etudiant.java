package com.backendSpring.BackendSpring.entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
@EntityListeners(AuditingEntityListener.class)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String niveau;
    @Column(unique = true)
    private String cin;
    @Column(unique = true)
    private String email;
    private String password;
    private String domaine;
    private String typeStage;
    private String specialite;
    private String etablissement;
    private String image;

    // Constructors, getters, setters
}


