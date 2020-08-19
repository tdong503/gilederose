package com.dongbiao.gilederose;

import static com.dongbiao.gilederose.Config.MAX_PRODUCT_QUALITY;

public class BackstagePassService {
    public static Product updateProduct(Product product) {
        if (product.getSellIn() > 10) {
            product.updateQuality(product.getQuality() + 1);
        } else if (product.getSellIn() > 5) {
            Integer quality = Math.min(product.getQuality() + 2, MAX_PRODUCT_QUALITY);
            product.updateQuality(quality);
        } else if (product.getSellIn() > 0) {
            Integer quality = Math.min(product.getQuality() + 3, MAX_PRODUCT_QUALITY);
            product.updateQuality(quality);
        } else {
            product.updateQuality(0);
        }


        product.updateSellIn(product.getSellIn() - 1);
        return product;
    }
}
