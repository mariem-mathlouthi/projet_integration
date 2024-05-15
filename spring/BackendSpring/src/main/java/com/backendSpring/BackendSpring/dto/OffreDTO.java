package com.backendSpring.BackendSpring.dto;

import com.backendSpring.BackendSpring.entity.Statuts;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
public class OffreDTO {
    private Long id;
    private Statuts status;
    private String titre;
    private String description;
    private String domaine;
    private Date dateDebut;
    private Date dateFin;
    private String typeOffre;
    private String cahierCharge;

}
