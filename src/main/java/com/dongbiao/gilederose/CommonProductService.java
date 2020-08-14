package com.dongbiao.gilederose;

public class CommonProductService {
    public static Product updateProduct(Product product) {
        if (product.getSellIn() > 0) {
            product.updateQuality(product.getQuality() - 1);
        } else {
            Integer quality = product.getQuality() - 2 >= 0 ? product.getQuality() - 2 : 0;
            product.updateQuality(quality);
        }
        product.updateSellIn(product.getSellIn() - 1);

        return product;
    }
}
