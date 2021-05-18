package br.com.testesatila.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.testesatila.course.entities.Category;
import br.com.testesatila.course.entities.Order;
import br.com.testesatila.course.entities.OrderItem;
import br.com.testesatila.course.entities.Payment;
import br.com.testesatila.course.entities.Product;
import br.com.testesatila.course.entities.User;
import br.com.testesatila.course.entities.enums.OrderStatus;
import br.com.testesatila.course.repositories.CategoryRepository;
import br.com.testesatila.course.repositories.OrderItemRepository;
import br.com.testesatila.course.repositories.OrderRepository;
import br.com.testesatila.course.repositories.ProductRepository;
import br.com.testesatila.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Atila Romáo", "atila.romao@hotmail.com", "11983311207", "764998");
		User u4 = new User(null, "Fernanda Suckow", "fe.suckow@gmail.com", "1122039922", "11122##$@#dsfs");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		
		Order o1 = new Order(null, Instant.parse("2019-01-12T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
		Order o2 = new Order(null, Instant.parse("2020-08-21T19:53:07Z"), u2, OrderStatus.CANCELED);
		Order o3 = new Order(null, Instant.parse("2021-09-26T19:53:07Z"), u3, OrderStatus.PAID);
		Order o4 = new Order(null, Instant.parse("1992-02-25T19:53:07Z"), u4, OrderStatus.PAID);
		Order o5 = new Order(null, Instant.parse("2011-03-24T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
		Order o6 = new Order(null, Instant.parse("2010-04-23T19:53:07Z"), u1, OrderStatus.SHIPPED);
		Order o7 = new Order(null, Instant.parse("2020-12-20T19:53:07Z"), u2, OrderStatus.PAID);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7));
		
		Category c1 = new Category(null,"Fashion");
		Category c2 = new Category(null,"Sports");
		Category c3 = new Category(null,"Fruits");
		Category c4 = new Category(null,"Electronics");
		Category c5 = new Category(null,"Geek");
		
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		
		Product p1 = new Product(null,"Billabong t-shirt", "Long sheeve t-shirt", 90.,"http://img.url");
		Product p2 = new Product(null,"Football ball", "WorldCup ball", 500.,"http://img.url");
		Product p3 = new Product(null,"Tobirama figure action", "Tobirama", 90.,"http://img.url");
		Product p4 = new Product(null,"Iphone", "Pro Max 12 512gb", 999.,"http://img.url");
		
		p1.getCategories().add(c5);
		p1.getCategories().add(c3);
		p2.getCategories().add(c2);
		p3.getCategories().add(c4);
		p4.getCategories().add(c1);
		p4.getCategories().add(c2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		OrderItem oi1 = new OrderItem(o1, p2, 2, p2.getPrice());
		OrderItem oi2 = new OrderItem(o1, p1, 1, p1.getPrice());
		OrderItem oi3 = new OrderItem(o2, p1, 4, p1.getPrice());
		OrderItem oi4 = new OrderItem(o2, p4, 2, p4.getPrice());
		OrderItem oi5 = new OrderItem(o2, p2, 5, p2.getPrice());
		OrderItem oi6 = new OrderItem(o3, p4, 1, p4.getPrice());
		OrderItem oi7 = new OrderItem(o3, p1, 2, p1.getPrice());
		OrderItem oi8 = new OrderItem(o4, p2, 6, p2.getPrice());
		OrderItem oi9 = new OrderItem(o5, p3, 5, p3.getPrice());
		OrderItem oi10 = new OrderItem(o6, p3, 8, p3.getPrice());
		OrderItem oi11 = new OrderItem(o7, p4, 3, p4.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4,oi5,oi6,oi7,oi8,oi9,oi10,oi11));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o3);
		o3.setPayment(pay1);
		orderRepository.save(o3);
	}
}
