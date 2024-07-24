package com.limstar.musinsa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.limstar.musinsa.controller.MusinsaController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("api test case")
@SpringBootTest
@AutoConfigureMockMvc
public class ProductApiTest {
    @Autowired
    protected MockMvc mockMvc;

    @Test
    @DisplayName("구현 1) - 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API")
    public void getLowestPriceByCategoryTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/musinsa/lowestprice"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("구현 2) - 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API")
    public void getBrandWithLowestTotalPriceTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/musinsa/brandwithlowesttotalprice"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("구현 3) - 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API")
    public void getRanageBrandPriceTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/musinsa/H"))
                .andExpect(status().is4xxClientError());
    }
}
