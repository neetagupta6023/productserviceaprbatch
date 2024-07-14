package com.example.productserviceapr24.repos;

import com.example.productserviceapr24.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
