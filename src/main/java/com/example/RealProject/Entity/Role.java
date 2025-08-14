package com.example.RealProject.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Role {
    ADMIN,
    USER,
    SELLER;

    @JsonCreator
    public static Role fromString(String value) {
        return Role.valueOf(value.toUpperCase());
    }
}
