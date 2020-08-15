package com.dongbiao.gilederose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.dongbiao.gilederose.Config.MIN_PRODUCT_QUALITY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonProductServiceTests {

    @DisplayName("Update common product and can reduce quality.")
    @Test
    public void GivenBeforeExpiredAndValidQuality_ThenUpdateProduct_ShouldQualityMinusOne() {
        Integer beforeExpiredSellIn = 30;
        Integer validQuality = 10;
        Product product = Product.builder().sellIn(beforeExpiredSellIn).quality(validQuality).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = 9;
        Integer expectedSellIn = 29;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenJustExpiredAndValidQuality_ThenUpdateProduct_ShouldQualityMinusTwo() {
        Integer expiredSellIn = 0;
        Integer validQuality = 10;
        Product product = Product.builder().sellIn(expiredSellIn).quality(validQuality).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = 8;
        Integer expectedSellIn = -1;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenExpiredAndQualityIsOne_ThenUpdateProduct_ShouldQualityMinusOne() {
        Integer expiredSellIn = -1;
        Integer quality = 1;
        Product product = Product.builder().sellIn(expiredSellIn).quality(quality).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = MIN_PRODUCT_QUALITY;
        Integer expectedSellIn = -2;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenBeforeExpiredAndQualityIsOne_ThenUpdateProduct_ShouldQualityMinusOne() {
        Integer beforeExpiredSellIn = 30;
        Integer quality = 1;
        Product product = Product.builder().sellIn(beforeExpiredSellIn).quality(quality).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = MIN_PRODUCT_QUALITY;
        Integer expectedSellIn = 29;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenExpiredAndQualityIsZero_ThenUpdateProduct_ShouldQualityNoChange() {
        Integer beforeExpiredSellIn = 0;
        Integer quality = 0;
        Product product = Product.builder().sellIn(beforeExpiredSellIn).quality(quality).build();

        Product result = CommonProductService.updateProduct(product);

        Integer expectedQuality = MIN_PRODUCT_QUALITY;
        Integer expectedSellIn = -1;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }
}