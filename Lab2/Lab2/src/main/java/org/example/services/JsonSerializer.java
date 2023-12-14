package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

public class JsonSerializer<T> implements Serializer<T> {
    private ObjectMapper objectMapper;

    public JsonSerializer() {
        this.objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void serialize(T entity, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            objectMapper.writeValue(new File(filename), entity);
        }
    }

    @Override
    public T deserialize(String filename, Class<T> entityType) throws IOException {

        return objectMapper.readValue(new File(filename), entityType);
    }
}
