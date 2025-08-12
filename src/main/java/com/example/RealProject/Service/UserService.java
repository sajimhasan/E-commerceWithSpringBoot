package com.example.RealProject.Service;

import com.example.RealProject.Entity.Users;
import com.example.RealProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public Users creatingUsers( Users users){
        users.setPassword(encoder.encode(users.getPassword()));
         userRepo.save(users);
         return users;
    }


    public String varify( Users users){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername() , users.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.genareteToken(users.getUsername());
        }else {
            return "fail";
        }
    }

}
