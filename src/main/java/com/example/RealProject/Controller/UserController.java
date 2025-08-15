package com.example.RealProject.Controller;

import com.example.RealProject.Entity.Users;
import com.example.RealProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public Users registration(@RequestBody Users users) {
        return userService.creatingUsers(users);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users users) {
        String token= userService.varify(users);

        if ("fail".equals(token)){
           return ResponseEntity.status(401).body("This is not vaild");
        }
        return ResponseEntity.ok(Map.of("token",token));
    }

}
