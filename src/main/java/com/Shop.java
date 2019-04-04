package com;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

    private List<Goods> goodsList;
    private double minimalPrice;
    private Discounter discounter;


    public Shop(List<Goods> goodsList, double minimalPrice, Discounter discounter) {
        this.goodsList = goodsList;
        this.minimalPrice = minimalPrice;
        this.discounter = discounter;
    }

    public Collection<Goods> getAllCheapestGoods() {
        return goodsList.stream()
                .filter(goods -> goods.getPrice() <= minimalPrice)
                .collect(Collectors.toList());
    }

    public BigDecimal calculateTotalPriceWithDiscount() {
        return goodsList.stream()
                .map(goods -> {
                    return new BigDecimal(goods.getPrice());
                })
                .reduce((price1, price2) -> price1.add(price2))
                .orElse(new BigDecimal(0))
                .setScale(0, RoundingMode.FLOOR);
    }
}
