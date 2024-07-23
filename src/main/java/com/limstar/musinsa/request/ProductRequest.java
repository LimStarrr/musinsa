package com.limstar.musinsa.request;

import com.limstar.musinsa.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private long id;
    private String brand;
    private String category;
    private int price;

    public static Product valueOf(ProductRequest productRequest) {
        return Product.builder()
                .id(productRequest.getId())
                .brand(productRequest.getBrand())
                .category(productRequest.getCategory())
                .price(productRequest.getPrice())
                .build();
    }
}
