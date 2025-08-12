package com.example.RealProject.Service;


import com.example.RealProject.Entity.Product;
import com.example.RealProject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product CreateProduct(Product product){
        return productRepo.save(product);
    }

    public ResponseEntity<?> getAllProduct(Product product){
        return ResponseEntity.ok(product);
    }

}
