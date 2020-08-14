package com.dongbiao.gilederose;

import org.junit.jupiter.api.Test;

public class CommonProductServiceTests {

    @Test
    public void GivenBeforeExpiredAndValidQuality_ThenUpdateProduct_ShouldUpdateSuccess() {
        Product product = Product.builder().sellIn(40).quality(10).build();

        Product result = CommonProductService.updateProduct(product);

    }
}