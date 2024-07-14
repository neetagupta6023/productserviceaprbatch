package com.example.productserviceapr24.InheritanceDemo.DB.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tps_it")
public class Instructor extends User {
    private String specialSession;

}
