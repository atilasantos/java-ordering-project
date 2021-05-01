package br.com.testesatila.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testesatila.course.entities.Product;
import br.com.testesatila.course.services.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductResource {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok().body(productService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(productService.findById(id));
	}
}
