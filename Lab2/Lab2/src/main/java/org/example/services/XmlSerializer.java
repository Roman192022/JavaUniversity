package org.example.services;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlSerializer<T> implements Serializer<T> {
    private XmlMapper xmlMapper;

    public XmlSerializer() {
        this.xmlMapper = (XmlMapper) new XmlMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void serialize(T entity, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String xmlContent = xmlMapper.writeValueAsString(entity);
            writer.write(xmlContent);
        }
    }

    @Override
    public T deserialize(String filename, Class<T> entityType) throws IOException {
        String xmlContent = new String(Files.readAllBytes(Paths.get(filename)));
        return xmlMapper.readValue(xmlContent, entityType);
    }
}
