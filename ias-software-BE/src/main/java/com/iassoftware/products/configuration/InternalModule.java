package com.iassoftware.products.configuration;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

import com.iassoftware.products.configuration.PersonJacksonCodecs.PersonIdParser;
import com.iassoftware.products.configuration.PersonJacksonCodecs.PersonNameParser;
import com.iassoftware.products.configuration.ProductJacksonCodecs.ProductDescriptionParser;
import com.iassoftware.products.configuration.ProductJacksonCodecs.ProductIdParser;
import com.iassoftware.products.configuration.ProductJacksonCodecs.ProductNameParser;
import com.iassoftware.products.configuration.ProductJacksonCodecs.ProductPriceParser;
import com.iassoftware.products.domain.personDomain.PersonId;
import com.iassoftware.products.domain.personDomain.PersonName;
import com.iassoftware.products.domain.productDomain.ProductDescription;
import com.iassoftware.products.domain.productDomain.ProductName;
import com.iassoftware.products.domain.productDomain.ProductPrice;
import com.iassoftware.products.domain.productDomain.ProductReference;

public class InternalModule extends SimpleModule {

    private static final String NAME = "InternalModule";

    public InternalModule() {

        //PRODUCT:
        super(NAME, Version.unknownVersion());
        addSerializer(ProductReference.class, new ProductIdParser.Serializer());
        addDeserializer(ProductReference.class,new ProductIdParser.Deserializer());

        addSerializer(ProductName.class, new ProductNameParser.Serializer());
        addDeserializer(ProductName.class, new ProductNameParser.Deserializer());

        addSerializer(ProductPrice.class, new ProductPriceParser.Serializer());
        addDeserializer(ProductPrice.class, new ProductPriceParser.Deserializer());

        addSerializer(ProductDescription.class, new ProductDescriptionParser.Serializer());
        addDeserializer(ProductDescription.class, new ProductDescriptionParser.Deserializer());

        //PERSONS:

        addSerializer(PersonId.class, new PersonIdParser.Serializer());
        addDeserializer(PersonId.class, new PersonIdParser.Deserializer());

        addSerializer(PersonName.class, new PersonNameParser.Serializer());
        addDeserializer(PersonName.class, new PersonNameParser.Deserializer());

        //SHOPPING CAR:


    }
}
