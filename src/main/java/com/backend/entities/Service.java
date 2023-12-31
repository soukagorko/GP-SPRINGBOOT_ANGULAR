package com.backend.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="services")
public class Service {
    //
    @Id
    @Column(name = "id_service")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;

    @Column(name = "nom_service", length = 50, nullable=false)
    private String nomService;

    @Column(name = "sigle_service", length = 20, nullable=true)
    private String sigleService;

    @Column(name = "desc_service", length = 100, nullable=true)
    private String descService;

    @Column(name = "contact_service", length = 30, nullable=true)
    private String contactService;

    @Column(name = "service_parent_id", length = 30, nullable=true)
    private String serviceParentId;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Personnel>  personnels;

}
