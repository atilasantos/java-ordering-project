package br.com.testesatila.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.testesatila.course.entities.User;
import br.com.testesatila.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Atila Romáo", "atila.romao@hotmail.com", "11983311207", "764998");
		User u4 = new User(null, "Fernanda Suckow", "fe.suckow@gmail.com", "1122039922", "11122##$@#dsfs");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
	}
	
	
}
