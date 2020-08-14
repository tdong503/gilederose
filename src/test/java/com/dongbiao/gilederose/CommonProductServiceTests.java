package com.dongbiao.gilederose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonProductServiceTests {

    @DisplayName("Update common product and can reduce quality.")
    @Test
    public void GivenBeforeExpiredAndValidQuality_ThenUpdateProduct_ShouldQualityMinusOne() {
        Product product = Product.builder().sellIn(40).quality(10).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = 9;
        Integer expectedSellIn = 39;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenNotBeforeExpiredAndValidQuality_ThenUpdateProduct_ShouldQualityMinusTwo() {
        Product product = Product.builder().sellIn(0).quality(10).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = 8;
        Integer expectedSellIn = -1;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }
}