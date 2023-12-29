package com.Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="personnels")
public class Personnel {
    //
    @Id
    @Column(name="id_personnel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpersonnel;

    @Column(name="prenom", length = 50)
    private String prenom;

    @Column(name="nom", length = 50)
    private String nom;

    @Column(name = "contact", length = 50, nullable = true)
    private String contact;
    //
    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = false, referencedColumnName = "id_service")
    private Service service;
}
