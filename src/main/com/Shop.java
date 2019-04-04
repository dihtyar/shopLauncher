package main.com;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

    private List<Goods> goodsList;
    private double minimalPrice;


    public Shop(List<Goods> goodsList, double minimalPrice) {
        this.goodsList = goodsList;
        this.minimalPrice = minimalPrice;
    }

    public Collection<Goods> getAllCheapestGoods() {
        return goodsList.stream()
                .filter(goods -> goods.getPrice() <= minimalPrice)
                .collect(Collectors.toList());
    }
}
