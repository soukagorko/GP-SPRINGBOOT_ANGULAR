package com.Backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="services")
public class Service {
    //
    @Id
    @Column(name = "id_service")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idservice;

    @Column(name = "nom_service", length = 50, nullable=false)
    private String nomservice;

    @Column(name = "sigle_service", length = 20, nullable=true)
    private String sigleservice;

    @Column(name = "desc_service", length = 100, nullable=true)
    private String descservice;

    @Column(name = "contact_service", length = 30, nullable=true)
    private String contactservice;

    @Column(name = "service_parent_id", length = 30, nullable=true)
    private String serviceparentid;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Personnel>  personnels;
//    @OneToMany(mappedBy = "customer") // un client avec +sieurs compte. dans la class BankAccount, il y'a un attribut qui sappelle customer
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// Permet d'ignorer la liste de compte lors de l'affichage de des clients
//    private List<BankAccount> bankAccounts;
}
