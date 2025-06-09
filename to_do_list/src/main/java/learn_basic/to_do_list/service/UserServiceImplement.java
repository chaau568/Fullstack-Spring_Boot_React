package learn_basic.to_do_list.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import learn_basic.to_do_list.entity.UserEntity;
import learn_basic.to_do_list.repository.UserRepository;
import learn_basic.to_do_list.returnStatusCode.UserExceptionStatus;

@Service

public class UserServiceImplement implements UserService {

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
    public void createUser(UserEntity user) {
        if (user.getUsername().isEmpty() || user.getUsername().isEmpty()) {
            throw new UserExceptionStatus("Username cannot be null or empty");
        }

        Optional<UserEntity> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new UserExceptionStatus("Username already exists");
        }
        userRepository.save(user);
    }

    @Override
    public void updateUser(String newUsername, String newPassword, UserEntity user) {
       if (user.getId().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            throw new UserExceptionStatus("Username or Password cannot be null or empty");
       }
       Optional<UserEntity> compareUser = userRepository.findById(user.getId());
       if (compareUser.isPresent()) {
            UserEntity newUser = compareUser.get();
            newUser.setUsername(newUsername);
            newUser.setPassword(newPassword);
            userRepository.save(newUser);
       }
       else {
        throw new UserExceptionStatus("User not found with id: " + user.getId());
       }
    }

    @Override
    public void deleteUser(String id) {
       if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
       }
       else {
            throw new UserExceptionStatus("User not found with id: " + id);
       }
    }

}
