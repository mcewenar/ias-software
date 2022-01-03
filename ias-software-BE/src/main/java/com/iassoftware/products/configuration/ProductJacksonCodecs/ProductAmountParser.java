package com.iassoftware.products.configuration.ProductJacksonCodecs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.iassoftware.products.domain.productDomain.ProductAmount;
import com.iassoftware.products.domain.productDomain.ProductPrice;

import java.io.IOException;

public class ProductAmountParser {
    public static class Serializer extends JsonSerializer<ProductAmount> {
        @Override
        public void serialize(ProductAmount value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            Integer number = value.asInteger();
            gen.writeNumber(number);
        }
    }

    public static class Deserializer extends JsonDeserializer<ProductAmount> {
        @Override
        public ProductAmount deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            int valueAsInt = p.getValueAsInt();
            return new ProductAmount(valueAsInt);
        }
    }
}
