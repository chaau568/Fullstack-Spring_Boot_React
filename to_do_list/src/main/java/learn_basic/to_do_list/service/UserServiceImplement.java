package learn_basic.to_do_list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import learn_basic.to_do_list.entity.UserEntity;
import learn_basic.to_do_list.repository.UserRepository;

@Service

public class UserServiceImplement implements UserService {
    // private final UserRepository userRepository;
    
    // public UserServiceImplement(UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException("User not found with id: " + id);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        Optional<UserEntity> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(String id, UserEntity user) {
       if (userRepository.findById(id).isPresent()) {
        return userRepository.save(user);
       }
       throw new RuntimeException("User not found with id: " + id);
    }

    @Override
    public void deleteUser(String id) {
       if (userRepository.findById(id).isPresent()) {
        userRepository.deleteById(id);
       }
       else {
        throw new RuntimeException("User not found with id: " + id);
       }
    }

    @Override
    public UserEntity findByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException("User not found with username: " + username);
    }

}
