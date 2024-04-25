package com.yugabyte.uuidexample;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UuidConverter implements AttributeConverter<String, UUID> {

    private static final Log LOG = LogFactory.getLog(UuidConverter.class);

    @Override
    public String convertToEntityAttribute(UUID id) {
        LOG.info(String.format("Converting from UUID to String: [%s]", id.toString()));
        return id == null ? "" : id.toString();
    }

    @Override
    public UUID convertToDatabaseColumn(String id) {
        LOG.info(String.format("Converting from String to UUID: [%s]", id));
        return UUID.fromString(id);
    }
}
