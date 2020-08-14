package com.dongbiao.gilederose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonProductServiceTests {

    private Integer beforeExpiredSellIn = 30;

    @DisplayName("Update common product and can reduce quality.")
    @Test
    public void GivenBeforeExpiredAndValidQuality_ThenUpdateProduct_ShouldQualityMinusOne() {
        Product product = Product.builder().sellIn(beforeExpiredSellIn).quality(10).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = 9;
        Integer expectedSellIn = 29;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenJustExpiredAndValidQuality_ThenUpdateProduct_ShouldQualityMinusTwo() {
        Product product = Product.builder().sellIn(0).quality(10).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = 8;
        Integer expectedSellIn = -1;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenExpiredAndQualityIsOne_ThenUpdateProduct_ShouldQualityMinusOne() {
        Product product = Product.builder().sellIn(-1).quality(1).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = 0;
        Integer expectedSellIn = -2;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenBeforeExpiredAndQualityIsOne_ThenUpdateProduct_ShouldQualityMinusOne() {
        Product product = Product.builder().sellIn(beforeExpiredSellIn).quality(1).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = 0;
        Integer expectedSellIn = 29;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }
}