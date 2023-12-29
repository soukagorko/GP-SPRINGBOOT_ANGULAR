package com.Backend.controller;

import com.Backend.entities.Role;
import com.Backend.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RoleController {
    //
    private final RoleService roleService;

    @PostMapping("/save")
    public Role createRole(@RequestBody Role role){
        return roleService.addRole(role);
    }
    //
    @GetMapping("")
    public List<Role> readAllRoles(){
        return roleService.getAllRoles();
    }
    //
    @DeleteMapping("/delete/{id}")
    public void supprimerRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }
    //
    @GetMapping("/detail/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        Role role = roleService.getRoleById(id);
        if(role==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(role);
    }
    //
    @PutMapping("/update/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id, @RequestBody Role role){
        Role updateRole = roleService.updateRole(id, role);
        if(updateRole==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateRole);
    }
    //
}
