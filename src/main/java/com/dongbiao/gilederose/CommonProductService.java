package com.dongbiao.gilederose;

import static com.dongbiao.gilederose.Config.MIN_PRODUCT_QUALITY;

public class CommonProductService {
    public static Product updateProduct(Product product) {
        if (product.getSellIn() > 0) {
            product.updateQuality(product.getQuality() - 1);
        } else {
            Integer quality = Math.max(product.getQuality() - 2, MIN_PRODUCT_QUALITY);
            product.updateQuality(quality);
        }
        product.updateSellIn(product.getSellIn() - 1);

        return product;
    }
}
