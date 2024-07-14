package com.example.productserviceapr24.advice;

import com.example.productserviceapr24.dtos.ExceptionDto;
import com.example.productserviceapr24.exceptions.ProductLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class,NullPointerException.class})
    public ResponseEntity<String> expectFrameworkExceptions(){
        return new ResponseEntity<>("Something wrong happened", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<ExceptionDto> expectProductLimitReachedException(){
        ExceptionDto exceptionDto=new ExceptionDto();
        exceptionDto.setMessage("Product Limit Exceeded");
        exceptionDto.setErrorCode("PRODUCT_LIMIT_REACHED");
        exceptionDto.setStackTrace("Inside FakeStoreAPI");
        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_ACCEPTABLE);
    }
}
