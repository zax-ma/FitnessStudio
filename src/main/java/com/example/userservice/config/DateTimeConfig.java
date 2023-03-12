package com.example.userservice.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeConfig {

        private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

        @Bean
        public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
            return builder -> {
                builder.simpleDateFormat(dateTimeFormat);
                builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
            };
        }

    }

