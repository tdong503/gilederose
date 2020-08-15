package com.dongbiao.gilederose;

import org.junit.jupiter.api.Test;

import static com.dongbiao.gilederose.Config.MAX_PRODUCT_QUALITY;
import static com.dongbiao.gilederose.Config.MIN_PRODUCT_QUALITY;
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

    @Test
    public void GivenExpiredSellInAndValidQuality_WhenUpdateProduct_ThenQualityIsZero() {
        Product product = Product.builder().sellIn(0).quality(20).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = MIN_PRODUCT_QUALITY;
        Integer expectedSellIn = -1;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenTenAndFiveAndQualityIsFifty_ThenUpdateProduct_ShouldQualityNoChange() {
        Product product = Product.builder().sellIn(7).quality(50).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = MAX_PRODUCT_QUALITY;
        Integer expectedSellIn = 6;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenFiveAndZeroAndQualityIsFifty_ThenUpdateProduct_ShouldQualityNoChange() {
        Product product = Product.builder().sellIn(3).quality(50).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = MAX_PRODUCT_QUALITY;
        Integer expectedSellIn = 2;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }
}
