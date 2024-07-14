package com.example.productserviceapr24.services;

import com.example.productserviceapr24.exceptions.ProductLimitReachedException;
import com.example.productserviceapr24.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id) throws ProductLimitReachedException;
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Long productId, Product product);
    Product deleteProduct(Long productId);
    Product replaceProduct(Long productId, Product product);
}
