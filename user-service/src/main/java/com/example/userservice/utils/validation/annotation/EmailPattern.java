package com.example.userservice.utils.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    Patterns for e-mail format validation:
    ^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$
    OWASP: ^[a-zA-Z0-9_+&*-] + (?:\\.[a-zA-Z0-9_+&*-] + )*@(?:[a-zA-Z0-9-]+\\.) + [a-zA-Z]{2, 7}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EmailPattern {

    String value();


}
