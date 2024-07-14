package com.example.productserviceapr24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="Category")
public class Category extends BaseModel{

    private String title;
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> productList;
}
