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
@Table(name="roles")
public class Role {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idrole;
    @Column(name = "nom_role", length = 50, nullable = false)
    private String nomrole;

    @Column(name = "desc_role", length = 100, nullable = true)
    private String descrole;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;
}
