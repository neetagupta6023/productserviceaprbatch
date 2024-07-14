package com.example.productserviceapr24.services;

import com.example.productserviceapr24.exceptions.ProductLimitReachedException;
import com.example.productserviceapr24.models.Category;
import com.example.productserviceapr24.models.Product;
import com.example.productserviceapr24.repos.CategoryRepository;
import com.example.productserviceapr24.repos.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductLimitReachedException {
      Optional<Product> productOptional = productRepository.findById(id);
      if(productOptional.isPresent()) {
          return productOptional.get();
      }
      else
      {
          throw new NullPointerException();
      }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
//        Category category = product.getCategory();
//        if(category.getId()==null)
//        {
//            category = categoryRepository.save(category);
//            product.setCategory(category);
//        }
       return productRepository.save(product);

    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }
}
