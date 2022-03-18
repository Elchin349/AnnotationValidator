package com.example.annotationvalidatorproject.annotation.validator;

import com.example.annotationvalidatorproject.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumValidator implements ConstraintValidator<PhoneNumber, String> {

    private static final String PHONE_NUMBER_REGEX = "^\\+994(77|70|50|51|55|99|10|40)[2-9][0-9]{6}$";
    private static final Pattern PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isPhoneNumValid(value);
    }

    private boolean isPhoneNumValid(String phoneNumber) {
        Matcher matcher = PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }
}
