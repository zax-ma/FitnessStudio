package com.example.userservice.config;

import com.example.userservice.utils.validation.*;
import com.example.userservice.utils.validation.api.IFieldValidator;
import com.example.userservice.utils.validation.api.IParamValidator;
import com.example.userservice.utils.validation.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ValidationConfig {

    @Bean
    public IParamValidator getParamValidator(){
        Map<Class<? extends Annotation>, IFieldValidator> validatorMap = new HashMap<>();
        validatorMap.put(EmailPattern.class, new EmailPatternValidator());
        validatorMap.put(NotEmptyOrBlank.class, new NotEmptyOrBlankValidator());
        validatorMap.put(CharSize.class, new CharSizeValidator());
        validatorMap.put(RoleParams.class, new RoleParamsValidator());
        return new AnnotationBasedParamValidator(validatorMap);
    }
}


