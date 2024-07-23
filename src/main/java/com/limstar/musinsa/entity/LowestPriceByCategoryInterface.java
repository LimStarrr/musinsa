package com.limstar.musinsa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface LowestPriceByCategoryInterface {
    @JsonProperty("카테고리")
    String getCategory();
    @JsonProperty("브랜드")
    String getBrand();
    @JsonProperty("가격")
    int getPrice();
}
