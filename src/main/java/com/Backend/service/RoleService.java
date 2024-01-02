package com.Backend.service;

import com.Backend.entities.Role;
import com.Backend.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    //
    private final RoleRepository roleRepository;

    public Role addRole(Role role){
        return  roleRepository.save(role);
    }
    //
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
    //
    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }
    //
    public Role getRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }
    //
    public Role updateRole(Long id, Role role){
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isPresent()){
            Role existingRole = optionalRole.get();
            existingRole.setNomRole(role.getNomRole());
            existingRole.setDescRole(role.getDescRole());
            return roleRepository.save(existingRole);
        }
        return null;
    }
    //
}
