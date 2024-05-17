package com.backendSpring.BackendSpring.entity;

import lombok.Data;

import javax.persistence.Column;
@Data
public class EtudiantPayload {
    private String fullname;
    private String niveau;
    private  String email;
    private String password;
    private String cin;
    private String domaine;
    private String typeStage;
    private String specialite;
    private String etablissement;
    private String image;
}
