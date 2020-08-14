package com.dongbiao.gilederose;

public class CommonProductService {
    public static Product updateProduct(Product product) {
        product.updateSellIn(product.getSellIn() - 1);
        product.updateQuality(product.getQuality() - 1);
        return product;
    }
}
