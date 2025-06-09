package learn_basic.to_do_list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn_basic.to_do_list.entity.UserEntity;
import learn_basic.to_do_list.returnStatusCode.UserExceptionStatus;
import learn_basic.to_do_list.service.UserService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/todo")

public class ProjectController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello") 
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("getById/{id}")
    public UserEntity getById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("User created successfully.");
        }
        catch (UserExceptionStatus e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
    }

    @PutMapping("/updateUser/{newUsername}/{newPassword}")
    public ResponseEntity<?> updateUser(@PathVariable String newUsername, @PathVariable String newPassword, @RequestBody UserEntity user) {
        try {
            userService.updateUser(newUsername, newPassword, user);
            return ResponseEntity.ok("User updated successfully.");
        }
        catch (UserExceptionStatus e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (UserExceptionStatus e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
