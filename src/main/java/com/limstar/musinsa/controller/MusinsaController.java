package com.limstar.musinsa.controller;

import com.limstar.musinsa.entity.LowestPriceByCategoryInterface;
import com.limstar.musinsa.response.BrandWithLowestTotalPriceResponse;
import com.limstar.musinsa.response.PriceRangeByCategoryResponse;
import com.limstar.musinsa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
1. 고객은 카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액이 얼마인지 확인할 수 있어야 합니다.
2. 고객은 단일 브랜드로 전체 카테고리 상품을 구매할 경우 최저가격인 브랜드와 총액이 얼마인지 확인할 수 있어야 합니다.
3. 고객은 특정 카테고리에서 최저가격 브랜드와 최고가격 브랜드를 확인하고 각 브랜드 상품의 가격을 확인할 수 있어야 합니다.
4. 운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.
 */
@Controller
@RequestMapping(value = "/musinsa")
public class MusinsaController
{
    @Autowired
    ProductService productsService;
    @Description("구현 1) - 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API")
    @GetMapping("/lowestprice")
    public ResponseEntity<List<LowestPriceByCategoryInterface>> getLowestPriceByCategory() {
        List<LowestPriceByCategoryInterface> result = productsService.getLowestPriceByCategory();
        return  ResponseEntity.ok(result);
    }

    @Description("구현 2) - 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API")
    @GetMapping("/lowwesttotalprice")
    public ResponseEntity<BrandWithLowestTotalPriceResponse> getBrandWithLowestTotalPrice() {
        BrandWithLowestTotalPriceResponse result = productsService.getBrandWithLowestTotalPrice();
        return  ResponseEntity.ok(result);
    }
    @Description("구현 3) - 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API")
    @GetMapping("/{category}")
    public ResponseEntity<PriceRangeByCategoryResponse> getRanageBrandPrice(@PathVariable("category") String category ) {
        PriceRangeByCategoryResponse result = productsService.getPriceRangeByCategory(category);
        return  ResponseEntity.ok(result);
    }
}
