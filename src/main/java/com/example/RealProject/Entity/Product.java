package com.example.RealProject.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    private Long id;
    private String productimage;
    private String poster;
    private double price;
    private double discount;
    private String title ;
    private LocalTime create_at=  LocalTime.now();


    @ManyToOne
    @JoinColumn(name = "seller_id",nullable = false)
    @JsonBackReference
    private Seller seller;

}
