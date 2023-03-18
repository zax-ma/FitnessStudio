package com.example.userservice.utils.validation;

import com.example.userservice.utils.exceptions.annotations.EmailPatternException;
import com.example.userservice.utils.validation.annotation.EmailPattern;
import com.example.userservice.utils.validation.api.IFieldValidator;

import javax.validation.ValidationException;
import java.lang.reflect.Field;

public class EmailPatternValidator implements IFieldValidator {
    @Override
    public void validate(Object entity, Field field) {
        if (String.class.isAssignableFrom(field.getType())) {
           EmailPattern annotation = field.getAnnotation(EmailPattern.class);
            String regex = annotation.value();
            try {
                String fieldValue = (String) field.get(entity);
                if (fieldValue == null || !fieldValue.matches(regex)) {
                    throw new EmailPatternException(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }
    }
}
