package com.example.productserviceapr24.InheritanceDemo.DB.singletable_perclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sc_it")
@DiscriminatorValue(value="1")
public class Instructor extends User {
    private String specialSession;

}
