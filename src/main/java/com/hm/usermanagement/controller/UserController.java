package com.hm.usermanagement.controller;

import com.hm.usermanagement.model.User;
import com.hm.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userSvc;

    @GetMapping
    public List<User> getAllUsers(){
        return userSvc.getAllUsers();
    }

    @GetMapping("id")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        Optional<User> user=userSvc.getUserById(userId);
        return user.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,@RequestBody User userDetails){
   User updateUser=userSvc.updateUser(userId,userDetails);
    return ResponseEntity.ok(updateUser);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User userDetails){
        User createUser=userSvc.createUser(userDetails);
        return ResponseEntity.ok(createUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId){
        userSvc.deleteUser(userId);
        return ResponseEntity.ok().build();

    }
}
