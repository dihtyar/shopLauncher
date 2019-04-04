package com;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;

import static java.math.RoundingMode.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class ShopTest {

    private final static double MINIMAL_PRICE = 2.0;
    private final static Goods goods = new Goods("goods", 1.8);
    private final static Goods goods1 = new Goods("goods1", 1.0);
    private final static Goods goods2 = new Goods("goods2", 0.8);

    private Shop shopUnderTest;
    private Discounter discounter;

    @Before
    public void setUp() {
        this.discounter = Mockito.mock(Discounter.class);
        this.shopUnderTest = new Shop(
                asList(
                        goods,
                        new Goods("goods", 2.8),
                        goods1,
                        new Goods("goods", 3.8),
                        new Goods("goods", 5.0),
                        goods2
                ),
                MINIMAL_PRICE,
                discounter
        );
    }

    @Test
    public void getAllCheapestGoods() {
        Collection<Goods> cheapestGoods = shopUnderTest.getAllCheapestGoods();

        assertNotNull(cheapestGoods);
        assertEquals(3, cheapestGoods.size());
        assertTrue(cheapestGoods.contains(goods1));
        assertTrue(cheapestGoods.contains(goods));
        assertTrue(cheapestGoods.contains(goods2));

    }

    @Test
    public void calculateTotalPriceWithDiscount() {
        when(discounter.evaluatePriceWithDiscount(any(BigDecimal.class)))
                .thenReturn(new BigDecimal(1));

        assertEquals(new BigDecimal(15), shopUnderTest.calculateTotalPriceWithDiscount());
    }
}