package learn_basic.to_do_list.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/todo")

public class ProjectController {
    @GetMapping("/hello") 
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/hello/{name}") 
    public String greet(@PathVariable String name) {
        return "Hello: " + name;
    }
}
