package org.example.services;

import java.io.IOException;

public interface Serializer<T> {
    void serialize(T entity, String filename) throws IOException;

    T deserialize(String filename, Class<T> entityType) throws IOException;
}

