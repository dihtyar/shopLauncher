package com;

import java.math.BigDecimal;

public interface Discounter {

    BigDecimal evaluatePriceWithDiscount(BigDecimal price);
}