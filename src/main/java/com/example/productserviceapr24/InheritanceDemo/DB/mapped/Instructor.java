package com.example.productserviceapr24.InheritanceDemo.DB.mapped;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_it")
public class Instructor extends User {
    private String specialSession;

}
