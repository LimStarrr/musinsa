package com.limstar.musinsa;

import com.limstar.musinsa.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class ProductApplicationTests {

	@BeforeAll
	static void init() {
		System.out.println("start init");
	}

	@BeforeEach
	void setUp() {
		System.out.println("start etUp");

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
	public void create() {
	}

	@Test
	@DisplayName("가져오기")
	public void get() {

	}
	@Test
	@DisplayName("업데이트")
	public void update() {

	}

	@Test
	@DisplayName("삭제")
	public void delete() {

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

