package com.limstar.musinsa.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface CategoryPriceResponseInterface {
    @JsonProperty("금액")
    int getPrice();
    @JsonProperty("카테고리")
    String getCategory();
}
