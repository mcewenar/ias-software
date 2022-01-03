package com.iassoftware.products.domain.productDomain;
import java.math.BigDecimal;

public class Money {
    private final BigDecimal money;
    private final Divisa divisa;

    public Money(BigDecimal money, Divisa divisa) {
        this.money = money;
        this.divisa = divisa;

    }

    public BigDecimal getMoney() {
        return money;
    }

    public Divisa getDivisa() {
        return divisa;
    }
}
