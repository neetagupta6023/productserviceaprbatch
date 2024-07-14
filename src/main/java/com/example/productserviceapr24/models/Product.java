package com.example.productserviceapr24.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Product")
public class Product extends BaseModel{

    private String title;
    private String description;
    private Double price;
    @JoinColumn(name="category_id",insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
}
