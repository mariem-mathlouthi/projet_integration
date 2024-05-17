package com.backendSpring.BackendSpring.entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
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
@EntityListeners(AuditingEntityListener.class)
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_entreprise", referencedColumnName = "id")
    private Entreprise entreprise;

    @Enumerated(EnumType.STRING)
    private Statuts status;

    private String titre;
    private String description;
    private String domaine;
    private Date dateDebut;
    private Date dateFin;
    private String typeOffre;
    private String cahierCharge;

    // Constructors, getters, setters
}


