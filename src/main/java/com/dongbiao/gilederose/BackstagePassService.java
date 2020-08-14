package com.dongbiao.gilederose;

public class BackstagePassService {
    public static Product updateProduct(Product product) {
        if(product.getSellIn() > 10) {
            product.updateSellIn(product.getSellIn() - 1);
        }
        return product;
    }
}
