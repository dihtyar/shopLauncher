package com;

import java.math.BigDecimal;

public class DiscountManager implements Discounter{

    private final BigDecimal discount;
    private final BigDecimal topPrice;

    public DiscountManager(BigDecimal discount, BigDecimal topPrice) {
        this.discount = discount;
        this.topPrice = topPrice;
    }

    @Override
    public BigDecimal evaluatePriceWithDiscount(BigDecimal price){
        if(price.compareTo(topPrice) < 1){
            return price.multiply(discount);
        }
        return price;
    }
}
