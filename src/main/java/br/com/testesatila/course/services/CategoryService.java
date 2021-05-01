package br.com.testesatila.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testesatila.course.entities.Category;
import br.com.testesatila.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository orderRepository;
	
	public List<Category> findAll(){
		return orderRepository.findAll();
	}
	
	public Category findById(Long id) {
		return orderRepository.findById(id).get();
	}
}
