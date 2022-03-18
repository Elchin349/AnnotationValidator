package com.example.annotationvalidatorproject.annotation.validator;

import com.example.annotationvalidatorproject.annotation.FinCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinCodeValidator implements ConstraintValidator<FinCode,String> {
    private static final String FIN_CODE_SIZE = "^[a-zA-Z0-9]{7}$";
    private static final Pattern PATTERN = Pattern.compile(FIN_CODE_SIZE);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return checkSize(value);
    }

    private boolean checkSize(String value) {
        Matcher matcher = PATTERN.matcher(value);
        return matcher.matches();
    }
}
