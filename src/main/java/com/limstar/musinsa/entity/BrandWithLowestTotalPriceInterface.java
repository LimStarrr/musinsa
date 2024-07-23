package com.limstar.musinsa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface BrandWithLowestTotalPriceInterface {
    @JsonProperty("브랜드")
    String getBrand();
    @JsonProperty("총액")
    int getTotalPrice();
}
