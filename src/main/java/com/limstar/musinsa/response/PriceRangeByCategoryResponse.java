package com.limstar.musinsa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.limstar.musinsa.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PriceRangeByCategoryResponse {
    @JsonProperty("카테고리")
    String category;
    @JsonProperty("최고가")
    List<Product> topGoods = new ArrayList<>();
    @JsonProperty("최저가")
    List<Product> lowGoods = new ArrayList<>();;


}
