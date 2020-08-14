package com.dongbiao.gilederose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassServiceTests {

    @Test
    public void GivenSellInMoreThanTenAndValidQuality_WhenUpdateProduct_ThenQualityNoChange() {
        Product product = Product.builder().sellIn(30).quality(20).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 20;
        Integer expectedSellIn = 29;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenTenAndFiveAndValidQuality_WhenUpdateProduct_ThenQualityPlusTwo() {
        Product product = Product.builder().sellIn(7).quality(20).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 22;
        Integer expectedSellIn = 6;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenFiveAndZeroAndValidQuality_WhenUpdateProduct_ThenQualityPlusThree() {
        Product product = Product.builder().sellIn(4).quality(20).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 23;
        Integer expectedSellIn = 3;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }
}
