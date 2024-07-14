package com.example.productserviceapr24.InheritanceDemo.DB.joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_mt")
public class Mentor extends User {
    private String companyName;
    private double avgRating;

}
