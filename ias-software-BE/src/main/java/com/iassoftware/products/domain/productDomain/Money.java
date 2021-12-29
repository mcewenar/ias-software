package com.iassoftware.products.domain.productDomain;
import java.math.BigDecimal;

public class Money {
    public static final Money ZERO = new Money(BigDecimal.ZERO);
    private final BigDecimal money;

    public Money(BigDecimal money) {
        this.money = money;

    }
    public BigDecimal getMoney() {
        return money;
    }




}
