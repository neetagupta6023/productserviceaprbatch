package com.example.productserviceapr24.InheritanceDemo.DB.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name="tps_usr")
public class User {
    @Id
    private Long id;
    private String name;
    private String emailId;
    private String password;

}
