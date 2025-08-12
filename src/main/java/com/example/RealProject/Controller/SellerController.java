package com.example.RealProject.Controller;


import com.example.RealProject.Entity.Seller;
import com.example.RealProject.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);


    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody Seller seller){
       Seller sellerlist = sellerService.RegistrationSeller(seller);
       seller.setPassword(encoder.encode(seller.getPassword()));
        return ResponseEntity.ok("Registration is 0k"+sellerlist);
    }


}
