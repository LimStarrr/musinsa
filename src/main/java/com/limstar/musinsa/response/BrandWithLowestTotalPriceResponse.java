package com.limstar.musinsa.response;

import com.fasterxml.jackson.annotation.*;
import com.limstar.musinsa.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/*

"최저가" : {
"브랜드" : "D",
"카테고리" : [
{"카테고리" : "상의", "가격" : "10,100"},
{"카테고리" : "아우터", "가격" : "5,100"},
{"카테고리" : "바지", "가격" : "3,000"},
{"카테고리" : "스니커즈", "가격" : "9,500"},
{"카테고리" : "가방", "가격" : "2,500"},
{"카테고리" : "모자", "가격" : "1,500"},
{"카테고리" : "양말", "가격" : "2,400"},
{"카테고리" : "액세서리", "가격" : "2,000"}
],
"총액" : "36,100"
}
}
● API 실패 시
 */
@Getter
@Setter
@JsonTypeName("최저가")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
public class BrandWithLowestTotalPriceResponse {
    @JsonProperty("브랜드")
    String brand;
    @JsonProperty("카테고리")
    List<Product> productList = new ArrayList<>();
    @JsonProperty("총액")
    int totalPrice;
}

