package com.Backend.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Table(name="demandes")
//public class Demande extends TypePermission{
public class Demande implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permission")
    private Long idPermission;

    @Column(name = "type_permission", length = 50, nullable = false)
    private String tyPepermission;

    @Column(name = "duree_permission", nullable = false)
    private String dureePermission;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDemande;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;

    @Column(name = "libelle", nullable = false)
    private String libelle;

}
