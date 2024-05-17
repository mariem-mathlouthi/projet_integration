package com.backendSpring.BackendSpring.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "demandes")
@EntityListeners(AuditingEntityListener.class)
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEtudiant", referencedColumnName = "id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "idOffreDeStage", referencedColumnName = "id")
    private Offre offreDeStage;

    @Enumerated(EnumType.STRING)
    private Statuts statut;

    private Date dateSoumission;
    private String cv;
    public void setStatus(Statuts statut) {
        this.statut = statut;
    }

    // Constructors, getters, setters
}
