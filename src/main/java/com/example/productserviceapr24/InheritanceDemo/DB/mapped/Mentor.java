package com.example.productserviceapr24.InheritanceDemo.DB.mapped;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_mt")
public class Mentor extends User {
    private String companyName;
    private double avgRating;

}
