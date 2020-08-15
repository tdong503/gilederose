package com.dongbiao.gilederose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer sellIn;
    private Integer quality;
    private ProductType productType;
    private String id;

    public void updateSellIn(Integer sellIn) {
        this.sellIn = sellIn;
    }

    public void updateQuality(Integer quality) {
        this.quality= quality;
    }
}