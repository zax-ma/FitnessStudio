package com.example.userservice.utils.validation;

import com.example.userservice.utils.exceptions.annotations.CharSizeException;
import com.example.userservice.utils.validation.annotation.CharSize;
import com.example.userservice.utils.validation.api.IFieldValidator;
import jakarta.validation.ValidationException;

import java.lang.reflect.Field;

public class CharSizeValidator implements IFieldValidator {
    @Override
    public void validate(Object entity, Field field) {
        if (String.class.isAssignableFrom(field.getType())) {
            CharSize annotation = field.getAnnotation(CharSize.class);
            String minValue = annotation.min();
            String maxValue = annotation.max();
            try {
                String fieldValue = (String) field.get(entity);

                if (fieldValue.length() < Integer.parseInt(minValue) ||
                        fieldValue.length() > Integer.parseInt(maxValue)) {
                    throw new CharSizeException(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }
    }
}
