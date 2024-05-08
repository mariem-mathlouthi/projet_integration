package com.backendSpring.BackendSpring.entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "entreprises")
@EntityListeners(AuditingEntityListener.class)
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroSIRET;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String secteur;
    private String logo;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String link;

    // Constructors, getters, setters
}
