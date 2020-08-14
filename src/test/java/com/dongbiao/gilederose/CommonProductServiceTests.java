package com.dongbiao.gilederose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonProductServiceTests {

    @Test
    public void GivenBeforeExpiredAndValidQuality_ThenUpdateProduct_ShouldUpdateSuccess() {
        Product product = Product.builder().sellIn(40).quality(10).build();

        Product result = CommonProductService.updateProduct(product);

        assertEquals(9, result.getQuality());
        assertEquals(39, result.getSellIn());
    }
}