package com.example.userservice.utils.validation;

import com.example.userservice.dto.UserRole;
import com.example.userservice.utils.exceptions.annotations.RequiredParameterIsEmptyException;
import com.example.userservice.utils.validation.api.IFieldValidator;

import javax.validation.ValidationException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;


public class RoleParamsValidator implements IFieldValidator {
    @Override
    public void validate(Object entity, Field field) {
        try {
            if (Collection.class.isAssignableFrom(field.getType())) {
                Collection<?> fieldValue = (Collection<?>) field.get(entity);
                if (fieldValue == null || fieldValue.isEmpty()) {
                    throw new RequiredParameterIsEmptyException(field.getName());
                }
            } else if (String.class.isAssignableFrom(field.getType())) {
                String fieldValue = (String) field.get(entity);
                if (fieldValue == null || fieldValue.isEmpty() || fieldValue.isBlank() ||
                        Arrays.stream(UserRole.values()).noneMatch(el -> el.toString().equals(fieldValue))) {
                    throw new RequiredParameterIsEmptyException(field.getName());
                }
            } else {
                if (field.get(entity) == null || field.get(entity) == "" ) {
                    throw new RequiredParameterIsEmptyException(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            throw new ValidationException(e);
        }
    }
}
