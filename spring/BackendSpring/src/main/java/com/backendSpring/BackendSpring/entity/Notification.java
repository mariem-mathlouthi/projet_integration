package com.backendSpring.BackendSpring.entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name = "notifications")
@EntityListeners(AuditingEntityListener.class)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEtudiant", referencedColumnName = "id")
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(name = "idEntreprise", referencedColumnName = "id")
    private Entreprise entreprise;

    private  String titre;
    private String message;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;
    private Date date;

    // Constructors, getters, setters
}
