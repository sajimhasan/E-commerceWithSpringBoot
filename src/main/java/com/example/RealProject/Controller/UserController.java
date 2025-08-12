package com.example.RealProject.Controller;

import com.example.RealProject.Entity.Users;
import com.example.RealProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public Users registration(@RequestBody Users users){
        return userService.creatingUsers(users);
    }

    @PostMapping("/login")
    public String login (@RequestBody Users users){
        return userService.varify(users);
    }

}
