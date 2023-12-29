package com.Backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@Entity
@Table(name="demandes")
//public class Demande extends TypePermission{
public class Demande {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permission")
    private Long idpermission;

    @Column(name = "type_permission", length = 50, nullable = false)
    private String typepermission;

    @Column(name = "duree_permission", nullable = false)
    private String dureepermission;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_demande;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_debut;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_fin;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    //
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id_user")
//    private User user;
    //

    public Demande() {
    }
    //

    public Demande(String typepermission, String dureepermission, Date date_demande, Date date_debut, Date date_fin, String libelle) {
        this.typepermission = typepermission;
        this.dureepermission = dureepermission;
        this.date_demande = date_demande;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.libelle = libelle;
    }
    //


}
