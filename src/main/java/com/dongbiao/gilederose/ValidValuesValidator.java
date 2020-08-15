package com.dongbiao.gilederose;

import static com.dongbiao.gilederose.Config.MIN_PRODUCT_QUALITY;

public class ValidValuesValidator {
    public static boolean validate(Product product) {
        return !(product.getSellIn() <= 0 && product.getQuality().equals(MIN_PRODUCT_QUALITY));
    }
}
