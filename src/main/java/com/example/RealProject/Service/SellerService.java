package com.example.RealProject.Service;


import com.example.RealProject.Entity.Seller;
import com.example.RealProject.Repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepo sellerRepo;

    public Seller RegistrationSeller(Seller seller){
        return sellerRepo.save(seller);
    }
}
