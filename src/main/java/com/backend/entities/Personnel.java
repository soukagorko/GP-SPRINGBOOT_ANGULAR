package com.backend.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="personnels")
public class Personnel {
    //
    @Id
    @Column(name="id_personnel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonnel;

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
