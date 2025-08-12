package com.example.RealProject.Repository;

import com.example.RealProject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

   // Optional<Product> findByUsername(String title);
}
