package com.example.annotationvalidatorproject.annotation.validator;

import com.example.annotationvalidatorproject.annotation.BirthDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BirthDateValidator implements ConstraintValidator<BirthDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return checkBirthDate(value);
    }

    private boolean checkBirthDate(LocalDate birthDate) {
        int age = LocalDate.now().getYear() - birthDate.getYear();
        return age >= 18 && age < 64;
    }
}
