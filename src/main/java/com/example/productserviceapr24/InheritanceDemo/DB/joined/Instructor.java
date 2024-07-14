package com.example.productserviceapr24.InheritanceDemo.DB.joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_it")
public class Instructor extends User {
    private String specialSession;

}
