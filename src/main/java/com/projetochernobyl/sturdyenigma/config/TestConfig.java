package com.projetochernobyl.sturdyenigma.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.domain.Product;
import com.projetochernobyl.sturdyenigma.repository.CategoryRepository;
import com.projetochernobyl.sturdyenigma.repository.ProductRepository;

@Configuration
@Profile("dbtest")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", 90.5, cat2);
		Product p2 = new Product(null, "Smart TV", 2190.0, cat1);
		Product p3 = new Product(null, "Macbook Pro", 1250.0, cat3);
		Product p4 = new Product(null, "PC Gamer", 1200.0, cat3);
		Product p5 = new Product(null, "Rails for Dummies", 100.99, cat2);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}

}
