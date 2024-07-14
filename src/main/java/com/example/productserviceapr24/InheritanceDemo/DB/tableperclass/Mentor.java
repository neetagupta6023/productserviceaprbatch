package com.example.productserviceapr24.InheritanceDemo.DB.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tps_mt")
public class Mentor extends User {
    private String companyName;
    private double avgRating;

}
