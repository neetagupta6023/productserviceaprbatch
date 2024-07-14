package com.example.productserviceapr24.InheritanceDemo.DB.singletable_perclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name="sc_usr")
@DiscriminatorColumn(name="user_type",discriminatorType = DiscriminatorType.INTEGER)
public class User {
    @Id
    private Long id;
    private String name;
    private String emailId;
    private String password;

}
