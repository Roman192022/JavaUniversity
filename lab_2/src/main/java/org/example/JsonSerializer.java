package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonSerializer implements Serializer {
    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        this.objectMapper = new ObjectMapper();
        // Register the JavaTimeModule for LocalDate support
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String serialize(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    @Override
    public <T> T deserialize(String data, Class<T> clazz) throws IOException {
        return objectMapper.readValue(data, clazz);
    }

    @Override
    public void writeToFile(Object object, String filePath) throws IOException {
        objectMapper.writeValue(Path.of(filePath).toFile(), object);
    }

    @Override
    public <T> T readFromFile(String filePath, Class<T> clazz) throws IOException {
        return objectMapper.readValue(Path.of(filePath).toFile(), clazz);
    }
}
