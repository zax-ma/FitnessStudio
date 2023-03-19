package com.example.userservice.utils.validation;

import com.example.userservice.utils.validation.api.IFieldValidator;
import com.example.userservice.utils.validation.api.IParamValidator;
import jakarta.validation.ValidationException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class AnnotationBasedParamValidator implements IParamValidator {

    private final Map<Class<? extends Annotation>, IFieldValidator> validationFunctions;
    private final Set<Class<? extends Annotation>> supportedFieldAnnotations;

    public AnnotationBasedParamValidator(Map<Class<? extends Annotation>, IFieldValidator> validationFunctions) {
        this.validationFunctions = validationFunctions;
        supportedFieldAnnotations = this.validationFunctions.keySet();
    }

    @Override
    public void validate(Object param) {
        if (param == null) {
            throw new ValidationException("Passed param is null");
        }
        Class<?> clazz = param.getClass();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            supportedFieldAnnotations.stream()
                    .filter(field::isAnnotationPresent)
                    .map(validationFunctions::get)
                    .forEach(fieldValidator -> fieldValidator.validate(param, field));
        }
    }

}
