package br.com.testesatila.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testesatila.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
