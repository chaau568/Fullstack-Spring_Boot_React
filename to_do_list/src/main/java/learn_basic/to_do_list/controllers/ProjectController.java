package learn_basic.to_do_list.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn_basic.to_do_list.autoTranferEntity.NameResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/todo")

public class ProjectController {
    @GetMapping("/hello") 
    public String hello() {
        return "Hello World";
    }
    @PostMapping("/hello") 
    public NameResponse greet(@RequestBody NameResponse message) {
        return new NameResponse("Hello " + message.getMessage());
    }
}
