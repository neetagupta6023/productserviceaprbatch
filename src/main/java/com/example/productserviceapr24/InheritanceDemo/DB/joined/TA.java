package com.example.productserviceapr24.InheritanceDemo.DB.joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_ta")
public class TA extends User {
    private int numofSesion;
    private double avgRating;
}
