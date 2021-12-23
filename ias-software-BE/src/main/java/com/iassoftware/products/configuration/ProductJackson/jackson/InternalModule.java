package com.iassoftware.products.configuration.ProductJackson.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

import com.iassoftware.products.configuration.ProductJackson.jackson.codecs.ProductDescriptionParser;
import com.iassoftware.products.configuration.ProductJackson.jackson.codecs.ProductIdParser;
import com.iassoftware.products.configuration.ProductJackson.jackson.codecs.ProductNameParser;
import com.iassoftware.products.configuration.ProductJackson.jackson.codecs.ProductPriceParser;
import com.iassoftware.products.domain.productDomain.ProductDescription;
import com.iassoftware.products.domain.productDomain.ProductName;
import com.iassoftware.products.domain.productDomain.ProductPrice;
import com.iassoftware.products.domain.productDomain.ProductReference;

public class InternalModule extends SimpleModule {

    private static final String NAME = "InternalModule";

    public InternalModule() {
        super(NAME, Version.unknownVersion());
        addSerializer(ProductReference.class, new ProductIdParser.Serializer());
        addDeserializer(ProductReference.class,new ProductIdParser.Deserializer());

        addSerializer(ProductName.class, new ProductNameParser.Serializer());
        addDeserializer(ProductName.class, new ProductNameParser.Deserializer());

        addSerializer(ProductPrice.class, new ProductPriceParser.Serializer());
        addDeserializer(ProductPrice.class, new ProductPriceParser.Deserializer());

        addSerializer(ProductDescription.class, new ProductDescriptionParser.Serializer());
        addDeserializer(ProductDescription.class, new ProductDescriptionParser.Deserializer());
    }
}
