package com.limstar.musinsa.controller;

import com.limstar.musinsa.entity.Product;
import com.limstar.musinsa.request.ProductRequest;
import com.limstar.musinsa.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//4. 운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    ProductService productsService;

    @PostMapping("/product")
    @ResponseBody
    public Product createProduct(@RequestBody ProductRequest product) {
        return productsService.saveProduct(ProductRequest.valueOf(product));
    }

    @PutMapping("/product")
    @ResponseBody
    public Product updateProduct(@RequestBody ProductRequest product) {
        return productsService.putProduct(ProductRequest.valueOf(product));
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable Long id) {
        return productsService.getProductById(id);
    }

    @DeleteMapping("/product/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }
}
