package com.example.annotationvalidatorproject.model;

import com.example.annotationvalidatorproject.annotation.BirthDate;
import com.example.annotationvalidatorproject.annotation.CharacterValidation;
import com.example.annotationvalidatorproject.annotation.FinCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonalModel {
    @CharacterValidation
    private String firstName;

    @CharacterValidation
    private String lastName;

    @FinCode
    private String finCode;

    @BirthDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
