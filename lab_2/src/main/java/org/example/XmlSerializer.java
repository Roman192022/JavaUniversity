package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Path;


public class XmlSerializer implements Serializer {
    private final XmlMapper xmlMapper;

    public XmlSerializer() {
        this.xmlMapper = new XmlMapper();
    }

    @Override
    public String serialize(Object object) throws IOException {
        return xmlMapper.writeValueAsString(object);
    }

    @Override
    public <T> T deserialize(String data, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(data, clazz);
    }

    @Override
    public void writeToFile(Object object, String filePath) throws IOException {
        xmlMapper.writeValue(Path.of(filePath).toFile(), object);
    }

    @Override
    public <T> T readFromFile(String filePath, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(Path.of(filePath).toFile(), clazz);
    }
}
