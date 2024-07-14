package com.example.productserviceapr24.InheritanceDemo.DB.singletable_perclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sc_ta")
@DiscriminatorValue(value="3")
public class TA extends User {
    private int numofSesion;
    private double avgRating;
}
