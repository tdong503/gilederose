package com.dongbiao.gilederose;

import org.junit.jupiter.api.Test;

import static com.dongbiao.gilederose.Config.MAX_PRODUCT_QUALITY;
import static com.dongbiao.gilederose.Config.MIN_PRODUCT_QUALITY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassServiceTests {

    @Test
    public void GivenSellInMoreThanTenAndValidQuality_WhenUpdateProduct_ThenQualityPlusOne() {
        Integer sellInMoreThanTen = 15;
        Integer validQuality = 20;
        Product product = Product.builder().sellIn(sellInMoreThanTen).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 21;
        Integer expectedSellIn = 14;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInJustTenAndValidQuality_WhenUpdateProduct_ThenQualityPlusTwo() {
        Integer sellInJustTen = 10;
        Integer validQuality = 45;
        Product product = Product.builder().sellIn(sellInJustTen).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 47;
        Integer expectedSellIn = 9;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInBetweenTenAndFiveAndValidQuality_WhenUpdateProduct_ThenQualityPlusTwo() {
        Integer sellInBetweenTenAndFive = 9;
        Integer validQuality = 45;
        Product product = Product.builder().sellIn(sellInBetweenTenAndFive).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 47;
        Integer expectedSellIn = 8;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInJustTenAndValidQuality_WhenUpdateProduct_ThenQualityEqualsMax() {
        Integer sellInJustTen = 10;
        Integer validQuality = 49;
        Product product = Product.builder().sellIn(sellInJustTen).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedSellIn = 9;
        assertEquals(MAX_PRODUCT_QUALITY, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInJustTenAndMaxQuality_WhenUpdateProduct_ThenQualityEqualsMax() {
        Integer sellInJustTen = 10;
        Product product = Product.builder().sellIn(sellInJustTen).quality(MAX_PRODUCT_QUALITY).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedSellIn = 9;
        assertEquals(MAX_PRODUCT_QUALITY, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInJustFiveAndValidQuality_WhenUpdateProduct_ThenQualityEqualsMax() {
        Integer sellInJustFive = 5;
        Integer validQuality = 49;
        Product product = Product.builder().sellIn(sellInJustFive).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedSellIn = 4;
        assertEquals(MAX_PRODUCT_QUALITY, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInJustFiveAndValidQuality_WhenUpdateProduct_ThenQualityPlusThree() {
        Integer sellInJustFive = 5;
        Integer validQuality = 45;
        Product product = Product.builder().sellIn(sellInJustFive).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 48;
        Integer expectedSellIn = 4;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInJustOneAndValidQuality_WhenUpdateProduct_ThenQualityPlusThree() {
        Integer sellInJustOne = 1;
        Integer validQuality = 20;
        Product product = Product.builder().sellIn(sellInJustOne).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedQuality = 23;
        Integer expectedSellIn = 0;
        assertEquals(expectedQuality, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }

    @Test
    public void GivenSellInJustZeroAndValidQuality_ThenUpdateProduct_ShouldQualityEqualsMin() {
        Integer expiredSellIn = 0;
        Integer validQuality = 20;
        Product product = Product.builder().sellIn(expiredSellIn).quality(validQuality).build();

        Product result = BackstagePassService.updateProduct(product);

        Integer expectedSellIn = -1;
        assertEquals(MIN_PRODUCT_QUALITY, result.getQuality());
        assertEquals(expectedSellIn, result.getSellIn());
    }
}
