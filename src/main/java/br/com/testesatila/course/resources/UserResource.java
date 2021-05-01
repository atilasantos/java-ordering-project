package br.com.testesatila.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testesatila.course.entities.User;
import br.com.testesatila.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findUsers(){
		List<User> listUsers = userService.findall();
		return ResponseEntity.ok().body(listUsers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(userService.findById(id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		if(userService.existsById(id)) {
			userService.deleteById(id);
			return ResponseEntity.ok().body("{\"status\":\"deleted\"}");
		}
		return ResponseEntity.notFound().build();
		
	}
}