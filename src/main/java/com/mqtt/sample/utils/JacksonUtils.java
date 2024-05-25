package com.mqtt.sample.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UncheckedIOException;

public class JacksonUtils {

    public static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    public static Object readValue(String value, Class<?> clazz) {
        try {
            return mapper.readValue(value, clazz);
        } catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }

    public static String writeValueAsString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }

}
