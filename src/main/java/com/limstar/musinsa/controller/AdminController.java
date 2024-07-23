package com.limstar.musinsa.controller;

import com.limstar.musinsa.entity.Product;
import com.limstar.musinsa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//4. 운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    ProductService productsService;

    @PostMapping("/product")
    @ResponseBody
    public Product createBrand(Product product) {
        return productsService.saveProduct(product);
    }

    @PutMapping("/product")
    @ResponseBody
    public Product updateBrand(long id) {
        return productsService.putProduct(id);
    }
    @GetMapping("/product")
    @ResponseBody
    public Product getBrand(long id) {
        return productsService.findProductById(id);
    }

    @DeleteMapping("/product")
    @ResponseBody
    public void deleteBrand(long id) {
        productsService.deleteProduct(id);
    }
}
