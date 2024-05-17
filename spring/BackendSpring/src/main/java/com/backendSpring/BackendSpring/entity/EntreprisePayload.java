package com.backendSpring.BackendSpring.entity;

import lombok.Data;

import javax.persistence.Column;
@Data
public class EntreprisePayload {
    private String numeroSIRET;
    private String name;
    private String secteur;
    private String logo;
    private  String email;
    private String password;
    private String description;
    private String link;
}
