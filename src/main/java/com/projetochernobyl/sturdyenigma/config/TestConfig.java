package com.projetochernobyl.sturdyenigma.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetochernobyl.sturdyenigma.domain.Address;
import com.projetochernobyl.sturdyenigma.domain.CardPayment;
import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.domain.City;
import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.domain.CreditPayment;
import com.projetochernobyl.sturdyenigma.domain.Order;
import com.projetochernobyl.sturdyenigma.domain.Payment;
import com.projetochernobyl.sturdyenigma.domain.Product;
import com.projetochernobyl.sturdyenigma.domain.State;
import com.projetochernobyl.sturdyenigma.domain.enums.ClientType;
import com.projetochernobyl.sturdyenigma.domain.enums.PaymentSituation;
import com.projetochernobyl.sturdyenigma.repository.AddressRepository;
import com.projetochernobyl.sturdyenigma.repository.CategoryRepository;
import com.projetochernobyl.sturdyenigma.repository.CityRepository;
import com.projetochernobyl.sturdyenigma.repository.ClientRepository;
import com.projetochernobyl.sturdyenigma.repository.OrderRepository;
import com.projetochernobyl.sturdyenigma.repository.PaymentRepository;
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
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderRepository orderRepository;
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		Order or1 = new Order(null, sdf.parse("2017-09-30 10:32"), cli1, ad1);
		Order or2 = new Order(null, sdf.parse("2017-10-10 19:35"), cli1, ad2);
		
		Payment pay1 = new CreditPayment(null, PaymentSituation.PAYED, or1, 6);
		or1.setPayment(pay1);
		
		Payment pay2 = new CardPayment(null, PaymentSituation.PENDING, or2, sdf.parse("2017-02-20 00:00"), null);
		or2.setPayment(pay2);
		
		cli1.getOrders().addAll(Arrays.asList(or1, or2));
		
		orderRepository.saveAll(Arrays.asList(or1, or2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
	}

}
