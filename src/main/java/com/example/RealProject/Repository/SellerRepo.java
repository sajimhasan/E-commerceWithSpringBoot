package com.example.RealProject.Repository;

import com.example.RealProject.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepo extends JpaRepository <Seller, Long> {

   // Optional<Seller> findBySeller(String username);
}
