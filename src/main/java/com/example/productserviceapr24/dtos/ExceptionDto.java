package com.example.productserviceapr24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    private String message;
    private String errorCode;
    private String StackTrace;
}
