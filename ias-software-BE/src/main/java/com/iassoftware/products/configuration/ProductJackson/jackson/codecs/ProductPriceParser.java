package com.iassoftware.products.configuration.ProductJackson.jackson.codecs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.iassoftware.products.domain.productDomain.ProductPrice;


import java.io.IOException;

public class ProductPriceParser {
    public static class Serializer extends JsonSerializer<ProductPrice> {
        @Override
        public void serialize(ProductPrice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            Integer number = value.asInteger();
            gen.writeNumber(number);
        }
    }

    public static class Deserializer extends JsonDeserializer<ProductPrice> {
        @Override
        public ProductPrice deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            int valueAsInt = p.getValueAsInt();
            return new ProductPrice(valueAsInt);
        }
    }
}

