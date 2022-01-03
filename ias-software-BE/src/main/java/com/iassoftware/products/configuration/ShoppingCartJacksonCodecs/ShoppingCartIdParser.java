package com.iassoftware.products.configuration.ShoppingCartJacksonCodecs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartId;

import java.io.IOException;

public class ShoppingCartIdParser {
    public static class Serializer extends JsonSerializer<ShoppingCartId> {
        @Override
        public void serialize(ShoppingCartId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<ShoppingCartId> {
        @Override
        public ShoppingCartId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return ShoppingCartId.fromString(p.getValueAsString());
        }
    }
}
