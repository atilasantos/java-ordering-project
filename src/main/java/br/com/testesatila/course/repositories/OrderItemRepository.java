package br.com.testesatila.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testesatila.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{}
