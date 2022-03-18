package com.example.annotationvalidatorproject.annotation.validator;

import com.example.annotationvalidatorproject.annotation.CharacterValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterValidator implements ConstraintValidator<CharacterValidation, String> {
    private static final String CHARACTER_PATTERN = "^[a-zA-Z]*$";
    private static final Pattern PATTERN = Pattern.compile(CHARACTER_PATTERN);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isCharacter(value);
    }

    private boolean isCharacter(String phoneNumber) {
        Matcher matcher = PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }
}
