package org.example.services;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Paths;

public class XmlSerializer<T> implements Serializer<T> {
    private XmlMapper xmlMapper;

    public XmlSerializer() {
        this.xmlMapper = new XmlMapper();
    }

    @Override
    public void serialize(T entity, String filename) throws IOException {
        xmlMapper.writeValue(Paths.get(filename).toFile(), entity);
    }

    @Override
    public T deserialize(String filename, Class<T> entityType) throws IOException {
        return xmlMapper.readValue(Paths.get(filename).toFile(), entityType);
    }
}