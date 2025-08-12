package com.example.RealProject.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    private Long id;
    private String username;
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;
}
