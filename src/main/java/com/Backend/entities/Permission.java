package com.Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="permissions")
//public class Permission extends TypePermission{
public class Permission {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permission")
    private Long idpermission;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_permission;

    //
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id_user")
    private User user;

}
