package com.projetochernobyl.sturdyenigma.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetochernobyl.sturdyenigma.domain.Address;
import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.domain.City;
import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.domain.Product;
import com.projetochernobyl.sturdyenigma.domain.State;
import com.projetochernobyl.sturdyenigma.domain.enums.ClientType;
import com.projetochernobyl.sturdyenigma.repository.AddressRepository;
import com.projetochernobyl.sturdyenigma.repository.CategoryRepository;
import com.projetochernobyl.sturdyenigma.repository.CityRepository;
import com.projetochernobyl.sturdyenigma.repository.ClientRepository;
import com.projetochernobyl.sturdyenigma.repository.ProductRepository;
import com.projetochernobyl.sturdyenigma.repository.StateRepository;

@Configuration
@Profile("dbtest")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
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
		
		
		State s1 = new State(null, "Rondônia");
		State s2 = new State(null, "Paraná");
		
		City c1 = new City(null, "Maringá", s2);
		City c2 = new City(null, "Sarandi", s2);
		City c5 = new City(null, "Cerejeiras", s1);
		City c6 = new City(null, "Porto Velho", s1);
		
		stateRepository.saveAll(Arrays.asList(s1, s2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c5, c6));
		
		Client cli1 = new Client(null, "Maria", "m@hotmail.com", "5478545", ClientType.NATURAL_PERSON);
		cli1.getPhones().addAll(Arrays.asList("88996655", "99663322"));
		
		Address ad1 = new Address(null, "rua 1", "987", "zona 5", "87954211", cli1, c1);
		Address ad2 = new Address(null, "rua 2", "55", "Barão Rio Branco", "88954211", cli1, c2);
		
		cli1.getAddresses().addAll(Arrays.asList(ad1, ad2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));
	}

}
