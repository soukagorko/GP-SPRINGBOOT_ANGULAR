package com.Backend.controller;

import com.Backend.entities.User;
import com.Backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    //
    private final UserService userService;

    @PostMapping("/save")
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }
    //
    @GetMapping("/data")
    public List<User> readAllUsers(){
        return userService.getAllUsers();
    }
    //
    @DeleteMapping("/delete/{id}")
    public void supprimerUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    //
    @GetMapping("/detail/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        if(user==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }
    //
    @PutMapping("/update/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id, @RequestBody User user){
        User updateUser = userService.updateUser(id, user);
        if(updateUser==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateUser);
    }
    //
}
