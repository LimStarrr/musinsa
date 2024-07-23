package com.limstar.musinsa.service;

import com.limstar.musinsa.entity.BrandWithLowestTotalPriceInterface;
import com.limstar.musinsa.entity.Product;
import com.limstar.musinsa.entity.LowestPriceByCategoryInterface;
import com.limstar.musinsa.error.CustomException;
import com.limstar.musinsa.error.ErrorCode;
import com.limstar.musinsa.repository.ProductRepository;
import com.limstar.musinsa.response.BrandWithLowestTotalPriceResponse;
import com.limstar.musinsa.response.PriceRangeByCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public Product putProduct(Product product) {
        return productRepository.save(product);
    }
    public Product getProductById(long id) {
        return productRepository.findProductById(id);
    }

    public void deleteProduct(long id) {
        Product product = productRepository.findProductById(id);
        productRepository.delete(product);
    }

    public BrandWithLowestTotalPriceResponse getBrandWithLowestTotalPrice() {
        BrandWithLowestTotalPriceInterface brandWithLowestTotalPriceInterface =
                productRepository.finBrandWithLowestTotalPrice().orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        List<Product> productList = productRepository.findProductByBrand(brandWithLowestTotalPriceInterface.getBrand()).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        BrandWithLowestTotalPriceResponse brandWithLowestTotalPriceResponse = new BrandWithLowestTotalPriceResponse();
        brandWithLowestTotalPriceResponse.setBrand(brandWithLowestTotalPriceInterface.getBrand());
        brandWithLowestTotalPriceResponse.setTotalPrice(brandWithLowestTotalPriceInterface.getTotalPrice());
        brandWithLowestTotalPriceResponse.setProductList(productList);

        return brandWithLowestTotalPriceResponse;
    }

    public List<LowestPriceByCategoryInterface> getLowestPriceByCategory() {
       return productRepository.findLowestPriceByCategory().orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));
    }

    public PriceRangeByCategoryResponse getPriceRangeByCategory(String category) {
        Product topProduct = productRepository.findFirstByCategoryOrderByPriceDesc(category).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));
        Product lowProduct = productRepository.findFirstByCategoryOrderByPriceAsc(category).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));

        PriceRangeByCategoryResponse priceRangeByCategoryResponse = new PriceRangeByCategoryResponse();
        priceRangeByCategoryResponse.setCategory(category);
        priceRangeByCategoryResponse.getLowGoods().add(lowProduct);
        priceRangeByCategoryResponse.getTopGoods().add(topProduct);
        return priceRangeByCategoryResponse;
    }
}
