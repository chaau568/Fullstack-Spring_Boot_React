package learn_basic.to_do_list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn_basic.to_do_list.autoTranferEntity.NameResponse;
import learn_basic.to_do_list.entity.UserEntity;
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
    // @PostMapping("/hello") 
    // public NameResponse greet(@RequestBody NameResponse message) {
    //     return new NameResponse("Hello " + message.getMessage());
    // }

    @GetMapping("/getAll")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
}
