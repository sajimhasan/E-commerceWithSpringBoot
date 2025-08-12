package com.example.RealProject.Controller;

import com.example.RealProject.Entity.Product;
import com.example.RealProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/all")
    public ResponseEntity<?> seeallproduct(Product product){
        productService.getAllProduct(product);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/add/items")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        productService.CreateProduct(product);
        return ResponseEntity.ok("Product submit"+product);

    }

    // fix the frobidden error !!



}
