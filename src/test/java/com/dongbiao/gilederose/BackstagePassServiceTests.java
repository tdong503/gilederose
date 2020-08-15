package com.dongbiao.gilederose;

import org.junit.jupiter.api.Test;

import static com.dongbiao.gilederose.Config.MAX_PRODUCT_QUALITY;
import static com.dongbiao.gilederose.Config.MIN_PRODUCT_QUALITY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassServiceTests {

    @Test
    public void GivenSellInMoreThanTenAndValidQuality_WhenUpdateProduct_ThenQualityNoChange() {
        Integer sellInMoreThanTen = 30;
        Integer validQuality = 20;
        Product product = Product.builder().sellIn(sellInMoreThanTen).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 20;
        Integer expectedSellIn = 29;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenTenAndFiveAndValidQuality_WhenUpdateProduct_ThenQualityPlusTwo() {
        Integer sellInBetweenTenAndFive = 7;
        Integer validQuality = 20;
        Product product = Product.builder().sellIn(sellInBetweenTenAndFive).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 22;
        Integer expectedSellIn = 6;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenFiveAndZeroAndValidQuality_WhenUpdateProduct_ThenQualityPlusThree() {
        Integer sellInBetweenFiveAndZero = 4;
        Integer validQuality = 20;
        Product product = Product.builder().sellIn(sellInBetweenFiveAndZero).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 23;
        Integer expectedSellIn = 3;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenExpiredSellInAndValidQuality_WhenUpdateProduct_ThenQualityIsZero() {
        Integer expiredSellIn = 0;
        Integer validQuality = 20;
        Product product = Product.builder().sellIn(expiredSellIn).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = MIN_PRODUCT_QUALITY;
        Integer expectedSellIn = -1;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenTenAndFiveAndQualityIsMaxQuality_ThenUpdateProduct_ShouldQualityNoChange() {
        Integer sellInBetweenTenAndFive = 7;
        Product product = Product.builder().sellIn(sellInBetweenTenAndFive).quality(MAX_PRODUCT_QUALITY).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = MAX_PRODUCT_QUALITY;
        Integer expectedSellIn = 6;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenFiveAndZeroAndQualityIsMaxQuality_ThenUpdateProduct_ShouldQualityNoChange() {
        Integer sellInBetweenFiveAndZero = 4;
        Product product = Product.builder().sellIn(sellInBetweenFiveAndZero).quality(MAX_PRODUCT_QUALITY).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = MAX_PRODUCT_QUALITY;
        Integer expectedSellIn = 3;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }
}
