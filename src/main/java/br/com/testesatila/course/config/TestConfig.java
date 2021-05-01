package br.com.testesatila.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.testesatila.course.entities.Category;
import br.com.testesatila.course.entities.Order;
import br.com.testesatila.course.entities.User;
import br.com.testesatila.course.entities.enums.OrderStatus;
import br.com.testesatila.course.repositories.CategoryRepository;
import br.com.testesatila.course.repositories.OrderRepository;
import br.com.testesatila.course.repositories.UserRepository;
import br.com.testesatila.course.services.CategoryService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

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
	}
	
	
}
