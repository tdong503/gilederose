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
}
