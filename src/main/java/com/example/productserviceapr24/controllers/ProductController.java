package com.example.productserviceapr24.controllers;

import com.example.productserviceapr24.exceptions.ProductLimitReachedException;
import com.example.productserviceapr24.models.Product;
import com.example.productserviceapr24.services.IProductService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;
    public ProductController(IProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductLimitReachedException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
    @PostMapping
    public Product CreateProduct(@RequestBody Product product)
    {
       return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public Product UpdateProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {   productService.updateProduct(id,product);
        return product;
    }
    @PatchMapping("/{id}")
    public Product ReplaceProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {
        productService.replaceProduct(id,product);
        return product;
    }
    @DeleteMapping("/{id}")
    public Product DeleteProductById(@PathVariable("id") Long id)
    {
        return new Product();
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Null reference exception")
    @ExceptionHandler(NullPointerException.class)
    public void HandleException()
    {

    }
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView HandleViewModelExceptionResult(HttpServletRequest request, Exception ex)
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
