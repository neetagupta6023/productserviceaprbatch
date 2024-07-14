package com.example.productserviceapr24.InheritanceDemo.DB.mapped;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_ta")
public class TA extends User {
    private int numofSesion;
    private double avgRating;
}
