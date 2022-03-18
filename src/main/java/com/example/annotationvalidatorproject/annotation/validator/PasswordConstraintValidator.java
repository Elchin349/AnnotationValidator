package com.example.annotationvalidatorproject.annotation.validator;

import com.example.annotationvalidatorproject.annotation.ValidPassword;
import org.passay.*;
import org.passay.LengthRule;
import org.passay.PasswordValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        PasswordValidator validator = getPasswordValidator();
        RuleResult result = validator.validate(new PasswordData(value));
        if (result.isValid()) {
            return true;
        }
        List<String> messages = validator.getMessages(result);
        String messageTemplate = String.join(",", messages);
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }

    private PasswordValidator getPasswordValidator() {
        return new PasswordValidator(
                Arrays.asList(
                        // at least 6 characters
                        new LengthRule(6, 30),
                        // at least one upper case character
                        new CharacterRule(EnglishCharacterData.UpperCase, 1),
                        // at least one lower case character
                        new CharacterRule(EnglishCharacterData.LowerCase, 1),
                        // at least 1 digit
                        new CharacterRule(EnglishCharacterData.Digit, 1),
                        // at least 1 symbol
                        new CharacterRule(EnglishCharacterData.Special, 1),
                        // no whitespace
                        new WhitespaceRule()
                )
        );
    }
}
