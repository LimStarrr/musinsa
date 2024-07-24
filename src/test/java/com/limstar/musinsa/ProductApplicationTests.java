package com.limstar.musinsa;

import com.limstar.musinsa.entity.Product;
import com.limstar.musinsa.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@BeforeAll
	static void init() {
		System.out.println("start init");
	}

	@BeforeEach
	void setUp() {
		System.out.println("start setUp");

	}

	@AfterEach
	void tearDown() {

	}

	@AfterAll
	static void tearDownAll() {
	}

	void failingTest() {
		fail("a failing test");
	}
	@Test
	@DisplayName("생성")
	public void saveTest() {
		Product product = Product.builder()
				.brand("J")
				.category("양말")
				.price(5000)
				.build();

		Product savedProduct = productRepository.save(product);
		Assertions.assertEquals("J", savedProduct.getBrand());
		Assertions.assertEquals("양말", savedProduct.getCategory());
		Assertions.assertEquals(5000, savedProduct.getPrice());
	}

	@Test
	@DisplayName("가져오기")
	public void get() {
		Product product = Product.builder()
				.brand("K")
				.category("양말")
				.price(5000)
				.build();

		Product savedProduct = productRepository.save(product);

		Product foundProduct = productRepository.findProductById(savedProduct.getId());

		Assertions.assertEquals("K", foundProduct.getBrand());
		Assertions.assertEquals("양말", foundProduct.getCategory());
		Assertions.assertEquals(5000, foundProduct.getPrice());
	}

	@Test
	@DisplayName("업데이트")
	public void update() {
		Product product = Product.builder()
				.brand("L")
				.category("양말")
				.price(5000)
				.build();

		productRepository.save(product);

		Product modifiedProduct = Product.builder().brand("M").category("장갑").price(6300).build();

		Product saveModifiedProduct = productRepository.save(modifiedProduct);

		Assertions.assertNotEquals(product.getCategory(), saveModifiedProduct.getCategory());
		Assertions.assertNotEquals(product.getBrand(), saveModifiedProduct.getBrand());
		Assertions.assertNotEquals(product.getPrice(), saveModifiedProduct.getPrice());

		Assertions.assertEquals("장갑", saveModifiedProduct.getCategory());
		Assertions.assertEquals("M", saveModifiedProduct.getBrand());
		Assertions.assertEquals(6300, saveModifiedProduct.getPrice());
	}

	@Test
	@DisplayName("삭제")
	public void delete() {
		Product product = Product.builder().brand("N").category("구두").price(12000).build();

		Product savedProduct = productRepository.save(product);
		Assertions.assertEquals("N", savedProduct.getBrand());

		productRepository.delete(savedProduct);
		Optional<List<Product>> findProduct = productRepository.findProductByBrand("N");

		Assertions.assertTrue(findProduct.isPresent());
	}

	@Test
	@DisplayName("1번")
	public void test1() {

	}

	@Test
	@DisplayName("2번")
	public void test2() {

	}
	@Test
	@DisplayName("3번")
	public void test3() {

	}
}

