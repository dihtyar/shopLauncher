package com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopLauncher {

    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>(Arrays.asList(
                new Goods("Good1", 1.99),
                new Goods("Good1", 2.99),
                new Goods("Good1", 0.99),
                new Goods("Good1", 1.50),
                new Goods("Good1", 5.80)
        ));
        Discounter discounter = new DiscountManager(new BigDecimal(0.1), new BigDecimal(5.0));
        Shop shop = new Shop(goodsList, 1.80, discounter);

        System.out.println(shop.getAllCheapestGoods());
    }
}
