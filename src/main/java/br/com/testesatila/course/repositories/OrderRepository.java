package br.com.testesatila.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testesatila.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{}
