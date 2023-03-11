package com.example.userservice.utils.validation.aspect;

import com.example.userservice.utils.validation.api.IParamValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Aspect
@Component
public class MethodParamValidationAspect {
    private final IParamValidator validator;

    public MethodParamValidationAspect(IParamValidator validator) {
        this.validator = validator;
    }

    @Before(value = "@annotation(com.example.userservice.utils.validation.annotation.ValidParams)")
    public void validateParameters(JoinPoint joinPoint) {
        Stream.of(joinPoint.getArgs()).forEach(validator::validate);
    }
}
