package com.example.productserviceapr24.services;

import com.example.productserviceapr24.dtos.FakeStoreProductDto;
import com.example.productserviceapr24.exceptions.ProductLimitReachedException;
import com.example.productserviceapr24.models.Category;
import com.example.productserviceapr24.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.util.ArrayList;
import java.util.List;
@Service

public class FakeProductService implements IProductService {
    private RestTemplate restTemplate ;
    FakeProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Long id) throws ProductLimitReachedException{
//        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
//            public boolean verify(String hostname, SSLSession session) {
//                return true;
//            }
//        });
        if(id>100)
        {
           throw new ProductLimitReachedException("Limit Exceeded");
        }
        if(id<=-1)
        {
            throw new NullPointerException();
        }
        if(id==1)
        {
            throw new IllegalArgumentException();
        }
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);


        return ConvertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
       FakeStoreProductDto[] fakeStoreProductDtos=restTemplate.getForObject("https://fakestoreapi.com/products/",FakeStoreProductDto[].class);
       List<Product> products = new ArrayList<>();
       for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
           products.add(ConvertFakeStoreDtoToProduct(fakeStoreProductDto));
       }
       return products;
    }

    @Override
    public Product addProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto=ConvertProductToFakeStoreProductDto(product);
        fakeStoreProductDto=restTemplate.postForObject("https://fakestoreapi.com/products/",fakeStoreProductDto,FakeStoreProductDto.class);
        return ConvertFakeStoreDtoToProduct(fakeStoreProductDto);
    }
    @Override
    public Product updateProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto=ConvertProductToFakeStoreProductDto(product);
       restTemplate.put("https://fakestoreapi.com/products/"+productId,fakeStoreProductDto);
        return product;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto=ConvertProductToFakeStoreProductDto(product);
        fakeStoreProductDto=restTemplate.patchForObject("https://fakestoreapi.com/products/"+productId,fakeStoreProductDto,FakeStoreProductDto.class);
        return ConvertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    private Product ConvertFakeStoreDtoToProduct(FakeStoreProductDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();

        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        // Assuming Category needs only id and title, and title is derived from category field of DTO
        Category category = new Category();
        // Here you would assign the id and title of the category appropriately.
        // For demonstration, let's assume the category title is what's passed in the DTO
        // and we set a dummy ID or fetch the correct ID based on the title from a database or other source.
        category.setId(0L); // Dummy ID or retrieve appropriately
        category.setTitle(dto.getCategory());

        product.setCategory(category);

        return product;
    }
    private FakeStoreProductDto ConvertProductToFakeStoreProductDto(Product product) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();

        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        return fakeStoreProductDto;
    }
}
