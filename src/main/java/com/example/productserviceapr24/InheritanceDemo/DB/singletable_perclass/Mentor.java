package com.example.productserviceapr24.InheritanceDemo.DB.singletable_perclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sc_mt")
@DiscriminatorValue(value="2")
public class Mentor extends User {
    private String companyName;
    private double avgRating;

}
