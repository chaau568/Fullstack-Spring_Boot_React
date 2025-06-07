package learn_basic.to_do_list.service;

import java.util.List;

import learn_basic.to_do_list.entity.UserEntity;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(String id);
    UserEntity createUser(UserEntity user);
    UserEntity updateUser(String id, UserEntity user);  
    void deleteUser(String id);
    UserEntity findByUsername(String username);
}
