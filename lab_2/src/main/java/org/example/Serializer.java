package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface Serializer {
    String serialize(Object object) throws IOException;

    <T> T deserialize(String data, Class<T> clazz) throws IOException;

    void writeToFile(Object object, String filePath) throws IOException;

    <T> T readFromFile(String filePath, Class<T> clazz) throws IOException;
}




