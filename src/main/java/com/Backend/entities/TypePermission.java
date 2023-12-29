package com.Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="type_permissions")
@Inheritance(strategy=InheritanceType.JOINED)
//public abstract class TypePermission implements Serializable {
public class TypePermission {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_permission")
    private Long idtypepermission;
    @Column(name = "nom_type_permission", length = 50, nullable = false)
    private String nomtypepermission;

//    @Column(name = "duree_type_permission", length = 100, nullable = true)
//    private String dureetypepermission;
}
