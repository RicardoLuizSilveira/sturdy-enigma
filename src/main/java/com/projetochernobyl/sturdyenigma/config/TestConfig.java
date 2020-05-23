package com.projetochernobyl.sturdyenigma.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetochernobyl.sturdyenigma.domain.Address;
import com.projetochernobyl.sturdyenigma.domain.PaymentBarrCode;
import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.domain.City;
import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.domain.PaymentCreditCard;
import com.projetochernobyl.sturdyenigma.domain.Order;
import com.projetochernobyl.sturdyenigma.domain.OrderItem;
import com.projetochernobyl.sturdyenigma.domain.Payment;
import com.projetochernobyl.sturdyenigma.domain.Product;
import com.projetochernobyl.sturdyenigma.domain.State;
import com.projetochernobyl.sturdyenigma.domain.enums.ClientType;
import com.projetochernobyl.sturdyenigma.domain.enums.PaymentSituation;
import com.projetochernobyl.sturdyenigma.repository.AddressRepository;
import com.projetochernobyl.sturdyenigma.repository.CategoryRepository;
import com.projetochernobyl.sturdyenigma.repository.CityRepository;
import com.projetochernobyl.sturdyenigma.repository.ClientRepository;
import com.projetochernobyl.sturdyenigma.repository.OrderItemRepository;
import com.projetochernobyl.sturdyenigma.repository.OrderRepository;
import com.projetochernobyl.sturdyenigma.repository.PaymentRepository;
import com.projetochernobyl.sturdyenigma.repository.ProductRepository;
import com.projetochernobyl.sturdyenigma.repository.StateRepository;

@Configuration
@Profile("dbtest")
public class TestConfig implements CommandLineRunner {

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
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "cat1 Electronics ");
		Category cat2 = new Category(null, "cat2 Books");
		Category cat3 = new Category(null, "cat3 Computers");
		Category cat4 = new Category(null, "cat4 Computers");
		Category cat5 = new Category(null, "cat5 Computers");
		Category cat6 = new Category(null, "cat6 Computers");
		Category cat7 = new Category(null, "cat7 Computers");
		Category cat8 = new Category(null, "cat8 Computers");
		Category cat9 = new Category(null, "cat9 Computers");
		Category cat10 = new Category(null, "cat10 Computers");
		Category cat11 = new Category(null, "cat11 Computers");
		Category cat12 = new Category(null, "cat12 Computers");
		Category cat13 = new Category(null, "cat13 Computers");
		Category cat14 = new Category(null, "cat14 Computers");
		Category cat15 = new Category(null, "cat15 Computers");
		Category cat16 = new Category(null, "cat16 Computers");
		Category cat17 = new Category(null, "cat17 Computers");
		Category cat18 = new Category(null, "cat18 Computers");
		Category cat19 = new Category(null, "cat19 Computers");
		Category cat20 = new Category(null, "cat20 Computers");
		Category cat21 = new Category(null, "cat21 Computers");
		Category cat22 = new Category(null, "cat22 Computers");

		Product p1 = new Product(null, "The Lord of the Rings", 90.5, cat2);
		Product p2 = new Product(null, "Smart TV", 2190.0, cat1);
		Product p3 = new Product(null, "Macbook Pro", 1250.0, cat3);
		Product p4 = new Product(null, "PC Gamer", 1200.0, cat3);
		Product p5 = new Product(null, "Rails for Dummies", 100.99, cat2);
		
		Product p6 = new Product(null, "Product 06", 100.99, cat3);
		Product p7 = new Product(null, "Product 07", 410.99, cat4);
		Product p8 = new Product(null, "Product 08", 110.99, cat5);
		Product p9 = new Product(null, "Product 09", 200.99, cat6);
		Product p10 = new Product(null, "Product 10", 300.99, cat6);
		Product p11 = new Product(null, "Product 11", 510.99, cat7);

		cat1.getProducts().addAll(Arrays.asList(p2));
		cat2.getProducts().addAll(Arrays.asList(p1, p5));
		cat3.getProducts().addAll(Arrays.asList(p3, p4, p6));
		cat4.getProducts().addAll(Arrays.asList(p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9, p10));
		cat7.getProducts().addAll(Arrays.asList(p11));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11,
				cat12, cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20, cat21, cat22));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

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

		Payment pay1 = new PaymentCreditCard(null, PaymentSituation.PAYED, or1, 6);
		or1.setPayment(pay1);

		Payment pay2 = new PaymentBarrCode(null, PaymentSituation.PENDING, or2, sdf.parse("2017-02-20 00:00"), null);
		or2.setPayment(pay2);

		cli1.getOrders().addAll(Arrays.asList(or1, or2));

		orderRepository.saveAll(Arrays.asList(or1, or2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		OrderItem oi1 = new OrderItem(or1, p1, 0.0, 1, p1.getPrice());
		OrderItem oi2 = new OrderItem(or1, p3, 0.0, 2, p3.getPrice());
		OrderItem oi3 = new OrderItem(or2, p2, 100.0, 1, p2.getPrice());

		or1.getItens().addAll(Arrays.asList(oi1, oi2));
		or2.getItens().add(oi3);

		p1.getItens().add(oi1);
		p2.getItens().add(oi3);
		p3.getItens().add(oi2);
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}

}
