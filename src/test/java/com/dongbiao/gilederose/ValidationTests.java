package com.dongbiao.gilederose;

import org.junit.jupiter.api.Test;

import static com.dongbiao.gilederose.Config.MIN_PRODUCT_QUALITY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTests {

    @Test
    public void GivenValidSellInAndQuality_WhenValidateValid_ThenTrue() {
        Product product = Product.builder().sellIn(30).quality(10).build();

        boolean result = ValidValuesValidator.validate(product);

        assertEquals(true, result);
    }

    @Test
    public void GivenExpiredSellInAndValidQuality_WhenValidateValid_ThenTrue() {
        Product product = Product.builder().sellIn(-2).quality(10).build();

        boolean result = ValidValuesValidator.validate(product);

        assertEquals(true, result);
    }

    @Test
    public void GivenBeforeSellInAndQualityIsMinQuality_WhenValidateValid_ThenTrue() {
        Product product = Product.builder().sellIn(30).quality(MIN_PRODUCT_QUALITY).build();

        boolean result = ValidValuesValidator.validate(product);

        assertEquals(true, result);
    }

    @Test
    public void GivenExpiredSellInAndQualityIsMinQuality_WhenValidateValid_ThenFalse() {
        Product product = Product.builder().sellIn(-2).quality(MIN_PRODUCT_QUALITY).build();

        boolean result = ValidValuesValidator.validate(product);

        assertEquals(false, result);
    }
}
