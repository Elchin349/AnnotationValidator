package com.example.annotationvalidatorproject.model;

import com.example.annotationvalidatorproject.annotation.Email;
import com.example.annotationvalidatorproject.annotation.PhoneNumber;
import com.example.annotationvalidatorproject.annotation.ValidPassword;
import lombok.Data;

@Data
public class AuthModel {

    @Email
    private String email;
    @PhoneNumber
    private String phoneNumber;
    @ValidPassword
    private String password;
}
