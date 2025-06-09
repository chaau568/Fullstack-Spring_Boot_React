package learn_basic.to_do_list.service;

import java.util.List;

import learn_basic.to_do_list.entity.UserEntity;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(String id);
    void createUser(UserEntity user);
    void updateUser(String newUsername, String newPassword, UserEntity user);  
    void deleteUser(String id);
}
