package br.com.testesatila.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testesatila.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{}
