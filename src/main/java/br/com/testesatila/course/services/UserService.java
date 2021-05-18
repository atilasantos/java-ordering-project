package br.com.testesatila.course.services;

import java.util.List;
import java.util.Optional;

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
	
	public User findById(Long id){
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}
	
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
}
