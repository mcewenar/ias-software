package com.iassoftware.products.configuration.PersonJacksonCodecs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.iassoftware.products.domain.personDomain.PersonId;

import java.io.IOException;

public class PersonIdParser {
    public static class Serializer extends JsonSerializer<PersonId> {
        @Override
        public void serialize(PersonId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<PersonId> {
        @Override
        public PersonId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return PersonId.fromString(p.getValueAsString());
        }
    }
}
