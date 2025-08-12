package com.example.RealProject.Controller;


import com.example.RealProject.Entity.Users;
import com.example.RealProject.Repository.UserRepo;
import com.example.RealProject.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

   @Autowired
    private UserRepo userRepo;

   @GetMapping("/user/list")
    public List<Users>  userlist(Users users){
       return userRepo.findAll();
   }


}
