package com.example.userservice.utils.validation.api;

import java.lang.reflect.Field;

public interface IFieldValidator {
    void validate(Object entity, Field field);
}
