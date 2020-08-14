package com.dongbiao.gilederose;

public class BackstagePassService {
    public static Product updateProduct(Product product) {
        if (product.getSellIn() <= 10) {
            if (product.getSellIn() > 5) {
                product.updateQuality(product.getQuality() + 2);
            } else if (product.getSellIn() > 0) {
                product.updateQuality(product.getQuality() + 3);
            } else {
                product.updateQuality(0);
            }
        }

        product.updateSellIn(product.getSellIn() - 1);
        return product;
    }
}
