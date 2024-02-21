package com.hm.usermanagement.service.impl;

import com.hm.usermanagement.model.User;
import com.hm.usermanagement.repository.UserRepository;
import com.hm.usermanagement.service.UserService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Cacheable(value="apiCache" , key="#apiUrl")
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(Long userId, User userDetails) {
        User user=userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        user.setUserName(userDetails.getUserName());
        user.setEmail(userDetails.getEmail());


        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user=userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ userId));
        userRepo.delete(user);

    }
}
