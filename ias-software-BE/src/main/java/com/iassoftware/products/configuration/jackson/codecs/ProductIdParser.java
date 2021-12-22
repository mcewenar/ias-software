package com.iassoftware.products.configuration.jackson.codecs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.iassoftware.products.domain.productDomain.ProductReference;

import java.io.IOException;
public class ProductIdParser {

    public static class Serializer extends JsonSerializer<ProductReference> {
        @Override
        public void serialize(ProductReference value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<ProductReference>{
        @Override
        public ProductReference deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return ProductReference.fromString(p.getValueAsString());
        }
    }
}