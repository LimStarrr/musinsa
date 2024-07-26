package com.limstar.musinsa.repository;

import com.limstar.musinsa.response.BrandWithLowestTotalPriceInterface;
import com.limstar.musinsa.entity.Product;
import com.limstar.musinsa.entity.LowestPriceByCategoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findProductById(long id);

    @Query(value = "SELECT p.category, p.brand, p.price FROM product p JOIN (SELECT category, MIN(price) AS min_price FROM product GROUP BY category) AS min_prices " +
            "ON p.category = min_prices.category AND p.price = min_prices.min_price", nativeQuery = true)
    Optional<List<LowestPriceByCategoryInterface>> findLowestPriceByCategory();

    @Query(value = "SELECT brand, SUM(price) AS total_price FROM product GROUP BY brand ORDER BY total_price ASC LIMIT 1", nativeQuery = true)
    Optional<BrandWithLowestTotalPriceInterface> finBrandWithLowestTotalPrice();

    public Optional<List<Product>> findProductByBrand(String brand);

    /*SELECT p.brand, p.price  FROM Product p WHERE p.category = :category  ORDER BY p.price ASC*/
    public Optional<Product> findFirstByCategoryOrderByPriceAsc(String category);
    public Optional<Product> findFirstByCategoryOrderByPriceDesc(String category);
}
