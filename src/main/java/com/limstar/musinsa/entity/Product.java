package com.limstar.musinsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonProperty("브랜드")
    @Column(nullable = false, length = 30)
    private String brand;

    @JsonProperty("카테고리")
    @Column(nullable = false, length = 30)
    private String category;

    @JsonProperty("가격")
    @Column
    private int price;

    @JsonIgnore
    @Column(nullable = false)
    private LocalDateTime createDt;
}
