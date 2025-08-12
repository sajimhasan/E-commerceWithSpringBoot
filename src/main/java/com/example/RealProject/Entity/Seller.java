package com.example.RealProject.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "seller")
public class Seller {

    @Id
    private Long id;
    private String username;
    private String password;
    private String shopname;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference
    private List<Product> products;
}
