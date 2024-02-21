package com.hm.usermanagement.service;

import com.hm.usermanagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();

    public Optional<User> getUserById(Long id);

    public User createUser(User user);

    public User updateUser(Long userId,User userDetails);

    public void deleteUser(Long userId);

}
