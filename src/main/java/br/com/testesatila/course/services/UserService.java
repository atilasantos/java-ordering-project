package br.com.testesatila.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testesatila.course.entities.User;
import br.com.testesatila.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findall(){
		return userRepository.findAll();
	}
}
