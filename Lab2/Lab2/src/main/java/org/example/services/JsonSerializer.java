package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;


public class JsonSerializer<T> implements Serializer<T> {
    private ObjectMapper objectMapper;

    public JsonSerializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void serialize(T entity, String filename) throws IOException {
        objectMapper.writeValue(Paths.get(filename).toFile(), entity);
    }

    @Override
    public T deserialize(String filename, Class<T> entityType) throws IOException {
        return objectMapper.readValue(Paths.get(filename).toFile(), entityType);
    }
}