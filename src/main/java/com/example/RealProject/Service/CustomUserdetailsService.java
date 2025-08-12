package com.example.RealProject.Service;

import com.example.RealProject.Entity.Userpincipal;
import com.example.RealProject.Entity.Users;
import com.example.RealProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserdetailsService  implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = userRepo.findByUsername(username);

      if (users == null){
          throw  new UsernameNotFoundException("User not found");
      }

      // if we use the Opsonal<Users> then we need line 29
      Users user= users.get();
      return new Userpincipal(user);
    }
}
