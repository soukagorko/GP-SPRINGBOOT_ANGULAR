package com.Backend.service;

import com.Backend.entities.User;
import com.Backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    //
    private final UserRepository userRepository;

    public User addUser(User user){
        return  userRepository.save(user);
    }
    //
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    //
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    //
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    //
    public User updateUser(Long id, User user){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            existingUser.setPrenom(user.getPrenom());
            existingUser.setNom(user.getNom());
            existingUser.setContact(user.getContact());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            existingUser.setService(user.getService());
            return userRepository.save(existingUser);
        }
        return null;
    }
    //
}
