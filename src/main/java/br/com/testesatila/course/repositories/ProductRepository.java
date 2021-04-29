package br.com.testesatila.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testesatila.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{}
