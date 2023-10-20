package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Order {
    String orderName;
    List<List<String>> shopping_basket = new ArrayList<>();

    HashMap<String, String[]> basket = new HashMap<>();

    public void basket(String name, String price, String content) {
        this.orderName = name;
        this.shopping_basket.add(new ArrayList<>(Arrays.asList(name, price, content)));

        if (basket.containsKey(name)) {
            String goodsCount = String.valueOf(Integer.parseInt(basket.get(name)[2]) + 1);
            basket.replace(name, new String[]{name, price, goodsCount, content});
        } else {
            basket.put(name, new String[]{name, price, "1", content});
        }


    }
}

