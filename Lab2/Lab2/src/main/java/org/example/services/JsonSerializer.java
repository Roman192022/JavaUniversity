package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonSerializer<T> implements Serializer<T> {
    private ObjectMapper objectMapper;

    public JsonSerializer() {
        this.objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void serialize(T entity, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String jsonContent = objectMapper.writeValueAsString(entity);
            writer.write(jsonContent);
        }
    }

    @Override
    public T deserialize(String filename, Class<T> entityType) throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get(filename)));
        return objectMapper.readValue(jsonContent, entityType);
    }
}
