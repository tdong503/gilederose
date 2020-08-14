package com.dongbiao.gilederose;

public class CommonProductService {
    public static Product updateProduct(Product product) {
        if (product.getSellIn() > 0) {
            product.updateQuality(product.getQuality() - 1);
        } else {
            product.updateQuality(product.getQuality() - 2);
        }
        product.updateSellIn(product.getSellIn() - 1);

        return product;
    }
}
