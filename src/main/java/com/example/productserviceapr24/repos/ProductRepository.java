package com.example.productserviceapr24.repos;

import com.example.productserviceapr24.models.Product;
import com.example.productserviceapr24.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Product save(Product product);

    @Override
    void delete(Product product);

    //HQL
    @Query("Select p.title as title, p.description as description from Product  p where p.id=:id")
    ProductProjection findProductProjectionById(@Param("id") Long id);

    @Query(value="select p.title as title from Product  p where p.id=:id",nativeQuery = true)
    ProductProjection findwithNativeQueryProductProjectionById(@Param("id") Long id);

    @Query(value ="select * from product", nativeQuery = true)
    List<Product> findAllProducts();
}
