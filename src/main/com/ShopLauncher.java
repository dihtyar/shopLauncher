package main.com;

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
                new Goods("Good1", 1.80)
        ));
        Shop shop = new Shop(goodsList, 1.80);

        System.out.println(shop.getAllCheapestGoods());
    }
}
